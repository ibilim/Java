import java.time.LocalDate;

public class SubClass extends SuperClass{
    private int value;

    public SubClass(String name,int value) {
        super(name);
        this.value=value;

    }

    public SubClass() {
        this("maxc",1);
        value=123;
//        this.value geht
//        super(); geht nicht,
    }

//    @Override
//    public void method() {
//        //super.super.method(); geht nicht
//        //super() geht nicht
//        //this() geht nicht
//        super.method();
//    }
    @Override
    public Artist method(String t) {
        super.method(t);
        return new Artist("max","müller",LocalDate.now().minusYears(20));
    }
}
