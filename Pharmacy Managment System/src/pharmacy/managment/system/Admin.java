package pharmacy.managment.system;
// Association "has-a" relationship
// Aggregation "has-a" relationship
// Composition "part-of" relationship


// Association "has-a" relationship 
// Aggregation "has-a" relationship 
// Composition "part-of" relationship


import java.util.ArrayList;
import java.util.Date;


public class Admin {

    private ArrayList<Product> products;
    private ArrayList<User> users;
    private ArrayList<Order> orders;
    private ArrayList<Customer> customers;
    private ArrayList<Supplier> suppliers;

    public Admin() {
        this.products = new ArrayList<>();
        this.users = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.suppliers = new ArrayList<>();
    }

    public Admin(ArrayList<Product> products, ArrayList<User> users, ArrayList<Order> orders, ArrayList<Customer> customers, ArrayList<Supplier> suppliers) {
        this.products = products;
        this.users = users;
        this.orders = orders;
        this.customers = customers;
        this.suppliers = suppliers;
    }
    
// Product Management
    public void addProduct(Product product) {
        products.add(product);
    }

    public void editProduct(Product product) {
        int index = findProductIndex(product.getProductId());
        if (index != -1) {
            products.set(index, product);
        }
    }

    public void removeProduct(int productId) {
        int index = findProductIndex(productId);
        if (index != -1) {
            products.remove(index);
        }
    }

    public ArrayList<Product> searchProducts(String keyword) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().contains(keyword) || String.valueOf(product.getPrice()).contains(keyword)) {
                result.add(product);
            }
        }
        return result;
    }

// Reports/Data about Products
    public int piecesSoldOverPeriod(Date startDate, Date endDate) {
        int totalPiecesSold = 0;
        for (Order order : orders) {
            if (order.getOrderDate().after(startDate) && order.getOrderDate().before(endDate)) {
                totalPiecesSold += order.getQuantity();
                
            }
        }
        return totalPiecesSold;
    }

    public ArrayList<String> listSuppliersAndPricing() {
        ArrayList<String> supplierInfoList = new ArrayList<>();
        for (Product product : products) {
            supplierInfoList.add("Supplier: " + product.getSupplier() + ", Price: " + product.getPrice());
        }
        return supplierInfoList;
    }

    public Product bestSellerOverPeriod(Date startDate, Date endDate) {
        Product bestSeller = null;
        int maxQuantitySold = 0;

        for (Product product : products) {
            int quantitySold = 0;

            for (Order order : orders) {
                if (order.getProduct().equals(product) &&
                        order.getOrderDate().after(startDate) &&
                        order.getOrderDate().before(endDate)) {
                    quantitySold += order.getQuantity();
                }
            }

            if (quantitySold > maxQuantitySold) {
                maxQuantitySold = quantitySold;
                bestSeller = product;
            }
        }

        return bestSeller;
    }

    public Product mostRevenueProductOverPeriod(Date startDate, Date endDate) {
        Product mostRevenueProduct = null;
        double maxRevenue = 0;

        for (Product product : products) {
            double revenue = 0;

            for (Order order : orders) {
                if (order.getProduct().equals(product) &&
                        order.getOrderDate().after(startDate) &&
                        order.getOrderDate().before(endDate)) {
                    revenue += order.getProduct().getPrice() * order.getQuantity();
                }
            }

            if (revenue > maxRevenue) {
                maxRevenue = revenue;
                mostRevenueProduct = product;
            }
        }

        return mostRevenueProduct;
    }

// User Management
    public void addUser(User user) {
        users.add(user);
    }

    public void editUser(User user) {
        int index = findUserIndex(user.getUserId());
        if (index != -1) {
            users.set(index, user);
        }
    }

    public void removeUser(int userId) {
        int index = findUserIndex(userId);
        if (index != -1) {
            users.remove(index);
        }
    }

    public ArrayList<User> searchUsers(String keyword) {
        ArrayList<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getUserName().contains(keyword) || user.getUserType().contains(keyword)) {
                result.add(user);
            }
        }
        return result;
    }
    
    public ArrayList<User> listAllUsers() {
        return users;
    }

