package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

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
    void StartButtonClick(ActionEvent event) throws Exception {
        keyGen keyPairGenerator = new keyGen();
        keyPairGenerator.writeToFile(Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded()));
        System.out.println(Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded()));
        System.out.println(Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded()));
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
