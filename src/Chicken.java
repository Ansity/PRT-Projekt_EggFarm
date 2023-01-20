import java.util.Random;

public abstract class Chicken {
    public int chickenPensionCost = 100;
    protected int chickenMoneyPrice;
    protected int chickenEggPrice;
    protected int chickenEggProfit;

    protected Integer chickenTag;

    static int chickenCounterStarter = 1;
    //  private final int chickenCounter;
    protected int chickenLife;

    public void setChickenLife(int chickenLife) {
        this.chickenLife = chickenLife;
    }

//    public Chicken() {
////        chickenCounter = chickenCounterStarter;

    public int getChickenMoneyPrice() {
        return chickenMoneyPrice;
    }

    public int getChickenEggPrice() {
        return chickenEggPrice;
    }

    public int getChickenEggProfit() {
        return chickenEggProfit;
    }

    public int getChickenLife() {
        return chickenLife;
    }
////        chickenCounterStarter++;
//        //chickenLife=100;
//        //chickenPensionCost = 100;
//        //this.chickenEggProfit = chickenEggProfit();
//    }

//    public abstract int chickenMoneyPrice();
//
//    public abstract int chickenEggPrice();
//
//    public abstract int chickenEggProfit();


    public void pay(int chickenMoneyPrice) {
    }

//    public int getChickenNumber() {
//        return chickenCounter;
//    }

    public void reduceChickenLife() {
        this.chickenLife = this.chickenLife - 5;
    }

    protected Integer generateRandomChickenTag() {
        Random random = new Random();
        int c;
        c = random.nextInt(26);
        return c;
    }

    public Integer getChickenTag() {
        return chickenTag;
    }

    public void setChickenEggProfit(int chickenEggProfit) {
        this.chickenEggProfit = chickenEggProfit;
    }
}
