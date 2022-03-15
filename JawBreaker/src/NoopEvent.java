import java.time.Duration;

public class NoopEvent extends Event{
    public NoopEvent(String about, Duration durtation) {
        super(about, durtation);
    }

    @Override
    void process(Player player, Candy candy) {
        System.out.println(this.getAbout());

    }
}
