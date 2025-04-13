module edu.farmingdale.mod06_registrationform {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.farmingdale.mod06_registrationform to javafx.fxml;
    exports edu.farmingdale.mod06_registrationform;
}
