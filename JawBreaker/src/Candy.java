import java.util.Objects;

public class Candy {
    private Candytype name;
    private int quantity;
    private double price;

    public Candy(Candytype name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.price=this.set_Price();
    }

    private double getRandomNumber() {
        return Math.random();
    }
    private double set_Price() {
        switch (this.name) {
            case Nutella -> {return 15_000*getRandomNumber()*2;}
            case Katjes -> {return 5_000*getRandomNumber()*2.8;}
            case Prigles -> {return 1_000*getRandomNumber()*3.5;}
            case Allpella -> {return 300*getRandomNumber()*3;}
            case Kinderei -> {return 70*getRandomNumber()*3.5;}
            case Snickers -> {return 10*getRandomNumber()*6;}
            default -> {return 0;}
        }
    }

    public Candytype getName() {
        return name;
    }

    public void setName(Candytype name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy candy = (Candy) o;
        return name == candy.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name=" + name +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
