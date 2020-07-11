package sample;

//
// Каспер, портит брусья
//
public class Ghost extends Vermin // можно подогнать под singlton
{
    public static Ghost getGhost(Controller controller1)
    {
        if (ghost == null)
            ghost = new Ghost(controller1);
        return ghost;
    }
    private static Ghost ghost;
    private Ghost(Controller controller)
    {
        this.controller = controller;
    }
    private Controller controller;
    @Override
    public void Damage()
    {
        if (controller.casper.isVisible())
            controller.store.setBrusCount(-4);
    }
}
