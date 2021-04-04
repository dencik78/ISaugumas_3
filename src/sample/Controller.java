package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private TextArea textArea;

    @FXML
    private TextArea keyArea;

    @FXML
    private CheckBox enCheckBox;

    @FXML
    private CheckBox deCheckBox;

    @FXML
    private Button startButton;

    @FXML
    void StartButtonClick(ActionEvent event) {

    }

    @FXML
    void deCheckBoxClick(ActionEvent event) {
        if(deCheckBox.isSelected()){
            enCheckBox.setSelected(false);
            keyArea.setVisible(true);
        }
    }

    @FXML
    void enCheckBoxClick(ActionEvent event) {
        if(enCheckBox.isSelected()){
            deCheckBox.setSelected(false);
            keyArea.setText(null);
            keyArea.setVisible(false);
        }
    }

}
