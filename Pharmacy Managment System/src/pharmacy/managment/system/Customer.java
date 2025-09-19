package pharmacy.managment.system;


import java.util.ArrayList;
import java.util.Date;


class Customer extends User{

    private int customerId;
    private String customerName;
    private ArrayList<Order> orderHistory;

    public Customer(int userId, String userName, String userType) {
        super(userId, userName, userType);
    }
    
    public Customer(int customerId, String customerName, ArrayList<Order> orderHistory, int userId, String userName, String userType) {
        super(userId, userName, userType);
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderHistory = orderHistory;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public int numberOfOrders(ArrayList<Order> orders) {
        int orderCount = 0;
        for (Order order : orders) {
            if (order.getUser().equals(this)) {
                orderCount++;
            }
        }
        return orderCount;
    }

    public double totalRevenue(ArrayList<Order> orders) {
        double totalRevenue = 0;
        for (Order order : orders) {
            if (order.getUser().equals(this)) {
                totalRevenue += order.getProduct().getPrice() * order.getQuantity();
            }
        }
        return totalRevenue;
    }
	
    public void addOrderToHistory(Order order) {
        orderHistory.add(order);
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void viewOrderHistory() {
        for (Order order : orderHistory) {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Product: " + order.getProduct().getProductName());
            System.out.println("Quantity: " + order.getQuantity());
            System.out.println("Order Date: " + order.getOrderDate());
            System.out.println("---------------");
        }
    }
	
    public void viewOrderDetails(int orderId) {
        for (Order order : orderHistory) {
            if (order.getOrderId() == orderId) {
                order.viewDetails();
                return;
            }
        }
        System.out.println("Order not found with ID: " + orderId);
    }
	
    public void rateOrder(int orderId, int rating) {
        for (Order order : orderHistory) {
            if (order.getOrderId() == orderId) {
                order.setRating(rating);
                System.out.println("Order rated successfully.");
                return;
            }
        }
        System.out.println("Order not found with ID: " + orderId);
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", customerName=" + customerName + ", orderHistory=" + orderHistory + '}';
    }
    
    


}
