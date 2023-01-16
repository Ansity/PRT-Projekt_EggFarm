import java.util.ArrayList;

public class Henhouse {

    EggShelter eggShelter = new EggShelter();
    Bank bank = new Bank();

    ArrayList<Chicken> chickenArrayList = new ArrayList<>();

    public Henhouse() {
        this.eggShelter = eggShelter;
        this.bank = bank;
    }

    public void payMoney(int chickenMoneyPrice) throws BankruptcyException {
        bank.pay(chickenMoneyPrice);
    }

    public void payEgg(int chickenEggPrice) throws InsufficientEggException {
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
        ArrayList<Chicken> chickenDeadList = new ArrayList<>();
        for (Chicken chicken : chickenArrayList) {
            chicken.reduceChickenLife();
            if (chicken.getChickenLife() < 80 && chicken.getChickenLife() > 50) {
                if (chicken instanceof AustrianChicken) {
                    chicken.setChickenEggProfit(7);
                } else if (chicken instanceof UsaChicken) {
                    chicken.setChickenEggProfit(6);
                } else if (chicken instanceof ChineseChicken) {
                    chicken.setChickenEggProfit(9);
                } else if (chicken instanceof GermanChicken) {
                    chicken.setChickenEggProfit(3);
                }
            }
            if (chicken.getChickenLife() < 50 && chicken.getChickenLife() > 20) {
                //chicken.setChickenEggProfit(chicken.getChickenEggProfit() - 3);
                if (chicken instanceof AustrianChicken) {
                    chicken.setChickenEggProfit(5);
                } else if (chicken instanceof UsaChicken) {
                    chicken.setChickenEggProfit(4);
                } else if (chicken instanceof ChineseChicken) {
                    chicken.setChickenEggProfit(7);
                } else if (chicken instanceof GermanChicken) {
                    chicken.setChickenEggProfit(1);
                }
            }
            if (chicken.chickenLife < 20) {
                chickenDeadList.add(chicken);
                try {
                    bank.pay(chicken.chickenPensionCost);
                } catch (BankruptcyException e) {
                    System.out.println("Game over! Du hast kein Geld mehr!");
                    System.exit(0);
                }
                System.out.println("Ein Huhn ist in Pension gegangen! Du musst " + chicken.chickenPensionCost + " Bezahlen!");
            }
        }
        chickenArrayList.removeAll(chickenDeadList);
    }

    private void chickenEggCollect() {
        for (Chicken chicken : chickenArrayList) {
            eggShelter.earnEggs(chicken.getChickenEggProfit());
        }
    }

    public void chickenStatus() throws MissingEggsException {
        System.out.println("STATUS EGGFARM:");
        bank.showMoney();
        eggShelter.showEggs();
        listAllChickens();

        if (eggShelter.getEggs() <= 0 && chickenArrayList.size() == 0) {
            throw new MissingEggsException();
        }
    }

    public EggShelter getEggShelter() {
        return eggShelter;
    }

    public void sellAllEggs() {
        if (eggShelter.getEggs() >= 1) {
            bank.earn(eggShelter.getEggs() * 2);
            eggShelter.setEggs(0);
        } else {
            System.out.println("Es sind keine Eier zum Verkauf verfügbar!");
        }
    }


    public void makeArgetaOutOfChicken(int chickenNumberInput) {
        if (chickenArrayList.size() < 1) {
            System.out.println("Keine Hühner vorhanden!");
            return;
        }
        try {
            chickenArrayList.remove(chickenNumberInput - 1);
            bank.earn(50);
        } catch (Exception e) {
            System.out.println("Kein Huhn mit dieser ID gefunden!");
        }

    }

    public void sendChickenToDoctor(int chickenNumberInput) throws BankruptcyException {
        if (eggShelter.getEggs() < 4) {
            System.out.println("Zu wenig Eier vorhanden!");
            return;
        }
        try {
            chickenArrayList.get(chickenNumberInput - 1).setChickenLife(80);
            bank.pay(50);
            eggShelter.pay(4);
        } catch (Exception e) {
            System.out.println("Kein Huhn mit dieser ID gefunden!");
        }
    }

    public void listAllChickens() {

        for (Chicken chicken : chickenArrayList) {
            System.out.println("ChickenID: " + chicken.getChickenTag());
            System.out.println("Legekapazität: " + chicken.getChickenEggProfit());
            System.out.println("Gesundheitszustand: " + chicken.getChickenLife());
            System.out.println("----------------------");
        }
    }

    public Bank getBank() {
        return bank;
    }
}
