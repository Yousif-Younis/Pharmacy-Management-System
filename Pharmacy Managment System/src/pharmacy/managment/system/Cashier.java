package pharmacy.managment.system;

import java.text.SimpleDateFormat;
import java.util.Date;


class Cashier extends User {

    public Cashier() {}
    
    public Cashier(int userId, String userName) {
        super(userId, userName, "Cashier");
    }

    public Cart createCart() {
        return new Cart();
    }
    
    public double calculatePayment(Cart cart) {
        double totalPayment = 0;
        for (Order order : cart.getCartItems()) {
            totalPayment += order.getProduct().getPrice() * order.getQuantity();
        }
        System.out.println("Total Payment: " + totalPayment);
        return totalPayment;
    }
    
    public void cancelCart(Cart cart) {
        cart.clearCart();
        System.out.println("Cart canceled.");
    }
	
    public Delivery initiateDelivery(Order order, String deliveryAddress, Date deliveryDate) {
        // Assuming a delivery service is external, and this method initiates the delivery
        Delivery delivery = new Delivery((int) generateDeliveryId(), order, deliveryAddress, deliveryDate);
        delivery.processDelivery();
        return delivery;
        }

   public static double generateDeliveryId() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        String uniqueIdentifier = String.format("%s.%s", timestamp, Math.random());

        return Double.parseDouble(uniqueIdentifier);
    }

    public boolean isDeliveryCompleted(Delivery delivery) {
        return delivery.isCompleted();
    }

	
}

