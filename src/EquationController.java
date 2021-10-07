import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import impl.org.controlsfx.skin.DecorationPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class EquationController {

    // Create a instance of required Java classes
    Equation equation = new Equation();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="anchor_pane"
    private AnchorPane anchor_pane;

    @FXML // fx:id="decor_pane_top"
    private DecorationPane decor_pane_top;

    @FXML // fx:id="lbl_title"
    private Label lbl_title;

    @FXML // fx:id="lbl_format_txt"
    private Label lbl_format_txt;

    @FXML // fx:id="lbl_format"
    private Label lbl_format;

    @FXML // fx:id="lbl_a"
    private Label lbl_a;

    @FXML // fx:id="txt_a"
    private JFXTextField txt_a;

    @FXML // fx:id="lbl_b"
    private Label lbl_b;

    @FXML // fx:id="txt_b"
    private JFXTextField txt_b;

    @FXML // fx:id="lbl_c"
    private Label lbl_c;

    @FXML // fx:id="txt_c"
    private JFXTextField txt_c;

    @FXML // fx:id="btn_solve"
    private JFXButton btn_solve;

    @FXML // fx:id="lbl_solution_text"
    private Label lbl_solution_text;

    @FXML // fx:id="lbl_solution"
    private Label lbl_solution;

    @FXML // fx:id="btn_home"
    private JFXButton btn_home;

    @FXML
    void handleSolveButtonAction(ActionEvent event) {

        if (txt_a.getText().matches(".*[a-z].*")) {

            lbl_solution.setText("x = ");
            txt_a.setText("Invalid");

        } else if (txt_b.getText().matches(".*[a-z].*")) {

            lbl_solution.setText("x = ");
            txt_b.setText("Invalid");

        } else if (txt_c.getText().matches(".*[a-z].*")) {

            lbl_solution.setText("x = ");
            txt_c.setText("Invalid");

        } else {

            double a = Double.parseDouble(txt_a.getText());
            double b = Double.parseDouble(txt_b.getText());
            double c = Double.parseDouble(txt_c.getText());

            if (Double.isInfinite(a) || Double.isNaN(a) || a == 0) {

                lbl_solution.setText("x = ");
                txt_a.setText("Invalid");

            } else {

                String solution = equation.solveEquation(a, b, c);

                lbl_solution.setText("x = " + solution);

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
        assert anchor_pane != null : "fx:id=\"anchor_pane\" was not injected: check your FXML file 'Equation.fxml'.";
        assert decor_pane_top != null : "fx:id=\"decor_pane_top\" was not injected: check your FXML file 'Equation.fxml'.";
        assert lbl_title != null : "fx:id=\"lbl_title\" was not injected: check your FXML file 'Equation.fxml'.";
        assert lbl_format_txt != null : "fx:id=\"lbl_format_txt\" was not injected: check your FXML file 'Equation.fxml'.";
        assert lbl_format != null : "fx:id=\"lbl_format\" was not injected: check your FXML file 'Equation.fxml'.";
        assert lbl_a != null : "fx:id=\"lbl_a\" was not injected: check your FXML file 'Equation.fxml'.";
        assert txt_a != null : "fx:id=\"txt_a\" was not injected: check your FXML file 'Equation.fxml'.";
        assert lbl_b != null : "fx:id=\"lbl_b\" was not injected: check your FXML file 'Equation.fxml'.";
        assert txt_b != null : "fx:id=\"txt_b\" was not injected: check your FXML file 'Equation.fxml'.";
        assert lbl_c != null : "fx:id=\"lbl_c\" was not injected: check your FXML file 'Equation.fxml'.";
        assert txt_c != null : "fx:id=\"txt_c\" was not injected: check your FXML file 'Equation.fxml'.";
        assert btn_solve != null : "fx:id=\"btn_solve\" was not injected: check your FXML file 'Equation.fxml'.";
        assert lbl_solution_text != null : "fx:id=\"lbl_solution_text\" was not injected: check your FXML file 'Equation.fxml'.";
        assert lbl_solution != null : "fx:id=\"lbl_solution\" was not injected: check your FXML file 'Equation.fxml'.";
        assert btn_home != null : "fx:id=\"btn_home\" was not injected: check your FXML file 'Equation.fxml'.";

    }
}
