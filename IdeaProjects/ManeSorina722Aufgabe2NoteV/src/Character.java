import java.util.ArrayList;
import java.util.List;

public class Character {

    private int id;
    private String name;
    private String village;
    List<Product> boughtProducts;

    public Character(int id, String name, String village) {
        this.id = id;
        this.name = name;
        this.village = village;
        this.boughtProducts=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public List<Product> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(List<Product> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }

    public void addProduct(Product product){
        boughtProducts.add(product);
    }

    public void removeProduct(Product product){
        boughtProducts.remove(product);
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", village='" + village + '\'' +
                ", boughtProducts=" + boughtProducts +
                '}';
    }
}
