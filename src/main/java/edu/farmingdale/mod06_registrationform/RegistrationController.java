package edu.farmingdale.mod06_registrationform;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/**
 * Controller for the Registration Form.
 *
 * <p>Handles all field validations and navigates to a confirmation screen
 * when the user successfully registers.</p>
 *
 * <ul>
 *   <li>First/Last Name: 2–25 letters</li>
 *   <li>Email: must end with <code>@farmingdale.edu</code></li>
 *   <li>Date of Birth: <code>MM/DD/YYYY</code></li>
 *   <li>Zip Code: 5 digits</li>
 * </ul>
 *
 * @author Saim
 * @version 1.0
 * @see javafx.fxml.FXML
 */
public class RegistrationController {

    @FXML private TextField firstNameField;
    @FXML private Label firstNameStatus;

    @FXML private TextField lastNameField;
    @FXML private Label lastNameStatus;

    @FXML private TextField emailField;
    @FXML private Label emailStatus;

    @FXML private TextField dobField;
    @FXML private Label dobStatus;

    @FXML private TextField zipField;
    @FXML private Label zipStatus;

    @FXML private Button addButton;

    // Regex patterns
    private static final Pattern NAME_PATTERN  = Pattern.compile("^[A-Za-z]{2,25}$");
    private static final Pattern DOB_PATTERN   = Pattern.compile("^(0[1-9]|1[0-2])/(0[1-9]|[12]\\d|3[01])/(19|20)\\d{2}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.+\\-]+@farmingdale\\.edu$");
    private static final Pattern ZIP_PATTERN   = Pattern.compile("^\\d{5}$");

    // Validation flags
    private boolean isFirstNameValid = false;
    private boolean isLastNameValid  = false;
    private boolean isEmailValid     = false;
    private boolean isDobValid       = false;
    private boolean isZipValid       = false;

    /**
     * Initializes the controller: sets up focus-lost listeners on each field
     * to perform validation and enable the Add button when all are valid.
     */
    @FXML
    public void initialize() {
        setupValidation(firstNameField, firstNameStatus, NAME_PATTERN,  "2–25 letters", v -> isFirstNameValid = v);
        setupValidation(lastNameField,  lastNameStatus,  NAME_PATTERN,  "2–25 letters", v -> isLastNameValid  = v);
        setupValidation(emailField,     emailStatus,     EMAIL_PATTERN, "user@farmingdale.edu", v -> isEmailValid     = v);
        setupValidation(dobField,       dobStatus,       DOB_PATTERN,   "MM/DD/YYYY",          v -> isDobValid       = v);
        setupValidation(zipField,       zipStatus,       ZIP_PATTERN,   "5 digits",            v -> isZipValid       = v);

        // When clicked, if everything is valid, show confirmation
        addButton.setOnAction(e -> {
            if (allValid()) {
                showConfirmation();
            }
        });
    }

    /**
     * Attaches a focus-lost listener to validate the field and update its status label.
     *
     * @param field       the TextField to validate
     * @param statusLabel the Label to show ✓ or error text
     * @param pattern     the regex Pattern to apply
     * @param hint        the hint text to show on invalid
     * @param setter      consumer to update the corresponding validity flag
     */
    private void setupValidation(TextField field,
                                 Label statusLabel,
                                 Pattern pattern,
                                 String hint,
                                 Consumer<Boolean> setter)
    {
        field.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                boolean valid = pattern.matcher(field.getText()).matches();
                setter.accept(valid);
                updateStatus(statusLabel, valid, hint);
                addButton.setDisable(!allValid());
            }
        });
    }

    /**
     * Updates a status label to show either a green checkmark or an error message.
     *
     * @param label the Label to update
     * @param valid whether the input passed validation
     * @param hint  the hint to display if invalid
     */
    private void updateStatus(Label label, boolean valid, String hint) {
        label.getStyleClass().removeAll("status-valid", "status-invalid");

        if (valid) {
            label.setText("✓");
            label.getStyleClass().add("status-valid");
        } else {
            label.setText("Invalid (" + hint + ")");
            label.getStyleClass().add("status-invalid");
        }
    }

    /**
     * Checks if all fields have valid input.
     *
     * @return true if every field is valid
     */
    private boolean allValid() {
        return isFirstNameValid
                && isLastNameValid
                && isEmailValid
                && isDobValid
                && isZipValid;
    }

    /**
     * Displays a simple confirmation message in the same window.
     * Replaces the scene with a VBox containing the success label.
     */
    private void showConfirmation() {
        Stage stage = (Stage) addButton.getScene().getWindow();
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        Label msg = new Label("Registration Successful!");
        msg.getStyleClass().add("confirmation-label");

        layout.getChildren().add(msg);
        stage.setScene(new Scene(layout, 750, 500));
    }
}
