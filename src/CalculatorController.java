import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import impl.org.controlsfx.skin.DecorationPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class CalculatorController {

    Calculator calculator = new Calculator();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="anchor_pane"
    private AnchorPane anchor_pane;

    @FXML // fx:id="decor_pane_top"
    private DecorationPane decor_pane_top;

    @FXML // fx:id="lbl_calculator"
    private Label lbl_calculator;

    @FXML // fx:id="rad_add"
    private JFXRadioButton rad_add;

    @FXML // fx:id="OperatorGroup"
    private ToggleGroup OperatorGroup;

    @FXML // fx:id="rad_subtract"
    private JFXRadioButton rad_subtract;

    @FXML // fx:id="rad_multiply"
    private JFXRadioButton rad_multiply;

    @FXML // fx:id="rad_divide"
    private JFXRadioButton rad_divide;

    @FXML // fx:id="lbl_number_one"
    private Label lbl_number_one;

    @FXML // fx:id="lbl_number_two"
    private Label lbl_number_two;

    @FXML // fx:id="txt_number_one"
    private JFXTextField txt_number_one;

    @FXML // fx:id="txt_number_two"
    private JFXTextField txt_number_two;

    @FXML // fx:id="lbl_number_txt"
    private Label lbl_number_txt;

    @FXML // fx:id="lbl_operator_txt"
    private Label lbl_operator_txt;

    @FXML // fx:id="lbl_result"
    private Label lbl_result;

    @FXML // fx:id="btn_solve"
    private JFXButton btn_solve;

    @FXML // fx:id="decor_pane_answer"
    private DecorationPane decor_pane_answer;

    @FXML // fx:id="lbl_answer"
    private Label lbl_answer;

    @FXML // fx:id="btn_home"
    private JFXButton btn_home;

    @FXML
    void handleSolveButtonAction(ActionEvent event) {

        if (txt_number_one.getText().matches(".*[a-z].*")) {

            lbl_answer.setText("");
            txt_number_one.setText("Invalid number");

        } else if (txt_number_two.getText().matches(".*[a-z].*")) {

            lbl_answer.setText("");
            txt_number_two.setText("Invalid number");

        } else {

            double numberOne = Double.parseDouble(txt_number_one.getText());
            double numberTwo = Double.parseDouble(txt_number_two.getText());

            String operator = null;

            if (rad_add.isSelected()) {

                operator = "+";

            }

            if (rad_subtract.isSelected()) {

                operator = "-";

            }

            if (rad_multiply.isSelected()) {

                operator = "*";

            }

            if (rad_divide.isSelected()) {

                operator = "/";

            }

            if (numberTwo == 0 && operator == "/") {

                lbl_answer.setText("");
                txt_number_two.setText("Invalid number");

            } else {

                lbl_answer.setText(calculator.calculate(numberOne, numberTwo, operator));

            }


        }

    }

    @FXML
    void handleHomeButtonAction(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        anchor_pane.getChildren().setAll(pane);

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert anchor_pane != null : "fx:id=\"anchor_pane\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert decor_pane_top != null : "fx:id=\"decor_pane_top\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert lbl_calculator != null : "fx:id=\"lbl_calculator\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert rad_add != null : "fx:id=\"rad_add\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert OperatorGroup != null : "fx:id=\"OperatorGroup\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert rad_subtract != null : "fx:id=\"rad_subtract\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert rad_multiply != null : "fx:id=\"rad_multiply\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert rad_divide != null : "fx:id=\"rad_divide\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert lbl_number_one != null : "fx:id=\"lbl_number_one\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert lbl_number_two != null : "fx:id=\"lbl_number_two\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert txt_number_one != null : "fx:id=\"txt_number_one\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert txt_number_two != null : "fx:id=\"txt_number_two\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert lbl_number_txt != null : "fx:id=\"lbl_number_txt\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert lbl_operator_txt != null : "fx:id=\"lbl_operator_txt\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert lbl_result != null : "fx:id=\"lbl_result\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert btn_solve != null : "fx:id=\"btn_solve\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert decor_pane_answer != null : "fx:id=\"decor_pane_answer\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert lbl_answer != null : "fx:id=\"lbl_answer\" was not injected: check your FXML file 'Calculator.fxml'.";
        assert btn_home != null : "fx:id=\"btn_home\" was not injected: check your FXML file 'Calculator.fxml'.";

    }
}
