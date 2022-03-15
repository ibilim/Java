import java.time.Duration;
import java.util.ArrayList;

public class Robbery extends Event {
    public Robbery(String about, Duration durtation) {
        super(about, durtation);
    }

    @Override
    void process(Player player, Candy candy) {
        player.setCandies(null); //mit absicht auf null gesetzt
        double old_balance=player.getCash();
        player.setCash(player.getCash()*Math.random());
        double new_balance=player.getCash();
        System.out.printf("Unfortunately you were Robbed. You Lost your all candies and $ %.2f \n".formatted(old_balance-new_balance));
    }
}
