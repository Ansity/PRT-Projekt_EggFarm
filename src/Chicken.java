public abstract class Chicken {
    public int chickenPensionCost;
    private int chickenMoneyPrice;
    private int chickenEggPrice;
    private int chickenEggProfit;

    int chickenCounterStarter=1;
    private int chickenCounter;
    double chickenLife;

    public void setChickenLife(double chickenLife) {
        this.chickenLife = chickenLife;
    }

    public Chicken() {
        chickenCounter = chickenCounterStarter;
        chickenCounter++;
        chickenLife=100;
        chickenPensionCost = 100;
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

//    public int reducedChickenLife80HP() {
//        return chickenEggProfit = chickenEggProfit - 1;
//    }
//
//    public int reducedChickenLife50HP() {
//        return chickenEggProfit = chickenEggProfit - 2;
//    }
}
