package sample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.util.Base64;

public class keyGen {

    private PrivateKey privateKey;
    private PublicKey publicKey;

    public keyGen() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public void writeToFile( String key,boolean mode) throws Exception {
        if(mode) {
            FileCreater fl = new FileCreater();
            fl.creteFile("C:\\Users\\ThinkPad\\Desktop", key, "en.txt");
        }else{
            FileCreater fl = new FileCreater();
            fl.creteFile("C:\\Users\\ThinkPad\\Desktop", key, "de.txt");
        }
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

}
