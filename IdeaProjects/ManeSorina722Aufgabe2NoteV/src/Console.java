import java.util.List;
import java.util.Scanner;

public class Console {
    private final Service service;
    private final Scanner scanner = new Scanner(System.in);

    public Console(Service service) {
        this.service = service;
    }

    public void start() {

        boolean running = true;
        while (running) {
            System.out.println("Welcome ");
            System.out.println("1. See all Products ");
            System.out.println("2. Add Product");
            System.out.println("3. Delete Product ");
            System.out.println("4. Update Product Price");
            System.out.println("5. Update Product Region");
            System.out.println("6. See all Characters");
            System.out.println("7. Add Character");
            System.out.println("8. Delete Character");
            System.out.println("9. Update Character Name");
            System.out.println("10. Buy product");
            System.out.println("11. Delete from bought products");
            System.out.println("12. Filter Characters by village");
            System.out.println("13.See Characters that bought products from given region");
            System.out.println("14. Sort characters products by price ");
            System.out.println("0. Exit");
            System.out.print("Please select an option: ");

            int choice;
            while (true) {
                try {
                    String input = scanner.nextLine();
                    if (!input.matches("\\d+")) {
                        throw new Exception("Input must be a number.");
                    }
                    choice = Integer.parseInt(input);
                    if (choice < 0 || choice > 16) {
                        throw new Exception("Please enter a number between 0 and 4.");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input: " + e.getMessage());
                    System.out.print("Please select a valid option: ");
                }
            }

            switch (choice) {
                case 1 -> printAllP();
                case 2 -> addP();
                case 3 -> deleteP();
                case 4 -> updatePPrice();
                case 5 -> updatePRegion();
                case 6 -> printAllCharacters();
                case 7 -> addC();
                case 8 -> deleteC();
                case 9 -> updateCName();
                case 10 -> buyProduct();
                case 11 -> deleteFromBoughtProducts();
                case 12 -> filterChByVillage();
                case 13 ->  charactersThatBoughtFromGivenRegion();
                case 14 -> sortCharactersProductByPrice();


                case 0 -> {
                    running = false;
                }
            }
        }


    }


    public void printAllP(){
        service.getAllProducts().forEach(System.out::println);
    }

    public void addP(){
        System.out.println("Enter for new name, price and region ");
        String name=scanner.nextLine();
        double price=scanner.nextDouble();
        scanner.nextLine();
        String disease=scanner.nextLine();
        service.addProduct(name,price,disease);
    }

    public void deleteP(){
        System.out.println("Enter the name of the product to delete");
        String name=scanner.nextLine();
        service.deleteProduct(name);
    }

    public void updatePPrice(){
        System.out.println("Enter the name of the product and the new price ");
        String name=scanner.nextLine();
        double newPrice= scanner.nextDouble();
        scanner.nextLine();
        service.updateProductPrice(name,newPrice);
    }

    public void updatePRegion(){
        System.out.println("Enter the name of the product and the new region ");
        String name=scanner.nextLine();
        String newRegion=scanner.nextLine();
        service.updateProductRegion(name,newRegion);
    }

    public void printAllCharacters(){
        (service.getAllCharacter()).forEach(System.out::println);
    }

    public void addC(){
        System.out.println("Enter the id the name and the village ");
        int id= scanner.nextInt();
        scanner.nextLine();
        String name=scanner.nextLine();
        String village =scanner.nextLine();
        service.addCharacter(id,name,village);
    }

    public void deleteC(){
        System.out.println("Enter the id of the Character  to delete");
        int id=scanner.nextInt();
        service.deleteCharacter(id);
    }

    public void updateCName(){
        System.out.println("Enter the id of the character and the new name ");
        int id= scanner.nextInt();
        scanner.nextLine();
        String newName=scanner.nextLine();

        service.updateCharacterName(id,newName);
    }




    public void buyProduct(){
        System.out.println("Enter the id of the character and the name of the product to be bought");;
        int id=scanner.nextInt();
        scanner.nextLine();
        String name=scanner.nextLine();
        service.buyProduct(id,name);
    }

    public void deleteFromBoughtProducts(){
        System.out.println("Enter the id of the character and the name of the bought product to be deleted");;
        int id=scanner.nextInt();
        scanner.nextLine();
        String name=scanner.nextLine();
        service.removeBoughtProduct(id,name);
    }

    public void filterChByVillage(){
        System.out.println("Enter the Village to filter by");
        String village=scanner.nextLine();
        (service.filterCharactersByVillage(village)).forEach(System.out::println);
    }

    public void charactersThatBoughtFromGivenRegion(){
        System.out.println("Enter the region");
        String region=scanner.nextLine();
        (service.charactersBoughtProductsFromGivenRegion(region)).forEach(System.out::println);
    }

    public void sortCharactersProductByPrice(){
        System.out.println("Enter the id of the character you want to sort the products for");
        int id= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Do you want to sort by  ");
        System.out.println("1.Ascending");
        System.out.println("2.Descending");
        int choice;
        while (true) {
            try {
                String input = scanner.nextLine();
                if (!input.matches("\\d+")) {
                    throw new Exception("Input must be a number.");
                }
                choice = Integer.parseInt(input);
                if (choice < 0 || choice > 2) {
                    throw new Exception("Please enter a number between 0 and 2.");
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input: " + e.getMessage());
                System.out.print("Please select a valid option: ");
            }
        }

        switch (choice) {
            case 1 -> {
                (service.sortProductsBoughtByChByPriceAscending(id)).forEach(System.out::println);
            }
            case 2 -> (service.sortProductsBoughtByChByPriceDescending(id)).forEach(System.out::println);
        }
    }






}
