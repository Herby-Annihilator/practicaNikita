package sample;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class RuleForm
{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea textArea;

    @FXML
    void initialize()
    {
        String str = "";
        try (FileReader reader = new FileReader("src/sample/rules.txt"))
        {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1)
            {
                str += Character.toString(c);
            }
        }  catch (IOException e)
        {
            e.printStackTrace();
        }
        textArea.appendText(str);
    }
}
