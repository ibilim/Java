import java.time.LocalDate;
import java.util.ArrayList;

public class Player {
    private  String playerName;
    private ArrayList<Candy> candies; //maximal 100 candies
    private Location location;
    private double cash;
    private double debt;
    private BronxBank bankAccount;
    private final LocalDate startDate;

    public Player(String playerName, Location location) {
        this.cash = 2_000;
        this.debt = 0;
        this.playerName = playerName;
        this.candies = new ArrayList<>();
        this.location = location;
        this.startDate=LocalDate.now();
        this.bankAccount=new BronxBank();
    }

    public void createBankAccount() {
        if (!this.location.equals(new Location(Counties.Bronx))) {
            System.out.println("You should be in Bronx to open a bank account,to laon money or to open saving account");
            return;
        }
        this.bankAccount=new BronxBank();
    }

    public void loanMoney(double moneyToLoan) {
        if (this.getDebt() > 0) {
            System.out.println("You have debts. You can not loan money. Please come back later when you do not have debts");
            return;
        }
        //this.getBankAccount().setLoanBalanceCurrent(this.g); +=moneyToLoan;
    }

    public BronxBank getBankAccount() {
        return this.bankAccount;
    }

    public int getTotalCandies() {
        int total=0;
        for (Candy candy: candies) {
            total+=candy.getQuantity();

        }
        return total;
    }

    public void moveTo(Location location) {
        if (!this.location.equals(location)) {
            double trip_cost=this.location.getDistance(location);
            this.setCash(this.getCash()-trip_cost);
            this.location=location;
            System.out.printf("You just moved to %s \n",location.getLocation_name());
            new RandomEvent().next().process(this,null);
            System.out.println("The trip costet $ %.2f .The cost was withdrawed from your account".formatted(trip_cost));
            return;
        }
        System.out.printf("You are already in %s .You can not move to where you currently stay.\n",location.getLocation_name());
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public ArrayList<Candy> getCandies() {
        return candies;
    }

    public void setCandies(ArrayList<Candy> candies) {
        this.candies = candies;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", candies=" + candies +
                ", location=" + location +
                ", cash= %.2f".formatted(cash) +
                ", debt=" + debt +
                ", BankAccount="+bankAccount.getAccountBalanceCurrent()+
                '}';
    }
}
