public class LeaderboardEntry {
    private String userName;
    private int money;
    private int days;

    public LeaderboardEntry(String userName, int money, int days) {
        this.userName = userName;
        this.money = money;
        this.days = days;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
