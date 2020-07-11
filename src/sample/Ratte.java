package sample;
//
// Крысы
//
public class Ratte extends Vermin
{
    public int count = 0;
    private Controller controller;
    public Ratte(Controller controller)
    {
        this.controller = controller;
    }
    public void Add()
    {
        controller.startRatteImage.setVisible(true);
        count += (count / 5) + 1;
        if (count >= 5)
        {
            controller.casper.setVisible(true);
            controller.ratteAdd.setVisible(true);
        }
        else
            controller.ratteAdd.setVisible(false);
    }
    @Override
    public void Damage()
    {
        controller.store.setProductCount(-count); // число оставшихся продуктов
        if (controller.store.getProductCount() == 0)
        {
            controller.startRatteImage.setVisible(false);
            count = 0; // жрать нечего, крысы ушли
        }
    }
}
