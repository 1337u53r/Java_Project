import com.jfoenix.controls.JFXButton;
import impl.org.controlsfx.skin.DecorationPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MainMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="anchor_pane"
    private AnchorPane anchor_pane;

    @FXML // fx:id="lbl_main_menu"
    private Label lbl_main_menu;

    @FXML // fx:id="btn_equation"
    private JFXButton btn_equation;

    @FXML // fx:id="btn_accuracy"
    private JFXButton btn_accuracy;

    @FXML // fx:id="decor_pane_bottom"
    private DecorationPane decor_pane_bottom;

    @FXML // fx:id="decor_pane_left"
    private DecorationPane decor_pane_left;

    @FXML // fx:id="decor_pane_right"
    private DecorationPane decor_pane_right;

    @FXML // fx:id="btn_calculator"
    private JFXButton btn_calculator;

    @FXML // fx:id="btn_sort"
    private JFXButton btn_sort;

    @FXML
    void handleAccuracyButtonAction(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("Accuracy.fxml"));
        anchor_pane.getChildren().setAll(pane);

    }

    @FXML
    void handleEquationButtonAction(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("Equation.fxml"));
        anchor_pane.getChildren().setAll(pane);

    }

    @FXML
    void handleCalculatorButtonAction(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
        anchor_pane.getChildren().setAll(pane);

    }

    @FXML
    void handleSortButtonAction(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("Sort.fxml"));
        anchor_pane.getChildren().setAll(pane);

    }


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert anchor_pane != null : "fx:id=\"anchor_pane\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert lbl_main_menu != null : "fx:id=\"lbl_main_menu\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert btn_equation != null : "fx:id=\"btn_equation\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert btn_accuracy != null : "fx:id=\"btn_accuracy\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert decor_pane_bottom != null : "fx:id=\"decor_pane_bottom\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert decor_pane_left != null : "fx:id=\"decor_pane_left\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert decor_pane_right != null : "fx:id=\"decor_pane_right\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert btn_calculator != null : "fx:id=\"btn_calculator\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert btn_sort != null : "fx:id=\"btn_sort\" was not injected: check your FXML file 'MainMenu.fxml'.";

    }
}