/* Reports/Data about Users */
    // Cashier
    public int ordersPerCashier(int cashierId) {
        int orderCount = 0;
        for (Order order : orders) {
            if (order.getUser().getUserId() == cashierId) {
                orderCount++;
            }
        }
        return orderCount;
    }

    public User cashierWithMaxOrders() {
        User cashierWithMaxOrders = null;
        int maxOrderCount = 0;

        for (User user : users) {
            if (user.getUserType().equals("Cashier")) {
                int orderCount = ordersPerCashier(user.getUserId());
                if (orderCount > maxOrderCount) {
                    maxOrderCount = orderCount;
                    cashierWithMaxOrders = user;
                }
            }
        }

        return cashierWithMaxOrders;
    }

    public User cashierWithMaxRevenue() {
        User cashierWithMaxRevenue = null;
        double maxRevenue = 0;

        for (User user : users) {
            if (user.getUserType().equals("Cashier")) {
                double revenue = 0;

                for (Order order : orders) {
                    if (order.getUser().equals(user)) {
                        revenue += order.getProduct().getPrice() * order.getQuantity();
                    }
                }

                if (revenue > maxRevenue) {
                    maxRevenue = revenue;
                    cashierWithMaxRevenue = user;
                }
            }
        }
        return cashierWithMaxRevenue;
    }
    
    // Customers
    public int ordersPerCustomer(Customer customer) {
        return customer.numberOfOrders(orders);
    }

    public Customer customerWithMaxOrders() {
        Customer customerWithMaxOrders = null;
        int maxOrderCount = 0;

        for (Customer customer : customers) {
            int orderCount = ordersPerCustomer(customer);
            if (orderCount > maxOrderCount) {
                maxOrderCount = orderCount;
                customerWithMaxOrders = customer;
            }
        }

        return customerWithMaxOrders;
    }

    public Customer customerWithMaxRevenue() {
        Customer customerWithMaxRevenue = null;
        double maxRevenue = 0;

        for (Customer customer : customers) {
            double revenue = customer.totalRevenue(orders);
            if (revenue > maxRevenue) {
                maxRevenue = revenue;
                customerWithMaxRevenue = customer;
            }
        }
        return customerWithMaxRevenue;
    }
    
    // Supplier
    public int ordersPerSupplier(Supplier supplier) {
        return supplier.numberOfOrders(orders);
    }

    public Supplier supplierWithMaxOrders() {
        Supplier supplierWithMaxOrders = null;
        int maxOrderCount = 0;

        for (Supplier supplier : suppliers) {
            int orderCount = ordersPerSupplier(supplier);
            if (orderCount > maxOrderCount) {
                maxOrderCount = orderCount;
                supplierWithMaxOrders = supplier;
            }
        }

        return supplierWithMaxOrders;
    }

    public Supplier supplierWithMaxRevenue() {
        Supplier supplierWithMaxRevenue = null;
        double maxRevenue = 0;

        for (Supplier supplier : suppliers) {
            double revenue = supplier.totalRevenue(orders);
            if (revenue > maxRevenue) {
                maxRevenue = revenue;
                supplierWithMaxRevenue = supplier;
            }
        }

        return supplierWithMaxRevenue;
    }

    
    // Reports/Data about Orders
    public void viewOrderDetails(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                System.out.println("Order ID: " + order.getOrderId());
                System.out.println("User: " + order.getUser().getUserName());
                System.out.println("Product: " + order.getProduct().getProductName());
                System.out.println("Quantity: " + order.getQuantity());
                System.out.println("Order Date: " + order.getOrderDate());
                return;
            }
        }
        System.out.println("Order not found with ID: " + orderId);
    }

    public double averageRevenueOverPeriod(Date startDate, Date endDate) {
        double totalRevenue = 0;
        int orderCount = 0;

        for (Order order : orders) {
            if (order.getOrderDate().after(startDate) && order.getOrderDate().before(endDate)) {
                totalRevenue += order.getProduct().getPrice() * order.getQuantity();
                orderCount++;
            }
        }

        return orderCount > 0 ? totalRevenue / orderCount : 0;
    }

    public double totalRevenueOverPeriod(Date startDate, Date endDate) {
        double totalRevenue = 0;

        for (Order order : orders) {
            if (order.getOrderDate().after(startDate) && order.getOrderDate().before(endDate)) {
                totalRevenue += order.getProduct().getPrice() * order.getQuantity();
            }
        }

        return totalRevenue;
    }

    // Helper methods
    private int findProductIndex(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == productId) {
                return i;
            }
        }
        return -1;
    }

    private int findUserIndex(int userId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == userId) {
                return i;
            }
        }
        return -1;
    }

    
}

