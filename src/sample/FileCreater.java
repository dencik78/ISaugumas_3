package sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCreater {

    public void creteFile(String url, String text,String fileName) throws Exception {
        Path path = Paths.get(url + "/" +fileName);
        if (Files.exists(path)) {
            File myFile = new File(url + "/" +fileName);
            FileOutputStream myFileOver = new FileOutputStream(myFile, false);
            myFileOver.write(text.getBytes());

            myFileOver.close();
        } else {
            FileOutputStream f = new FileOutputStream(url + "/" +fileName);
            f.write(text.getBytes());
            f.flush();
            f.close();
        }
    }

    public void addToFile(String url,String filename,String text) throws Exception{

        String filePath = url + "/" + filename;
        FileWriter writer = new FileWriter(filePath, true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        bufferWriter.append("\n");
        bufferWriter.append("\n");
        bufferWriter.append("encrypt/decrypt text: ");
        bufferWriter.write(text);
        bufferWriter.close();
    }
}
