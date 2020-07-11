package sample;

public class Store
{
    public boolean isNew = false;
    public int balanse = 0;
    private int productCount = 0;
    private int brusCount = 0;
    private int maxProductCount = 100;
    private int maxBrusCount = 48;
    //
    // Реализация Singlton
    //
    private static Store store;
    private Store(){}
    public static Store getStore()
    {
        if (store == null)
            store = new Store();
        return store;
    }

    public int getProductCount()
    {
        return productCount;
    }

    public int getBrusCount()
    {
        return brusCount;
    }

    public void setProductCount(int count)
    {
        productCount += count;
        if (productCount > maxProductCount)
            productCount = maxProductCount;
        if (productCount < 0)
            productCount = 0;
    }

    public void setBrusCount(int count)
    {
        brusCount += count;
        if (brusCount > maxBrusCount)
           brusCount = maxBrusCount;
        if (brusCount < 0)
            brusCount = 0;
    }
    //
    // Сырость
    //
    public void Damp()
    {
        if (isNew == false)
        {
            if(productCount > 0)
                productCount -= 2;
            if (brusCount > 0)
                brusCount -= 2;
        }
    }
}
