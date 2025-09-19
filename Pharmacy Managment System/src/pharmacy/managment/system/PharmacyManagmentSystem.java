
package pharmacy.managment.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;


public class PharmacyManagmentSystem {
    
    public static void main(String[] args) {
        
        System.out.println("1. Admin ");
        System.out.println("2. Customer ");
        System.out.println("3. Supplier");
        System.out.println("4. Order");
        System.out.println("5. Product");
        System.out.println("6. Cashier");
        System.out.println("7. Cart");
        System.out.println("8. Stock");
        System.out.println("Enter number : ");
        
        File file = new File("output.txt");
        Scanner sc = new Scanner(System.in);
                
//Initiate all the classes :    
        // user
        User userr = new User();
        User user1 = new User(1, "John Doe", "Customer");
        User user2 = new User(12, "Mr. Arsany", "Customer");
        
        // Product
        Product product = new Product();
        Product product1 = new Product(101, "Sample Product", 19.99, 2030);
        Product product2 = new Product(202, "Sample Product 2", 222, 2031);
        
        // Order
        Order order = new Order();
        Order order1 = new Order(1, user1, product1, 5, new Date());
        Order order2 = new Order(2, user1, product2, 3, new Date());
        
        // Supplier
        Supplier Supplier = new Supplier();
        Supplier supplier1 = new Supplier(654, "Mo Salah", 205025, "Maher", "205025");
        
        // Customer 
        ArrayList<Order> orderHistory = new ArrayList<>();
        orderHistory.add(order1);
        orderHistory.add(order2);
        
        Customer customer1 = new Customer(1, "Customer1", orderHistory, 3, "Customer1", "Customer");
        User customer2 = new Customer(2, "Customer2", new ArrayList<>(), 4, "Customer2", "Customer");
        
        // Cashier
        Cashier cashier = new Cashier();
        Cashier cashier1 = new Cashier(501, "Cashier1");
        User cashier2 = new Cashier(2, "Youssef");
        
        // Cart
        ArrayList<Order> cartItems = new ArrayList<>();
        cartItems.add(order1);
        cartItems.add(order2);

        Cart cart = new Cart(cartItems);
        
        // Delivery
        Delivery delivery = new Delivery(1001, order1, "123 Main Street", new Date());
        
        // Stock
        Stock stock = new Stock();
        stock.addProduct(product1, 50);
        stock.addProduct(product2, 30);
        
        HashMap<Integer, Integer> productQuantities = new HashMap<>();
        productQuantities.put(product1.getProductId(), 100);
        productQuantities.put(product2.getProductId(), 888);
        
        Stock stock2 = new Stock(productQuantities);
        
    try {
        
            // Creating a PrintStream that writes to the text file
            PrintStream printStream = new PrintStream(file);

            // Redirecting System.out to the created PrintStream
            System.setOut(printStream);
            

            Date orderDate = new Date(2023, 10, 10, 14, 30); // Y, M(November), D, Hr, min 
        
        
// Manage Users : 
        System.out.println("\n\n---------------------------Add Users-------------------------------");
        // Add users
        Admin admin = new Admin();
        
        admin.addUser(cashier1);
        admin.addUser(cashier2);
        admin.addUser(customer1);
        admin.addUser(customer2);
        admin.addUser(user1);
        admin.addProduct(product1);

        // List all users
        System.out.println("List of All Users:");
        admin.listAllUsers().forEach(user -> System.out.println("User ID: " + user.getUserId() + ", User Name: " + user.getUserName()));

        // Edit a user
        User editedCashier = new Cashier(2, "EditedCashier");
        User editedUser = new User(1, "Da ana lesa 3amlo edit", "Customer");
        admin.editUser(editedCashier);
        admin.editUser(editedUser);

        System.out.println("\nList of All Users After Editing:");
        admin.listAllUsers().forEach(user -> System.out.println("User ID: " + user.getUserId() + ", User Name: " + user.getUserName()));

        // Remove a user
        admin.removeUser(2);

        System.out.println("\nList of All Users After Removing:");
        User customer3 = new Customer(333, "Customer333", new ArrayList<>(), 55, "Customer333", "Customer");
        admin.addUser(customer3);
        admin.listAllUsers().forEach(user -> System.out.println("User ID: " + user.getUserId() + ", User Name: " + user.getUserName()));
     
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
           
        System.out.println("\n\n----------------------Menu Driven for Methods---------------------------");
        
        // Menu-Driven program : 
            int num = sc.nextInt();
            switch(num){       
            // Admin    
            case 1:
                Admin admin = new Admin();
                // Test addProduct method
                System.out.println("Testing addProduct method:");
                admin.addProduct(product1);
                admin.addProduct(product2);
                System.out.println("Products added successfully.");

                // Test searchProducts method
                System.out.println("\nTesting searchProducts method:");
                System.out.println("Search results for 'Aspirin':");
                ArrayList<Product> searchResults = admin.searchProducts("Aspirin");
                for (Product result : searchResults) {
                    System.out.println(result);
                }

                // Test editProduct method
                System.out.println("\nTesting editProduct method:");
                Product editedProduct = new Product(2, "Ibuprofen", 4.99, 25);
                admin.editProduct(editedProduct);
                System.out.println("Product edited successfully.");

                // Test removeProduct method
                System.out.println("\nTesting removeProduct method:");
                admin.removeProduct(1);
                System.out.println("Product removed successfully.");

                // Test piecesSoldOverPeriod method
                System.out.println("\nTesting piecesSoldOverPeriod method:");
                Date startDate = new Date(); // replace with actual start date
                Date endDate = new Date();   // replace with actual end date
                int piecesSold = admin.piecesSoldOverPeriod(startDate, endDate);
                System.out.println("Total pieces sold over the period: " + piecesSold);

                // Test bestSellerOverPeriod method
                System.out.println("\nTesting bestSellerOverPeriod method:");
                Product bestSeller = admin.bestSellerOverPeriod(startDate, endDate);
                System.out.println("Best seller over the period: " + bestSeller);

                // Test mostRevenueProductOverPeriod method
                System.out.println("\nTesting mostRevenueProductOverPeriod method:");
                Product mostRevenueProduct = admin.mostRevenueProductOverPeriod(startDate, endDate);
                System.out.println("Most revenue product over the period: " + mostRevenueProduct);
                
                int cashierId = 501; // Replace with an existing cashier ID
                int ordersForCashier = admin.ordersPerCashier(cashierId);
                //System.out.println("Orders for Cashier " + cashierId + ": " + ordersForCashier);

                // Test cashierWithMaxOrders method
                User maxOrdersCashier = admin.cashierWithMaxOrders();
                if (maxOrdersCashier != null) {
                    System.out.println("Cashier with Max Orders: " + maxOrdersCashier.getUserName());
                } else {
                    System.out.println("No Cashier found with Max Orders.");
                }


                // Test cashierWithMaxRevenue method
                User maxRevenueCashier = admin.cashierWithMaxRevenue();
                if(maxRevenueCashier != null){
                    System.out.println("Cashier with Max Revenue: " + maxRevenueCashier.getUserName());
                }else{
                    System.out.println("No Cashier found with Max Revenue.");
                }
                

                // Test viewOrderDetails method
                int orderIdToView = 1;   
                admin.viewOrderDetails(orderIdToView);

               // Test averageRevenueOverPeriod method
               Date startDate1 = new Date();
               Date endDate1 = new Date();
               double averageRevenue = admin.averageRevenueOverPeriod(startDate1, endDate1);
               System.out.println("Average Revenue over Period: " + averageRevenue);
               break;  
                   
               
            // Customer
            case 2:
                Order sampleOrder = new Order(1, new User(1, "John Doe", "Customer"), new Product(101, "Sample Product", 19.99, 2030), 5, new Date());

                // Create a Customer
                ArrayList<Order> orderHistory2 = new ArrayList<>();
                orderHistory.add(sampleOrder);
                Customer customer = new Customer(1, "Customer1", orderHistory, 3, "Customer1", "Customer");

                // Test the methods
                System.out.println("Number of Orders: " + customer.numberOfOrders(orderHistory));
                System.out.println("Total Revenue: $" + customer.totalRevenue(orderHistory));

                // Add a new order to the history
                Order newOrder = new Order(2, customer, new Product(102, "Another Product", 29.99, 2031), 3, new Date());
                customer.addOrderToHistory(newOrder);
                System.out.println("Updated Number of Orders: " + customer.numberOfOrders(orderHistory));
                System.out.println("Updated Total Revenue: $" + customer.totalRevenue(orderHistory));

                // View order history
                System.out.println("\nOrder History:");
                customer.viewOrderHistory();

                // View order details
                int orderIdToView2 = 1;   // Replace with the actual order ID
                System.out.println("\nView Order Details:");
                customer.viewOrderDetails(orderIdToView2);

                // Rate an order
                int orderIdToRate = 2; 
                int rating = 4; 
                customer.rateOrder(orderIdToRate, rating);
                break;
                
                
            // Order
            case 4:
                User sampleUser = new User(1, "Youssef Younis", "Customer");
                Product sampleProduct = new Product(101, "Sample Product", 19.99, 2030);

                // Create a sample order
                Order sampleOrder2 = new Order(1, sampleUser, sampleProduct, 5, new Date());

                // Test the methods
                System.out.println("Order Details:");
                sampleOrder2.viewDetails();

                System.out.println("\nCalculated Total:");
                sampleOrder2.calculateTotal();

                System.out.println("\nView Products:");
                sampleOrder2.viewProducts();
                break;
                
            // Product
            case 5:
                Product sampleProduct1 = new Product(101, "Sample Product", 19.99, 2030);

                // Test the methods
                System.out.println("Product Details:");
                System.out.println("Product ID: " + sampleProduct1.getProductId());
                System.out.println("Product Name: " + sampleProduct1.getProductName());
                System.out.println("Price: " + sampleProduct1.getPrice());
                System.out.println("Warranty: " + sampleProduct1.getWarranty());
                break;
                

            // Cashier
            case 6:
                Cashier sampleCashier = new Cashier(501, "Cashier1");

                // Test the methods
                System.out.println("Cashier Details:");
                System.out.println("User ID: " + sampleCashier.getUserId());
                System.out.println("User Name: " + sampleCashier.getUserName());
                System.out.println("User Type: " + sampleCashier.getUserType());

                // Test createCart method
                Cart cart1 = sampleCashier.createCart();
                System.out.println("\nCart created for Cashier: " + sampleCashier.getUserName());

                // Test calculatePayment method
                Product sampleProduct2 = new Product(101, "Sample Product", 19.99, 2030);
                Order sampleOrder1 = new Order(sampleProduct2, 2);

                double totalPayment = sampleCashier.calculatePayment(cart);
                System.out.println("Total Payment for the cart: " + totalPayment);

                 //Test cancelCart method
                sampleCashier.cancelCart(cart);
                System.out.println("Cart canceled for Cashier: " + sampleCashier.getUserName());

                // Test isDeliveryCompleted method
                boolean isCompleted = sampleCashier.isDeliveryCompleted(delivery);
                System.out.println("Is delivery completed? " + isCompleted);
                break;

                
            // Cart
            case 7:
                Product sampleProduct5 = new Product(1, "Sample Product", 20.00, 2030);

                // Create a sample cart
                Cart sampleCart = new Cart();

                // Test addProduct method
                sampleCart.addProduct(sampleProduct5, 5);

                // Test viewCart method
                System.out.println("View Cart:");
                sampleCart.viewCart();

                // Test removeProduct method
                sampleCart.removeProduct(sampleProduct5, 1);

                // Test viewCart method after removal
                System.out.println("\nView Cart After Removal:");
                sampleCart.viewCart();

                // Test clearCart method
                sampleCart.clearCart();
                System.out.println("\nView Cart After Clearing:");
                sampleCart.viewCart();
                break;
                
            // Stock
            case 8:
                Product product8 = new Product(101, "Sample Product 1", 19.99, 2030);
                Product product6 = new Product(202, "Sample Product 2", 29.99, 2031);

                // Create a sample stock
                Stock sampleStock = new Stock();

                // Test addProduct method
                sampleStock.addProduct(product1, 50);
                sampleStock.addProduct(product2, 30);

                // Test displayStock method
                System.out.println("Initial Stock:");
                sampleStock.displayStock();

                // Test updateProductQuantity method
                sampleStock.updateProductQuantity(product1, 100);

                // Test getProductQuantity method
                int quantityProduct1 = sampleStock.getProductQuantity(product1);
                System.out.println("\nQuantity of Sample Product 1: " + quantityProduct1);

                // Test displayStock method after update
                System.out.println("\nUpdated Stock:");
                sampleStock.displayStock();
                break;

            }
    
    }   
}

