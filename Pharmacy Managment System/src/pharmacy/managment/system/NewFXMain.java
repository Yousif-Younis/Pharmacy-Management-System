package pharmacy.managment.system;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NewFXMain extends Application {

    private Stage primaryStage;
    private int[] attempts = {3};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Pharmacy Management System");

        // Sign In Page
        GridPane signInGrid = createSignInPage();

        // Sign Up Page
     
        // Main Page
        GridPane mainPageGrid = createMainPage();

        // Create a Scene
        Scene signInScene = new Scene(signInGrid, 400, 250); // Increased height to accommodate the text
       
        Scene mainPageScene = new Scene(mainPageGrid, 600, 400);

        // Set the default scene to Sign In
        primaryStage.setScene(signInScene);

        // Show the stage
        primaryStage.show();
    }

    private GridPane createSignInPage() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Add UI components for Sign In page
        Text welcomeText = new Text("Welcome To Our Pharmacy");
        welcomeText.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button signInButton = new Button("Sign In");
       
        // Set actions for buttons
        signInButton.setOnAction(e -> {
            String enteredUsername = usernameField.getText();
            String enteredPassword = passwordField.getText();
            String expectedUsername = "admin"; // Change this to your specified username
            String expectedPassword = "1234"; // Change this to your specified password

            if (enteredUsername.equals(expectedUsername) && enteredPassword.equals(expectedPassword)) {
                // Successful login, switch to the main page
                primaryStage.setScene(new Scene(createMainPage(), 600, 400));
            } else {
                attempts[0]--;
                if (attempts[0] == 0) {
                    // Display a message if the user exceeds the allowed attempts
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Login Failed");
                    alert.setHeaderText(null);
                    alert.setContentText("You have exceeded the allowed login attempts. Please try again later.");
                    alert.showAndWait();
                    System.exit(0); // Terminate the application for simplicity; you can handle it differently based on your requirements
                } else {
                    // Display the remaining attempts
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Login Failed");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect username or password. Remaining attempts: " + attempts[0]);
                    alert.showAndWait();
                }
            }
        });


        // Add components to the grid
        grid.add(welcomeText, 1, 0, 2, 1); // span two columns for center alignment
        grid.add(usernameLabel, 0, 1);
        grid.add(usernameField, 1, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);
        grid.add(signInButton, 1, 3);


        return grid;
    }

    

    private GridPane createMainPage() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        // Add UI components for the main page
        Button productButton = new Button("Product");
        Button CustomerButton = new Button("Click Here To Make New Order");
        Button supplierButton = new Button("Supplier");
        Button OrdersButton = new Button("Orders");

        // Set button sizes
        double buttonWidth = 150;
        double buttonHeight = 50;
        double ButtonHieght=100;
         double ButtonWidth = 200;
        

        productButton.setMinSize(buttonWidth, buttonHeight);
        CustomerButton.setMinSize(ButtonWidth, ButtonHieght);
        supplierButton.setMinSize(buttonWidth, buttonHeight);
        OrdersButton.setMinSize(buttonWidth, buttonHeight);

        // Set actions for buttons
        productButton.setOnAction(e -> {
           
            primaryStage.setScene(new Scene(createProductPage(), 600, 400));
        });

        CustomerButton.setOnAction(e -> {
            
            primaryStage.setScene(new Scene(createCustomerPage(), 600, 400));
        });

        supplierButton.setOnAction(e -> {
          
            primaryStage.setScene(new Scene(createSupplierPage(), 600, 400));
        });

        OrdersButton.setOnAction(e -> {
           
            primaryStage.setScene(new Scene(createOrdersPage(), 600, 400));
        });

        // Add components to the grid
         grid.add(productButton, 2, 2); // Upper left
        grid.add(CustomerButton, 1, 0);
        grid.add(OrdersButton, 0, 2); // Lower left
        grid.add(supplierButton, 1, 2); // Lower right

        return grid;
    }

    private GridPane createProductPage() {
        GridPane grid = new GridPane();
        grid.setHgap(10);

        // Add column headers with bigger font
        Font headerFont = new Font(25);

        Label idHeader = new Label("");
        idHeader.setFont(headerFont);

        Label nameHeader = new Label("");
        nameHeader.setFont(headerFont);

        Label quantityHeader = new Label("Products:");
        quantityHeader.setFont(headerFont);

        HBox headerBox = new HBox(15, idHeader, nameHeader, quantityHeader);
        GridPane.setMargin(headerBox, new Insets(5, 0, 5, 0));
        grid.add(headerBox, 0, 0);

        // Add "Add Product" button
        Button addProductButton = new Button("Add Product");
        addProductButton.setOnAction(e -> {
            // Call a method to show the add product dialog
            showAddProductDialog(grid);
        });
        grid.add(addProductButton, 0, grid.getRowCount());

        // Add existing products
        addProductToGrid(grid, 101, "Brofin", 10, 500);
        addProductToGrid(grid, 201, "Xithrone", 15, 60);
        addProductToGrid(grid, 301, "Adol", 20, 120);
        addProductToGrid(grid, 401, "Ursofalk", 0, 40);
        addProductToGrid(grid, 501, "Folic Acid", 12, 20);
          Button backButton = createBackButton();
        grid.add(backButton, 1, 0);

        return grid;
    }
