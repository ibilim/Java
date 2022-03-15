import java.time.Duration;

public abstract class Event {
    private final String about;
    private final Duration durtation;

    public Event(String about, Duration durtation) {
        this.about = about;
        this.durtation = durtation;
    }

    public String getAbout() {
        return about;
    }

    public Duration getDurtation() {
        return durtation;
    }

    abstract void process(Player player,Candy candy);
    @Override
    public String toString() {
        return "Event{" +
                "about='" + about + '\'' +
                ", durtation=" + durtation +
                '}';
    }
}
