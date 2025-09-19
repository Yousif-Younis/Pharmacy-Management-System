package pharmacy.managment.system;

import java.util.Date;

public class Refund {

    private int refundId;
    private Order order;
    private Date refundDate;
    private double refundAmount;

    // Constructor
    public Refund(int refundId, Order order, Date refundDate, double refundAmount) {
        this.refundId = refundId;
        this.order = order;
        this.refundDate = refundDate;
        this.refundAmount = refundAmount;
    }

    // Getter and Setter methods

    public int getRefundId() {
        return refundId;
    }

    public void setRefundId(int refundId) {
        this.refundId = refundId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(double refundAmount) {
        this.refundAmount = refundAmount;
    }

    // Additional methods if needed

    public void processRefund() {

        Stock stock = new Stock(); 

        Product refundedProduct = order.getProduct();
        int refundedQuantity = order.getQuantity();

        stock.increaseProductQuantity(refundedProduct, refundedQuantity);
        order.setOrderStatus(OrderStatus.REFUNDED);

        System.out.println("Refund processed successfully for Order ID: " + order.getOrderId());
    }

    public void displayRefundDetails() {
        System.out.println("Refund ID: " + refundId);
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Refund Date: " + refundDate);
        System.out.println("Refund Amount: " + refundAmount);
    }

    @Override
    public String toString() {
        return "Refund{" + "refundId=" + refundId + ", order=" + order + ", refundDate=" + refundDate + ", refundAmount=" + refundAmount + '}';
    }
    
    
}
