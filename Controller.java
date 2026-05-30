import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button Calculator;

    @FXML
    private Label lblX1;

    @FXML
    private Label lblX2;

    @FXML
    private Label parametor_1;

    @FXML
    private Label parametor_2;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtB;

    @FXML
    private TextField txtC;

    @FXML
    private TextField txt_answer;

    @FXML
    private TextField txt_root_1;

    @FXML
    private TextField txt_root_2;

    @FXML
    void Push_calculator(ActionEvent event) {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());

            if (a == 0) {
                lblX1.setText("x_1 = Invalid (A cannot be 0)");
                lblX2.setText("");
                return;
            }

            double discriminant = (b * b) - (4 * a * c);

            if (discriminant > 0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                lblX1.setText(String.format("x_1 = %.2f", x1));
                lblX2.setText(String.format("x_2 = %.2f", x2));
            } else if (discriminant == 0) {
                double x = -b / (2 * a);
                lblX1.setText(String.format("x_1 = %.2f", x));
                lblX2.setText("x_2 = (Same as x_1)");
            } else {
                double realPart = -b / (2 * a);
                double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
                lblX1.setText(String.format("x_1 = %.2f + %.2fi", realPart, imaginaryPart));
                lblX2.setText(String.format("x_2 = %.2f - %.2fi", realPart, imaginaryPart));
            }
        } catch (NumberFormatException e) {
            lblX1.setText("Error: Enter valid numbers.");
            lblX2.setText("");
        }
    }

}

