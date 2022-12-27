public class EggShelter {

    double eggs = 20;
    int eggPrice = 2;

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


}
