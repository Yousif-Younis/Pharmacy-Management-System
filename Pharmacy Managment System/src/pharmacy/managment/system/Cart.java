package pharmacy.managment.system;


import java.util.ArrayList;
import java.util.List;


class Cart {
    private ArrayList<Order> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public Cart(ArrayList<Order> cartItems) {
        this.cartItems = cartItems;
    }
    
    public ArrayList<Order> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<Order> cartItems) {
        this.cartItems = cartItems;
    }
    
    public void addProduct(Product product, int quantity) {
        Order order = new Order(product, quantity);
        cartItems.add(order);
        System.out.println(quantity + " " + product.getProductName() + " added to the cart.");
    }

    public void removeProduct(Product product, int quantity) {
        Order orderToRemove = new Order(product, quantity);
        if (cartItems.contains(orderToRemove)) {
            cartItems.remove(orderToRemove);
            System.out.println(quantity + " " + product.getProductName() + " removed from the cart.");
        } else {
            System.out.println("Product not found in the cart.");
        }
    }

    public void viewCart() {
        System.out.println("Cart Items:");
        for (Order order : cartItems) {
            order.viewDetails();
            System.out.println("---------------");
        }
    }

    public void clearCart() {
        cartItems.clear();
        System.out.println("Cart cleared.");
    }

    @Override
    public String toString() {
        return "Cart{" + "cartItems=" + cartItems + '}';
    }

}