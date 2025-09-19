package pharmacy.managment.system;

import java.util.ArrayList;
import java.util.Date;


class Supplier extends User{
	 
    private int supplierId;
    private String supplierName;

    public Supplier() {}

    public Supplier(int supplierId, String supplierName, int userId, String userName, String userType) {
        super(userId, userName, userType);
        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }


    public int numberOfOrders(ArrayList<Order> orders) {
        int orderCount = 0;
        for (Order order : orders) {
            if (order.getProduct().equals(this)) {
                orderCount++;
            }
        }
        return orderCount;
    }

    public double totalRevenue(ArrayList<Order> orders) {
        double totalRevenue = 0;
        for (Order order : orders) {
            if (order.getProduct().getSupplier().equals(this)) {
                totalRevenue += order.getProduct().getPrice() * order.getQuantity();
            }
        }
        return totalRevenue;
    }

    @Override
    public String toString() {
        return "Supplier{" + "supplierId=" + supplierId + ", supplierName=" + supplierName + '}';
    }
    
    
}


