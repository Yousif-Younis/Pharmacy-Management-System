    package pharmacy.managment.system;
import java.util.ArrayList;
import java.util.Date;


class Product {

    private int productId;
    private String productName;
    private double price;
    private int warranty;

    public Product() {}
    
    public Product(int productId, String productName, double price, int warranty) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.warranty = warranty;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId 
                + ", productName=" + productName 
                + ", price=" + price + ", warranty=" 
                + warranty + '}';
    }

    
    Object getSupplier() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setSupplier(Supplier supplier1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}