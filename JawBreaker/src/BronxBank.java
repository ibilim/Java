import java.time.LocalDate;
import java.time.Period;

public class BronxBank {

    private final double DEBT_RATE=0.1;
    private final double SAVING_RATE=0.055;
    private final LocalDate savingAccountOpenDate;
    private final LocalDate loanAccountOpenDate;
    private final double accountBalanceStart;
    private double loanBalanceStart;
    private double accountBalanceCurrent;
    private double loanBalanceCurrent;

    public BronxBank() {
        this.accountBalanceStart =0;
        this.savingAccountOpenDate=LocalDate.now();
        this.loanBalanceStart =0;
        this.loanAccountOpenDate=LocalDate.now();
    }

    public void addToSavingAccount(double moneyToSave) {
        if (loanAccountOpenDate != null) {
            System.out.println("You already have an account. You can add money to your account");
        }
        this.accountBalanceCurrent +=moneyToSave;
    }

    public double getDEBT_RATE() {
        return DEBT_RATE;
    }

    public double getSAVING_RATE() {
        return SAVING_RATE;
    }

    public LocalDate getSavingAccountOpenDate() {
        return savingAccountOpenDate;
    }

    public LocalDate getLoanAccountOpenDate() {
        return loanAccountOpenDate;
    }

    public double getAccountBalanceStart() {
        return accountBalanceStart;
    }

    public double getLoanBalanceStart() {
        return loanBalanceStart;
    }

    public void setLoanBalanceStart(double loanBalanceStart) {
        this.loanBalanceStart = loanBalanceStart;
    }

    public double getAccountBalanceCurrent() {
        Period period=Period.between(this.savingAccountOpenDate,LocalDate.now());
        int days=period.getYears()*365+period.getMonths()*30+period.getDays();
        this.accountBalanceCurrent =this.accountBalanceStart;
        for (int i = 0; i < days; i=i+1) {
            accountBalanceCurrent = accountBalanceCurrent + accountBalanceCurrent *this.getSAVING_RATE();
        }
        return accountBalanceCurrent;
    }

    public double getLoanBalanceCurrent() {
        Period period=Period.between(this.loanAccountOpenDate,LocalDate.now());
        int days= period.getDays();
        this.loanBalanceCurrent =this.loanBalanceStart;
        for (int i = 0; i < days; i=i+1) {
            loanBalanceCurrent = loanBalanceCurrent + loanBalanceCurrent *this.getDEBT_RATE();
        }
        return -loanBalanceCurrent;
    }

    public void setLoanBalanceCurrent(double loanBalanceCurrent) {
        this.loanBalanceCurrent = loanBalanceCurrent;
    }

    @Override
    public String toString() {
        return "BronxBank{" +
                ", accountBalanceStart=" + accountBalanceStart +
                ", loanBalanceStart=" + loanBalanceStart +
                ", accountBalanceCurrent=" + accountBalanceCurrent +
                ", loanBalanceCurrent=" + loanBalanceCurrent +
                '}';
    }
}