private Button createBackButton() {
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> primaryStage.setScene(new Scene(createMainPage(), 600, 400)));
        return backButton;
    }
    private static void addProductToGrid(GridPane grid, int id, String name, int quantity, int price) {
        // Add product details to the grid using HBox
        Font cellFont = new Font(20);

        Label idLabel = new Label("ID: " + String.valueOf(id));
        idLabel.setFont(cellFont);

        Label nameLabel = new Label("Name: " + name);
        nameLabel.setFont(cellFont);

        Label quantityLabel = new Label("Quantity: " + String.valueOf(quantity));
        quantityLabel.setFont(cellFont);

        Label inStockLabel = new Label("Price: " + String.valueOf(price));
        inStockLabel.setFont(cellFont);

        // Create an HBox to organize the labels with some spacing
        HBox hbox = new HBox(15, idLabel, nameLabel, quantityLabel, inStockLabel);
        GridPane.setMargin(hbox, new Insets(5, 0, 5, 0)); // Set margins

        // Add the HBox to the next available row
        int row = grid.getRowCount();
        grid.add(hbox, 0, row);
    }

    private int findNextAvailableRow(GridPane grid) {
        int numRows = grid.getRowCount();
        return numRows;
    }

    private void showAddProductDialog(GridPane productGrid) {
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Add Product");

        VBox dialogLayout = new VBox();
        dialogLayout.setSpacing(10);
        dialogLayout.setPadding(new Insets(10));

        TextField idField = new TextField();
        idField.setPromptText("Enter ID");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter Name");

        TextField quantityField = new TextField();
        quantityField.setPromptText("Enter Quantity");

        TextField priceField = new TextField();
        priceField.setPromptText("Price");

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            int price = Integer.parseInt(priceField.getText());

            addProductToGrid(productGrid, id, name, quantity, price);

            dialogStage.close();
        });

        dialogLayout.getChildren().addAll(idField, nameField, quantityField, priceField, saveButton);

        Scene dialogScene = new Scene(dialogLayout, 300, 200);
        dialogStage.setScene(dialogScene);

        dialogStage.show();
    }

    
    
    
    
    
    
    
    
    private GridPane createCustomerPage() {
        GridPane grid = new GridPane();
          Button backButton = createBackButton();
        grid.add(backButton, 1, 0);
        return grid;
    }
   

    
    
    
    
    
    
    
    private GridPane createSupplierPage() {
        GridPane grid = new GridPane();
        grid.setHgap(10);

        // Add column headers with bigger font
        Font headerFont = new Font(25);

        Label idHeader = new Label("");
        idHeader.setFont(headerFont);

        Label nameHeader = new Label("");
        nameHeader.setFont(headerFont);

        Label productHeader = new Label("Suppliers:");
        productHeader.setFont(headerFont);

        HBox headerBox = new HBox(15, idHeader, nameHeader, productHeader);
        GridPane.setMargin(headerBox, new Insets(5, 0, 5, 0));
        grid.add(headerBox, 0, 0);

        // Add "Add Supplier" button
        Button addSupplierButton = new Button("Add Supplier");
        addSupplierButton.setOnAction(e -> {
            // Call a method to show the add supplier dialog
            showAddSupplierDialog(grid);
        });
        grid.add(addSupplierButton, 0, grid.getRowCount());

        // Add existing suppliers
        addSupplierToGrid(grid, "Mohamed Hamdy", "5002", "Xithrone");
        addSupplierToGrid(grid, "shafie", "6000", "Panadol");
        addSupplierToGrid(grid, "Mostafa Ahmed", "7024", "Augmentin");
        addSupplierToGrid(grid, "Abdelrahman hassan", "7809", "De cansit");
        addSupplierToGrid(grid, "Saif Magdy", "6932", "Cold & Flu");
  Button backButton = createBackButton();
        grid.add(backButton, 1, 0);
        return grid;
    }

    private void addSupplierToGrid(GridPane grid, String name, String id, String product) {
        // Add supplier details to the grid using HBox
        Font cellFont = new Font(20);

        Label nameLabel = new Label("Name: " + name);
        nameLabel.setFont(cellFont);

        Label idLabel = new Label("ID: " + id);
        idLabel.setFont(cellFont);

        Label productLabel = new Label("Product: " + product);
        productLabel.setFont(cellFont);

        // Create an HBox to organize the labels with some spacing
        HBox hbox = new HBox(15, nameLabel, idLabel, productLabel);
        GridPane.setMargin(hbox, new Insets(5, 0, 5, 0)); // Set margins

        // Add the HBox to the next available row
        int row = grid.getRowCount();
        grid.add(hbox, 0, row);
    }

    private void showAddSupplierDialog(GridPane supplierGrid) {
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Add Supplier");

        VBox dialogLayout = new VBox();
        dialogLayout.setSpacing(10);
        dialogLayout.setPadding(new Insets(10));

        TextField nameField = new TextField();
        nameField.setPromptText("Enter Name");

        TextField idField = new TextField();
        idField.setPromptText("Enter ID");

        TextField productField = new TextField();
        productField.setPromptText("Enter Product");

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            String name = nameField.getText();
            String id = idField.getText();
            String product = productField.getText();

            addSupplierToGrid(supplierGrid, name, id, product);

            dialogStage.close();
        });

        dialogLayout.getChildren().addAll(nameField, idField, productField, saveButton);

        Scene dialogScene = new Scene(dialogLayout, 300, 200);
        dialogStage.setScene(dialogScene);

        dialogStage.show();
    }

   
    private GridPane createOrdersPage() {
        GridPane grid = new GridPane();
       Button backButton = createBackButton();
        grid.add(backButton, 1, 0);
        return grid;
    }
}
