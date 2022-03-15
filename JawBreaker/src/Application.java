import java.time.Duration;
import java.util.Random;

public class Application {
    public static void main(String[] args) {

        Event buyCandy=new BuyCandy("Buy Candy", Duration.ZERO);
        Event sellCandy=new SellCandy("Sell Candy",Duration.ZERO);
        Event robbery=new Robbery("Robbery",Duration.ZERO);
        Event gift=new GiftSuprise("You have a gift",Duration.ZERO);
        Location location=new Location(Counties.Brooklyn);
        Player player=new Player("Ibrahim",location);
        System.out.println(player);
        Candy alpella=new Candy(Candytype.Allpella,1);
        Candy kinderei=new Candy(Candytype.Kinderei,1);
        Candy snickers=new Candy(Candytype.Snickers,1);
//        System.out.println(alpella.getPrice());

        buyCandy.process(player,alpella);
        buyCandy.process(player,kinderei);
        buyCandy.process(player,snickers);
        gift.process(player,null);
        //player.buyCandy(alpella),1);
        System.out.println(player);
        sellCandy.process(player,alpella);
        System.out.println(player);
        player.moveTo(new Location(Counties.Brooklyn));
        System.out.println(player);
        player.moveTo(new Location(Counties.Central_Park));
        player.getBankAccount();
        System.out.println(player);
        player.moveTo(new Location(Counties.Bronx));
        player.createBankAccount();
//        System.out.printf("%.2f Km \n".formatted(location.getDistance(new Location(Counties.Central_Park))));
        //robbery.process(player,null);
        System.out.println(player);

//        Candytype[] candytypes=Candytype.values();
//        Random random=new Random();
//        Candy candy_random=new Candy(candytypes[random.nextInt(0,candytypes.length)],1);
//        System.out.println(candy_random);
//        for (Candytype candytype: candytypes) {
//            System.out.println(candytype);
//        }



    }
}
