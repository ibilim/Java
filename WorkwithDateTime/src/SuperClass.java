import java.time.LocalDate;

public class SuperClass {

    public SuperClass(String name) {

    }

    public SuperClass() {

    }

    public void anotherMethod() {
        this.method("hehe");
    }

    public Person  method(String name) {

        return new Person();
    }
}
