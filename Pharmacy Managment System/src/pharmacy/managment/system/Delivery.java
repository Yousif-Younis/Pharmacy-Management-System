package pharmacy.managment.system;


import java.util.Date;

class Delivery {
	
    private int deliveryId;
    private Order order;
    private String deliveryAddress;
    private Date deliveryDate;
    private boolean isCompleted;

    public Delivery() {}

    public Delivery(int deliveryId, Order order, String deliveryAddress, Date deliveryDate) {
        this.deliveryId = deliveryId;
        this.order = order;
        this.deliveryAddress = deliveryAddress;
        this.deliveryDate = deliveryDate;
	this.isCompleted = false;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
	
	public boolean isCompleted() {
        return isCompleted;
    }

    public void processDelivery() {
        if (!isCompleted) {
            // Simulate delivery processing
            System.out.println("Processing delivery for Order ID: " + order.getOrderId());
            
            // Simulate delivery time
            try {
                Thread.sleep(2000); // Sleep for 2 seconds to simulate delivery processing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Delivery for Order ID: " + order.getOrderId() + " completed!");
            isCompleted = true;
        } else {
            System.out.println("Delivery for Order ID: " + order.getOrderId() + " is already completed.");
        }
    }

    @Override
    public String toString() {
        return "Delivery{" + "deliveryId=" + deliveryId + ", order=" + order + ", deliveryAddress=" + deliveryAddress + ", deliveryDate=" + deliveryDate + ", isCompleted=" + isCompleted + '}';
    }

}
