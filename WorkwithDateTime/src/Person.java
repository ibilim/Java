import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthdate;

    public Person() {

    }

    public Person(String firstName,String lastName,LocalDate birthdate) {
        checkNameRequirements(firstName,lastName);
        checkDateRequirements(birthdate);
        this.firstName=firstName;
        this.lastName=lastName;
        this.birthdate=birthdate;
    }

    public void setFullName(String firstName,String lastName) {
        this.checkNameRequirements(firstName,lastName);
        this.firstName=firstName;
        this.lastName=lastName;
    }

    private void checkNameRequirements(String firstName,String lastName) {
        if (firstName == null || lastName == null || firstName.isBlank() || lastName.isBlank()) {
            throw new IllegalArgumentException("Firstname or Lastname can not be null or empty");
        }
    }

    private void checkDateRequirements(LocalDate date) {
        LocalDate date_now=LocalDate.now();
        Period period=Period.between(date,date_now);
        if (date==null) {
            throw new IllegalArgumentException("Date can not be null");
        } else if (period.isNegative()) {
            throw new IllegalArgumentException("Date can not be set in the future");
        }

    }
    public String getFullName() {
        return this.firstName+" " +this.lastName;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    public int getAge() {
        Period till_now=this.birthdate.until(LocalDate.now());
        return till_now.getYears();
    }

    @Override

    public String toString() {
        String format="Person Details: %s ".formatted(this.getFullName());
        return format;
    }
}
