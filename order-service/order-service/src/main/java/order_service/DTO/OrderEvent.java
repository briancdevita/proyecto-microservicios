package order_service.DTO;




public class OrderEvent {
    public OrderEvent() {
    }

    public OrderEvent(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    private String product;
    private int quantity;

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderEvent{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }


}
