# Registration Form Application

A JavaFX-based registration form with live field validation and a modern user interface. Developed as part of a module at Farmingdale State College, this application validates user input (name, email, date of birth, and zip code) and displays a confirmation message upon successful submission.

---

## Screenshot
![Screenshot 2025-04-13 020218](https://github.com/user-attachments/assets/55e00b6b-85a4-44ae-b017-761e9d884814)

---

## Features

- **Field Validation:** Checks for:
  - First & Last Name: 2–25 alphabetical characters.
  - Email: Must be in the format `user@farmingdale.edu`.
  - Date of Birth: Format `MM/DD/YYYY`.
  - Zip Code: Exactly 5 digits.
- **User-Friendly Design:** Built with FXML and custom CSS for a sleek UI.
- **Real-Time Feedback:** Validation messages are shown immediately after field focus loss.
- **Responsive Confirmation:** Displays a confirmation message after successful registration.

---
### Prerequisites

- JDK (Java Development Kit)
- JavaFX SDK


---
### Code Structure
![image](https://github.com/user-attachments/assets/94da6eb0-7257-4e77-9432-2b8ddd5de5a6)

- RegistrationApp.java:
  - Main entry point for launching the JavaFX application. Loads the FXML layout and applies CSS styling.

- RegistrationController.java:
  - Manages form interactions and field validations using regular expressions.

- FXML File:
  - Defines the UI components and layout of the registration form.
    
- CSS File:
  - Provides custom styling for a polished and modern look.



