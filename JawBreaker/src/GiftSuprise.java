import java.time.Duration;
import java.util.*;

public class GiftSuprise extends Event{
    public GiftSuprise(String about, Duration durtation) {
        super(about, durtation);
    }

    @Override
    void process(Player player, Candy candyToAdd) {
        Candytype[] candytypes=Candytype.values();
        Random random=new Random();
        Candy candy_random=new Candy(candytypes[random.nextInt(0,candytypes.length)],1);
        if (player.getCandies().size() == 0) {
            player.getCandies().add(candy_random);
            System.out.printf("You just received a gift: %s \n",candy_random.getName());
            return;
        }
        for (Candy candy: player.getCandies()) {
            if (candy.equals(candy_random)) {
                candy.setQuantity(candy.getQuantity() + candy_random.getQuantity());
                System.out.printf("You just received a gift: %s \n",candy_random.getName());
                return;
            }
            else {
                player.getCandies().add(candy_random);
                System.out.printf("You just received a gift: %s \n",candy_random.getName());
                return;
            }
        }

    }
}
