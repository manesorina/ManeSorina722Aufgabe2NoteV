import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        IMRepository<Product> productRepo=new IMRepository<>();
        IMRepository<Character> characterRepo=new IMRepository<>();

        Service service=new Service(characterRepo,productRepo);
        Console console=new Console(service);


        List<Product> produkte = new ArrayList<>();
        Product p0=new Product("Kunai", 50.0, "Konoha");
        Product p1=new Product("Shuriken", 30.0, "Konoha");
        Product p2=new Product("Schwert", 200.0, "Kirigakure");
        Product p3=new Product("Heiltrank", 100.0, "Sunagakure");
        Product p4=new Product("Sprengsiegel", 75.0, "Iwagakure");
        Product p5=new Product("Riesenfächer", 300.0, "Sunagakure");
        Product p6=new Product("Giftklinge", 150.0, "Kirigakure");
        Product p7=new Product("Explosionskugel", 250.0, "Iwagakure");
        Product p8=new Product("Schattendolch", 180.0, "Konoha");
        Product p9=new Product("Wasserperle", 90.0, "Kirigakure");

        productRepo.create(p0);
        productRepo.create(p1);
        productRepo.create(p2);
        productRepo.create(p3);
        productRepo.create(p4);
        productRepo.create(p5);
        productRepo.create(p6);
        productRepo.create(p7);
        productRepo.create(p8);
        productRepo.create(p9);




        List<Character> charaktere = new ArrayList<>();
        Character c1 = new Character(1, "Naruto Uzumaki", "Konoha");
        characterRepo.create(c1);

        service.buyProduct(c1.getId(),p0.getName());// Kunai
        service.buyProduct(c1.getId(),p3.getName());// Heiltrank
        service.buyProduct(c1.getId(),p8.getName());// Schattendolch
        service.buyProduct(c1.getId(),p5.getName());// Riesenfächer

        Character c2 = new Character(2, "Gaara", "Sunagakure");
        characterRepo.create(c2);
        service.buyProduct(c2.getId(),p2.getName());// Schwert
        service.buyProduct(c2.getId(),p4.getName());// Sprengsiegel
        service.buyProduct(c2.getId(),p6.getName());
        service.buyProduct(c2.getId(),p1.getName());




        Character c3 = new Character(3, "Kisame Hoshigaki", "Kirigakure");
        characterRepo.create(c3);
        service.buyProduct(c3.getId(),p1.getName());
        service.buyProduct(c3.getId(),p2.getName());
        service.buyProduct(c3.getId(),p3.getName());
        service.buyProduct(c3.getId(),p7.getName());
        service.buyProduct(c3.getId(),p9.getName());


        Character c4 = new Character(4, "Deidara", "Iwagakure");
        characterRepo.create(c4);
        service.buyProduct(c4.getId(),p0.getName());
        service.buyProduct(c4.getId(),p4.getName());
        service.buyProduct(c4.getId(),p7.getName());
        service.buyProduct(c4.getId(),p9.getName());


        Character c5 = new Character(5, "Itachi Uchiha", "Konoha");
        characterRepo.create(c5);
        service.buyProduct(c5.getId(),p8.getName());
        service.buyProduct(c5.getId(),p6.getName());
        service.buyProduct(c5.getId(),p2.getName());
        service.buyProduct(c5.getId(),p7.getName());







        console.start();
    }
}