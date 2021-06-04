package FurnitureStore.customer;

public class CartItem {

    private Integer id;
    private String type;
    private Integer amount;
    private Double totalPrice;

    public CartItem(int id, String type, int amount, double totalPrice) {
        this.id = Integer.valueOf(id);
        this.type = type;
        this.amount = Integer.valueOf(amount);
        this.totalPrice = Double.valueOf(totalPrice);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
