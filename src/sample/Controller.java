package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class Controller
{
    private int ratteKillCost = 50;
    private int ghostKillCost = 50;
    private  int newStoreCost = 100;
    @FXML
    private ImageView storeImage = new ImageView();

    @FXML
    public ImageView ratteAdd;

    @FXML
    public ImageView casper;

    @FXML
    public ImageView startRatteImage;

    @FXML
    private TextField balanseField;

    @FXML
    private TextField ratteCountField;

    @FXML
    private TextField brusField;

    @FXML
    private TextField productField;

    @FXML
    private Button newStoreButton;

    @FXML
    private Button killRatteButton;

    @FXML
    private Button killGhostButton;

    @FXML
    private Button ruleButton;

    @FXML
    private Button addProductButton;

    public  Store store = Store.getStore();
    private Ratte ratte = new Ratte(this);
    private Ghost ghost = Ghost.getGhost(this);
    //
    // Покупка нового склада
    //
    @FXML
    public void NewStoreButtonClick()
    {
        if (store.isNew == true)
            return;
        if (store.balanse >= newStoreCost)
        {
            store.balanse -= newStoreCost;
            store.isNew = true;
            // Вставить изображение
            storeImage.setImage(new Image("file:src/sample/images/clearStore.jpg"));
            Skip();
        }
        else
        {
            JOptionPane jOptionPane = new JOptionPane();
            jOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Недостаточно средств");
        }

    }
    //
    // Убить крыс
    //
    @FXML
    public void KillRatteButtonClick()
    {
        if (ratte.count < 2)
            return;
        if (store.balanse >= ratteKillCost)
        {
            store.balanse -= ratteKillCost;
            ratte.count /= 2;
            Skip();
        }
        else
        {
            JOptionPane jOptionPane = new JOptionPane();
            jOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Недостаточно средств");
        }
    }
    //
    // Правила
    //
    @FXML
    public void RuleButtonClick()
    {
        // открыть файл в новой форме
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ruleForm.fxml"));
        Parent root1 = null;
        try
        {
            root1 = fxmlLoader.load();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1, 600, 200));
        stage1.show();
    }
    //
    // Уничтожить призрака
    //
    @FXML
    public void KillGhostButtonClick()
    {
        if (casper.isVisible() == false)
            return;
        if (store.balanse >= ghostKillCost)
        {
            store.balanse -= ghostKillCost;
            this.casper.setVisible(false);
            Skip();
        }
        else
        {
            JOptionPane jOptionPane = new JOptionPane();
            jOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Недостаточно средств");
        }
    }
    //
    // Скомуниздить продукты
    //
    @FXML
    public void AddProductButtonClick()
    {
        store.setProductCount(10);
        store.setBrusCount(8);
        Skip();
    }
    //
    // Условие победы
    //
    private void IsVictory()
    {
        if (store.balanse >= 1000)
        {
            JOptionPane jOptionPane = new JOptionPane();
            jOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Победа!");
        }
    }
    //
    // Пропуск хода
    //
    private void Skip()
    {
       store.Damp();
       ratte.Add();
       ratte.Damage();
       ghost.Damage();
       Update();
       IsVictory();
    }
    //
    // Обновление данных
    //
    private void Update()
    {
        store.balanse += (store.getBrusCount() * 2 + store.getProductCount()); // обновление баланса
        String str = Integer.toString(store.balanse);
        balanseField.setText(str);
        str = Integer.toString(store.getBrusCount());
        brusField.setText(str);
        str = Integer.toString(store.getProductCount());
        productField.setText(str);
        str = Integer.toString(ratte.count);
        ratteCountField.setText(str);
    }
}


