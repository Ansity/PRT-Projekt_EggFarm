public class Bank {
    int money = 500;

    public void pay(int chickenMoneyPrice) throws BankruptcyException {
        if (money >= chickenMoneyPrice) {
            money = money - chickenMoneyPrice;
        } else {
            System.out.println("Nicht genügend Geld für den Kauf vorhanden");
            throw new BankruptcyException();
        }
    }

    public int getMoney() {
        return money;
    }

    public void showMoney() {
        System.out.println("Kontostand: " + money + " €");
    }

    public void earn(int tempmoney) {
        money = money + tempmoney;
    }
}
