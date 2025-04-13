package edu.farmingdale.mod06_registrationform;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main entry point for the Registration Form application.
 *
 * <p>Loads the FXML layout, applies the stylesheet, and shows the primary stage.</p>
 *
 * @author Saim
 * @version 1.0
 * @see javafx.application.Application
 */
public class RegistrationApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML from the resources folder
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/edu/farmingdale/mod06_registrationform/registration.fxml")
        );
        Parent root = loader.load();

        // Create scene, apply CSS
        Scene scene = new Scene(root, 750, 500);
        scene.getStylesheets().add(getClass().getResource("/edu/farmingdale/mod06_registrationform/styling/registration.css").toExternalForm());

        primaryStage.setTitle("Registration Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Launches the JavaFX application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        launch(args);
    }
}
