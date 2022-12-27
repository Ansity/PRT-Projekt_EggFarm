public abstract class Chicken {
    public int chickenPensionCost;
    private int chickenMoneyPrice;
    private int chickenEggPrice;
    private int chickenEggProfit;

    static int chickenCounterStarter=1;
    private final int chickenCounter;
    double chickenLife;

    public void setChickenLife(double chickenLife) {
        this.chickenLife = chickenLife;
    }

    public Chicken() {
        chickenCounter = chickenCounterStarter;
        chickenCounterStarter++;
        chickenLife=100;
        chickenPensionCost = 100;
        this.chickenEggProfit = chickenEggProfit();
    }

    public abstract int chickenMoneyPrice();

    public abstract int chickenEggPrice();

    public abstract int chickenEggProfit();


    public void pay(int chickenMoneyPrice) {
    }

    public int getChickenNumber() {
        return chickenCounter;
    }

    public void showChicken() {
        System.out.println("ChickenID: " + chickenCounter);
        System.out.println("Legekapazität: " + chickenEggProfit);
        System.out.println("Gesundheitszustand: " + chickenLife);
        System.out.println("----------------------");
    }

    public void setChickenEggProfit(int chickenEggProfit) {
        this.chickenEggProfit = chickenEggProfit;
    }

//    public int reducedChickenLife80HP() {
//        return chickenEggProfit = chickenEggProfit - 1;
//    }
//
//    public int reducedChickenLife50HP() {
//        return chickenEggProfit = chickenEggProfit - 2;
//    }
}
