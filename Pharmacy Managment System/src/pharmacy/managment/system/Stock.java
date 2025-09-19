package pharmacy.managment.system;


import java.util.HashMap;
import java.util.Map;


public class Stock {
    private Map<Integer, Integer> productQuantities;  // Map productId to available quantity

    public Stock() {
        this.productQuantities = new HashMap<>();
    }

    public Stock(HashMap<Integer, Integer> productQuantities) {
        this.productQuantities = productQuantities;
    }
    
    public void addProduct(Product product, int initialQuantity) {
        if (!productQuantities.containsKey(product.getProductId())) {
            productQuantities.put(product.getProductId(), initialQuantity);
        } else {
            // If the product already exists in the stock, update the quantity
            int existingQuantity = productQuantities.get(product.getProductId());
            productQuantities.put(product.getProductId(), existingQuantity + initialQuantity);
        }
    }

    public void updateProductQuantity(Product product, int newQuantity) {
        if (productQuantities.containsKey(product.getProductId())) {
            productQuantities.put(product.getProductId(), newQuantity);
        } else {
            // Handle the case where the product is not in the stock
            System.out.println("Product not found in the stock.");
        }
    }

    public int getProductQuantity(Product product) {
        return productQuantities.getOrDefault(product.getProductId(), 0);
    }
    
    public void increaseProductQuantity(Product product, int quantity) {
        int productId = product.getProductId();
        int currentQuantity = productQuantities.getOrDefault(productId, 0);
        productQuantities.put(productId, currentQuantity + quantity);
        System.out.println("Product quantity increased in stock: " + product.getProductName());
    }
    
    

    public void displayStock() {
        System.out.println("Stock:");
        for (Map.Entry<Integer, Integer> entry : productQuantities.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Product ID: " + productId + ", Quantity: " + quantity);
        }
    }

    @Override
    public String toString() {
        return "Stock{" + "productQuantities=" + productQuantities + '}';
    }
    
}
