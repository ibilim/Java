import java.time.Duration;

public class SellCandy extends Event{
    public SellCandy(String about, Duration durtation) {
        super(about, durtation);
    }

    @Override
    public void process(Player player, Candy candyToSell) {
        for (Candy player_candy: player.getCandies()) {
            if (player_candy.equals(candyToSell)) {
                int q= player_candy.getQuantity();
                player_candy.setQuantity(q-1);
                player.setCash(player.getCash()+candyToSell.getPrice()*candyToSell.getQuantity());
            }
        }
    }
}
