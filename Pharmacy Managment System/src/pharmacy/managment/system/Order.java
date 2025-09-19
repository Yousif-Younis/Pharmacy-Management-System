package pharmacy.managment.system;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class Order {

    private int orderId;
    private User user;
    private Product product;
    private int quantity;
    private Date orderDate;
    private int rating;
    private Cart cart;
    private OrderStatus orderStatus;
    private Delivery delivery;
    private Stock stock;
    
    public Order(){}

//    public Order(Product product, int quantity) {
//        this.product = product;
//        this.quantity = quantity;
//    }

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        
    }

    
    public Order(int orderId, User user, Product product, int quantity, Date orderDate) {
        this.orderId = orderId;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public Order(int orderId, User user, Product product, int quantity, Date orderDate, int rating, Cart cart,  Delivery delivery, Stock stock) {
        this.orderId = orderId;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.rating = rating;
        this.cart = cart;
        this.delivery = delivery;
        this.stock = stock;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
	
	public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void viewDetails() {
        try{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Order ID: " + orderId);
        System.out.println("User: " + user.getUserName());
        System.out.println("Product: " + product.getProductName());
        System.out.println("Quantity: " + quantity);
        System.out.println("Order Date: " + dateFormat.format(orderDate));
        }
        catch(Exception e){
            System.out.println( "Error formatting date : " + e.getMessage());
        }
        
    }

    public void calculateTotal() {
        double total = product.getPrice() * quantity;
        System.out.println("Total Price: " + total);
    }
	
    public void viewProducts() {
        System.out.println("Product ID: " + product.getProductId());
        System.out.println("Product Name: " + product.getProductName());
        System.out.println("Price: " + product.getPrice());
        
    }
	
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        System.out.println("Order status updated: " + orderStatus);
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", user=" + user + ", product=" + product + ", quantity=" + quantity + ", orderDate=" + orderDate + ", rating=" + rating + ", cart=" + cart + ", orderStatus=" + orderStatus + ", delivery=" + delivery + ", stock=" + stock + '}';
    }

}