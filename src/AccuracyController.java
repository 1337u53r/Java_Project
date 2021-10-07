import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import impl.org.controlsfx.skin.DecorationPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class AccuracyController extends Main {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="anchor_pane"
    private AnchorPane anchor_pane;

    @FXML // fx:id="decor_pane_top"
    private DecorationPane decor_pane_top;

    @FXML // fx:id="lbl_set_accuracy"
    private Label lbl_set_accuracy;

    @FXML // fx:id="sld_range"
    private JFXSlider sld_range;

    @FXML // fx:id="lbl_text_range"
    private Label lbl_text_range;

    @FXML // fx:id="btn_set"
    private JFXButton btn_set;

    @FXML // fx:id="btn_home"
    private JFXButton btn_home;

    @FXML
    void handleHomeButtonAction(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        anchor_pane.getChildren().setAll(pane);

    }

    @FXML
    void handleSetButtonAction(ActionEvent event) {

        double value = sld_range.getValue();

        if (value == 1) {

            ACCURACY = 1;
            System.out.println(sld_range.getValue());

        }

        if (value == 2) {

            ACCURACY = 2;
            System.out.println(sld_range.getValue());

        }

        if (value == 3) {

            ACCURACY = 3;
            System.out.println(sld_range.getValue());

        }

        if (value == 4) {

            ACCURACY = 4;
            System.out.println(sld_range.getValue());

        }

        if (value == 5) {

            ACCURACY = 5;
            System.out.println(sld_range.getValue());

        }


    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert anchor_pane != null : "fx:id=\"anchor_pane\" was not injected: check your FXML file 'Accuracy.fxml'.";
        assert decor_pane_top != null : "fx:id=\"decor_pane_top\" was not injected: check your FXML file 'Accuracy.fxml'.";
        assert lbl_set_accuracy != null : "fx:id=\"lbl_set_accuracy\" was not injected: check your FXML file 'Accuracy.fxml'.";
        assert sld_range != null : "fx:id=\"sld_range\" was not injected: check your FXML file 'Accuracy.fxml'.";
        assert lbl_text_range != null : "fx:id=\"lbl_text_range\" was not injected: check your FXML file 'Accuracy.fxml'.";
        assert btn_set != null : "fx:id=\"btn_set\" was not injected: check your FXML file 'Accuracy.fxml'.";
        assert btn_home != null : "fx:id=\"btn_home\" was not injected: check your FXML file 'Accuracy.fxml'.";

    }
}
