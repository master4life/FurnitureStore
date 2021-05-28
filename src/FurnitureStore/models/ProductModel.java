package FurnitureStore.models;

public class ProductModel {

    private Integer id;
    private Integer categorie;
    private String material;
    private Double price;
    private String size;
    private String description;
    private Integer amount;

    public ProductModel(int id, int categorie, String material, double price, String size, String description, int amount) {
        this.id = Integer.valueOf(id);
        this.categorie =  Integer.valueOf(categorie);
        this.material = material;
        this.price = Double.valueOf(price);
        this.size = size;
        this.description = description;
        this.amount = Integer.valueOf(amount);
    }

    public ProductModel(int categorie, String material, double price, String size, String description, int amount) {
        this.categorie =  Integer.valueOf(categorie);
        this.material = material;
        this.price = Double.valueOf(price);
        this.size = size;
        this.description = description;
        this.amount = Integer.valueOf(amount);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategorie() {
        return categorie;
    }

    public void setCategorie(Integer categorie) {
        this.categorie = categorie;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
