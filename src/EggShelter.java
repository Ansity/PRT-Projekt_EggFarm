public class EggShelter {

    private int eggs = 20;
    int eggPrice = 2;

    public void setEggs(int eggs) {
        this.eggs = eggs;
    }

    public void pay(int chickenEggPrice) {
        if (eggs >= chickenEggPrice){
            eggs = eggs - chickenEggPrice;
        }
        else{
            System.out.println("Nicht genügend Eier für ein Huhn vorhanden!");
        }
    }

    public void showEggs() {
        System.out.println("Eierbestand: " + eggs + " Eier");
    }

    public void earnEggs(int chickenEggProfit) {
        eggs=eggs+chickenEggProfit;
    }


    public int getEggs() {
        return eggs;
    }
}
