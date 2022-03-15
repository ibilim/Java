import java.time.Duration;

public class BuyCandy extends Event{
    public BuyCandy(String about, Duration durtation) {
        super(about, durtation);
    }

    @Override
    void process(Player player,Candy candyToBuy) {
        if (player.getCash() < candyToBuy.getPrice()*candyToBuy.getQuantity()) {
            System.out.println("You do not have enough Money to buy this Candy.");
            return;
        }
        if (player.getCandies().size() == 0) {
            player.getCandies().add(candyToBuy);
            player.setCash(player.getCash()-candyToBuy.getPrice()*candyToBuy.getQuantity());
        } else {
            for (Candy candy:player.getCandies()) {
                if (candyToBuy.equals(candy)) {
                    int q = candy.getQuantity();
                    candy.setQuantity(q + candyToBuy.getQuantity());
                    player.setCash(player.getCash() - candy.getPrice());
                    return;
                } else {
                    player.getCandies().add(candyToBuy);
                    return;
                }
            }
        }

    }
}
