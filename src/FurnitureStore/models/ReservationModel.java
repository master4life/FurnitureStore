package FurnitureStore.models;

public class ReservationModel {

    private Integer id;
    private String date;
    private Double totalPrice;

    public ReservationModel(int id, String date, double totalPrice) {
        this.id = Integer.valueOf(id);
        this.date = date;
        this.totalPrice = Double.valueOf(totalPrice);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
