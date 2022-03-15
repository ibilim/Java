import java.util.Objects;

public class Location {

    private Counties location_name;
    private double x;
    private double y;

    public Location(Counties location) {
        this.location_name=location;
        setCoordinates(location);
    }

    public double getDistance(Location location) {
        double x_diff=this.x- location.getX();
        double y_diff=this.y- location.getY();
        return Math.sqrt(x_diff*x_diff+y_diff*y_diff)*100;
    }
    private void setCoordinates(Counties county) {
        switch (county) {
            case Brooklyn -> {this.x=-73.9442;this.y=40.6782;}
            case Bronx -> {this.x=-73.8648 ; this.y=40.8448;}
            case Ghetto -> {this.x=-84.1771 ;this.y= 39.7349 ;}
            case Central_Park -> {this.x=-73.9665 ;this.y= 40.7812 ;}
            case Manhattan -> {this.x=-73.9712 ;this.y= 40.7831 ;}
            case Coney_Island -> {this.x=-73.9707 ;this.y= 40.5755 ;}
        }
    }
    public Counties getLocation_name() {
        return location_name;
    }

    public void setLocation_name(Counties location_name) {
        this.location_name = location_name;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false; //mache einen fehler mit absicht statt || mach
        Location location = (Location) o;
        return x == location.x && y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "{" +
                "location_name=" + location_name +
                '}';
    }
}
