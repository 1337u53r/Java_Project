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
import java.util.Arrays;

public class SortController {

    Functions functions = new Functions();
    Sort sort = new Sort();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="anchor_pane"
    private AnchorPane anchor_pane;

    @FXML // fx:id="decor_pane_top"
    private DecorationPane decor_pane_top;

    @FXML // fx:id="lbl_sorter"
    private Label lbl_sorter;

    @FXML // fx:id="lbl_sort_txt"
    private Label lbl_sort_txt;

    @FXML // fx:id="txt_numbers"
    private JFXTextField txt_numbers;

    @FXML // fx:id="lbl_algorithm_txt"
    private Label lbl_algorithm_txt;

    @FXML // fx:id="rad_insertion"
    private JFXRadioButton rad_insertion;

    @FXML // fx:id="SortGroup"
    private ToggleGroup SortGroup;

    @FXML // fx:id="rad_bubble"
    private JFXRadioButton rad_bubble;

    @FXML // fx:id="rad_selection"
    private JFXRadioButton rad_selection;

    @FXML // fx:id="lbl_result_txt"
    private Label lbl_result_txt;

    @FXML // fx:id="lbl_result"
    private Label lbl_result;

    @FXML // fx:id="btn_sort"
    private JFXButton btn_sort;

    @FXML // fx:id="btn_home"
    private JFXButton btn_home;

    @FXML
    void handleHomeButtonAction(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        anchor_pane.getChildren().setAll(pane);


    }

    @FXML
    void handleSortButtonAction(ActionEvent event) {

        if (txt_numbers.getText().matches(".*[a-z].*")) {

            txt_numbers.setText("List must not alphabetic characters");

        } else {

            int[] arrayList = functions.convertToIntegerArray(txt_numbers.getText());

            if (rad_insertion.isSelected()) {

                sort.insertionSort(arrayList);

                lbl_result.setText(Arrays.toString(arrayList));

            }

            if (rad_selection.isSelected()) {

                sort.selectionSort(arrayList);

                lbl_result.setText(Arrays.toString(arrayList));

            }

            if (rad_bubble.isSelected()) {

                sort.bubbleSort(arrayList);

                lbl_result.setText(Arrays.toString(arrayList));

            }


        }


    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert anchor_pane != null : "fx:id=\"anchor_pane\" was not injected: check your FXML file 'Sort.fxml'.";
        assert decor_pane_top != null : "fx:id=\"decor_pane_top\" was not injected: check your FXML file 'Sort.fxml'.";
        assert lbl_sorter != null : "fx:id=\"lbl_sorter\" was not injected: check your FXML file 'Sort.fxml'.";
        assert lbl_sort_txt != null : "fx:id=\"lbl_sort_txt\" was not injected: check your FXML file 'Sort.fxml'.";
        assert txt_numbers != null : "fx:id=\"txt_numbers\" was not injected: check your FXML file 'Sort.fxml'.";
        assert lbl_algorithm_txt != null : "fx:id=\"lbl_algorithm_txt\" was not injected: check your FXML file 'Sort.fxml'.";
        assert rad_insertion != null : "fx:id=\"rad_insertion\" was not injected: check your FXML file 'Sort.fxml'.";
        assert SortGroup != null : "fx:id=\"SortGroup\" was not injected: check your FXML file 'Sort.fxml'.";
        assert rad_bubble != null : "fx:id=\"rad_bubble\" was not injected: check your FXML file 'Sort.fxml'.";
        assert rad_selection != null : "fx:id=\"rad_selection\" was not injected: check your FXML file 'Sort.fxml'.";
        assert lbl_result_txt != null : "fx:id=\"lbl_result_txt\" was not injected: check your FXML file 'Sort.fxml'.";
        assert lbl_result != null : "fx:id=\"lbl_result\" was not injected: check your FXML file 'Sort.fxml'.";
        assert btn_sort != null : "fx:id=\"btn_sort\" was not injected: check your FXML file 'Sort.fxml'.";
        assert btn_home != null : "fx:id=\"btn_home\" was not injected: check your FXML file 'Sort.fxml'.";

    }
}
