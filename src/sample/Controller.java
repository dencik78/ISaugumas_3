package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

import javax.swing.*;
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

    private String keyPrivate;
    private boolean modeCR;

    @FXML
    void StartButtonClick(ActionEvent event) throws Exception {
        keyGen keyPairGenerator = new keyGen();
        FileCreater fl = new FileCreater();
        //True - crypt
        //False - decrypt
        if(!textArea.getText().isBlank()) {
            if (modeCR) {
                String keyPublic = Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded());
                keyPrivate = Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded());
                keyPairGenerator.writeToFile(keyPrivate, modeCR);
                String encryptedString = Base64.getEncoder().encodeToString(RSA.encrypt(textArea.getText(), keyPublic));
                fl.addToFile("C:\\Users\\ThinkPad\\Desktop", "en.txt", encryptedString);
                JOptionPane.showMessageDialog(null, "Your text is crypt");
            } else {
                if(!keyArea.getText().isBlank()) {
                    String decryptedString = RSA.decrypt(textArea.getText(), keyArea.getText());
                    keyPairGenerator.writeToFile(decryptedString, modeCR);
                    JOptionPane.showMessageDialog(null, "Your text is Decrypt");
                }else{
                    JOptionPane.showMessageDialog(null,"You dont write key");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"You dont write text");
        }
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
