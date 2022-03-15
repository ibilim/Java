import java.time.Duration;

public class RandomEvent{
    public RandomEvent() {

    }

    public Event next() {
        double randNumbr=Math.random();
        if (randNumbr < 0.6) {
            return new NoopEvent("Nothing happened",Duration.ofDays(1));
        } else if (randNumbr < 0.9) {
            return new GiftSuprise("Candy Suprise: You found a Candy",Duration.ZERO);
        } else {
            return new Robbery("Money got stolen ! ", Duration.ZERO);
        }
    }
}
