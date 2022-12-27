import java.util.ArrayList;

public class Henhouse {

    EggShelter eggShelter = new EggShelter();
    Bank bank = new Bank();

    ArrayList<Chicken>chickenArrayList=new ArrayList<>();

    public Henhouse() {
        this.eggShelter = eggShelter;
        this.bank = bank;
    }

    public void payMoney(int chickenMoneyPrice) throws BankruptcyException {
        bank.pay(chickenMoneyPrice);
    }

    public void payEgg(int chickenEggPrice) throws InsufficientEggException{
        eggShelter.pay(chickenEggPrice);
    }

    public void add(Chicken chicken) {
        chickenArrayList.add(chicken);
    }

    public void dailyRun() {
        chickenEggCollect();
        chickenDead();
    }

    private void chickenDead() {
        ArrayList<Chicken>chickenDeadList = new ArrayList<>();
        for(Chicken chicken:chickenArrayList){
            if(chicken.chickenLife <= 20){
                chickenDeadList.add(chicken);
                try {
                    bank.pay(chicken.chickenPensionCost);
                } catch (BankruptcyException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Ein Huhn ist in Pension gegangen! Du musst " + chicken.chickenPensionCost + " Bezahlen!");
            }
            else if(chicken.chickenLife <= 50){
                chicken.setChickenEggProfit(chicken.chickenEggProfit() - 3);
                //chicken.chickenEggProfit() = chicken.chickenEggProfit() - 3;
                //TODO EggProfitÄnderung wird nicht übertragen
               //chicken.setChickenLife();
            }
            else if (chicken.chickenLife <= 80){
                chicken.setChickenEggProfit(chicken.chickenEggProfit() - 1);
            }

            chicken.chickenLife = chicken.chickenLife - 5;
        }
        for (Chicken chicken : chickenDeadList){
            chickenArrayList.remove(chicken);
        }
    }

    private void chickenEggCollect() {
        for (Chicken chicken:chickenArrayList){
            eggShelter.earnEggs(chicken.chickenEggProfit());
        }
    }

    public void chickenStatus() throws MissingEggsException{
        System.out.println("STATUS EGGFARM:");
        bank.showMoney();
        eggShelter.showEggs();
        for (Chicken chicken : chickenArrayList){
            chicken.showChicken();
        }

        if(eggShelter.eggs <= 0 && chickenArrayList.size() == 0){
            throw new MissingEggsException();
        }
    }

    public EggShelter getEggShelter() {
        return eggShelter;
    }

    public void sellAllEggs() {
        if (eggShelter.eggs >=1){
           bank.money = bank.money + eggShelter.eggs * 2;
           eggShelter.eggs = 0;
        }
        else {
            System.out.println("Es sind keine Eier zum Verkauf verfügbar!");
        }
    }


    public void makeArgetaOutOfChicken(int chickenNumberInput) {
        ArrayList<Chicken> chickenDeadList = new ArrayList<>();

        for (Chicken chicken : chickenArrayList){
            if (chickenNumberInput == chicken.getChickenNumber()){
                chickenDeadList.add(chicken);
                bank.earn(50);
            }
            else {
                System.out.println("HühnerID nicht gefunden!");
            }
        }
        for (Chicken chicken : chickenDeadList){
            chickenArrayList.remove(chicken);
        }
    }

    public void sendChickenToDoctor(int chickenNumberInput) {
        for(Chicken chicken : chickenArrayList){
            if (chickenNumberInput == chicken.getChickenNumber()){
                try {
                    payEgg(4);
                } catch (InsufficientEggException e) {
                    throw new RuntimeException(e);
                }
                try {
                    payMoney(50);
                } catch (BankruptcyException e) {
                    throw new RuntimeException(e);
                }
                chicken.setChickenLife(80);
            }
            else{
                System.out.println("HühnerID nicht gefunden!");
            }
        }
    }
}
