package FurnitureStore.models;

public class ProductModel {

    private Integer id;
    private Integer categorie;
    private String strCategorie;
    private String material;
    private Double price;
    private String size;
    private String name;
    private Integer amount;

    public ProductModel(int id, int categorie, String material, double price, String size, String name, int amount) {
        this.id = Integer.valueOf(id);
        this.categorie =  Integer.valueOf(categorie);
        this.material = material;
        this.price = Double.valueOf(price);
        this.size = size;
        this.name = name;
        this.amount = Integer.valueOf(amount);
        this.strCategorie = categorieStr(categorie);
    }

    public ProductModel(int categorie, String material, double price, String size, String name, int amount) {
        this.categorie =  Integer.valueOf(categorie);
        this.material = material;
        this.price = Double.valueOf(price);
        this.size = size;
        this.name = name;
        this.amount = Integer.valueOf(amount);
        this.strCategorie = categorieStr(categorie);
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

    public String getName() {
        return name;
    }

    public void setDescription(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStrCategorie() {
        return strCategorie;
    }

    public void setStrCategorie(String strCategorie) {
        this.strCategorie = strCategorie;
    }

    public static String categorieStr(int categorie){
        switch (categorie){
            case 1: return "accessoire";
            case 2: return "table";
            case 3: return "closet";
            case 4: return "sofa";
            case 5: return "bed";
            case 6: return "chair";
            case 7: return "shelf";
            case 8: return "refrigerator";
        }
        return "";
    }

    public static int categorieInt(String categorie){
        switch (categorie){
            case "accessoire": return 1;
            case "table": return 2;
            case "closet": return 3;
            case "sofa": return 4;
            case "bed": return 5;
            case "chair": return 6;
            case "shelf": return 7;
            case "refrigerator": return 8;
        }
        return 0;
    }
}
