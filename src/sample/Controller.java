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

    private String keyPublic;
    private boolean modeCR;

    @FXML
    void StartButtonClick(ActionEvent event) throws Exception {
        keyGen keyPairGenerator = new keyGen();
        keyPairGenerator.writeToFile(Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded()));
        keyPublic = Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded());
        RSA rsa = new RSA();
        String encryptedString = Base64.getEncoder().encodeToString(rsa.encrypt(textArea.getText(), keyPublic));
        System.out.println(encryptedString);
        FileCreater fl = new FileCreater();
        fl.addToFile("C:\\Users\\ThinkPad\\Desktop","en.txt",encryptedString);
        String decryptedString = rsa.decrypt(encryptedString, Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded()));
        System.out.println(decryptedString);
    }

    @FXML
    void deCheckBoxClick(ActionEvent event) {
        if(deCheckBox.isSelected()){
            enCheckBox.setSelected(false);
            keyArea.setVisible(true);
            modeCR = false;
        }
    }

    @FXML
    void enCheckBoxClick(ActionEvent event) {
        if(enCheckBox.isSelected()){
            deCheckBox.setSelected(false);
            keyArea.setText(null);
            keyArea.setVisible(false);
            modeCR = true;
        }
    }

}
