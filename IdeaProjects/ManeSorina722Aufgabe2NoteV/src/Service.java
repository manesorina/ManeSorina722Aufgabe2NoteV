import java.util.*;
import java.util.stream.Collectors;

public class Service {

    IMRepository<Character> characterRepo;
    IMRepository<Product> productRepo;

    public Service(IMRepository<Character> characterRepo, IMRepository<Product> productRepo) {
        this.characterRepo = characterRepo;
        this.productRepo = productRepo;
    }


    public List<Character> getAllCharacter() {
        return characterRepo.getAll();

    }

    public void addCharacter(int id,String name, String village){
        Character character= new Character(id,name,village) ;
        characterRepo.create(character);
    }


    public boolean deleteCharacter(int id){
        if(id<=0){
            return false;
        }
        characterRepo.delete(id);
        return true;
    }

    public boolean updateCharacterName(int id, String newName) {
        if (id <= 0 || newName == null || newName.trim().isEmpty()) {
            return false;
        }
        Character character=characterRepo.read(id);
        if (character == null) {
            return false;
        }
        character.setName(newName);
        characterRepo.update(id,character);
        return true;
    }


    //name
    public boolean buyProduct(int characterId,String name){
        if (characterId <= 0 && name == null) {
            return false;
        }

        Character character=characterRepo.read(characterId);
        Product product=productRepo.readProduct(name);

        if(character==null && product==null){
            return false;
        }

        character.addProduct(product);
        characterRepo.update(characterId,character);
        return true;
    }


    public boolean removeBoughtProduct(int id,String name){
        if (id <= 0 && name == null) {
            return false;
        }

        Character character=characterRepo.read(id);
        Product product=productRepo.readProduct(name);

        if(character==null && product==null){
            return false;
        }

        if (!character.getBoughtProducts().contains(product)) {
            System.out.println("Product not bought by this character");
            return false;
        }

        character.removeProduct(product);
        characterRepo.update(id,character);
        return true;
    }

    public List<Product> getAllProducts(){
        return productRepo.getAll();
    }

    public void addProduct(String name, double price, String region){
        Product product=new Product(name, price, region);
        productRepo.create(product);
    }


    public boolean deleteProduct(String name){
        if(name==null){
            return false;
        }
        productRepo.deleteProduct(name);
        return true;
    }

    public boolean updateProductPrice(String name,double newPrice){
        if(newPrice<=0){
            return false;
        }
        Product product=productRepo.readProduct(name);
        if(product==null){
            return false;
        }
        product.setPrice(newPrice);
        productRepo.updateProduct(name,product);
        return  true;

    }


    public boolean updateProductRegion(String name,String newRegion){
        if(newRegion==null){
            return false;
        }
        Product product=productRepo.readProduct(name);
        if(product==null){
            return false;
        }
        product.setRegion(newRegion);
        productRepo.updateProduct(name,product);
        return  true;

    }


    public List<Character> filterCharactersByVillage(String village){
        return characterRepo.getAll().stream().filter(character -> character.getVillage().toLowerCase().contains(village.toLowerCase())).toList();
    }


    public List<Character> charactersBoughtProductsFromGivenRegion(String region){
        List<Product> productsFromGivenRegion=new ArrayList<>();
        Set<Character> targetedCh=new HashSet<>();

        for(Product product:productRepo.getAll()){
            if(Objects.equals(product.getRegion(),region)){
                productsFromGivenRegion.add(product);
            }
        }

        for(Character ch:characterRepo.getAll()){
            for(Product p:productsFromGivenRegion){
                if (ch.getBoughtProducts().contains(p)){
                    targetedCh.add(ch);
                    break;
                }
            }
        }
        return new ArrayList<>(targetedCh);
    }







    public List<Product> sortProductsBoughtByChByPriceAscending(int id){
        Character ch=characterRepo.read(id);
        return ch.getBoughtProducts().stream().sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());
    }

    public List<Product> sortProductsBoughtByChByPriceDescending(int id){
        Character ch=characterRepo.read(id);
        return ch.getBoughtProducts().stream().sorted(Comparator.comparing(Product::getPrice).reversed()).toList();
    }





}






