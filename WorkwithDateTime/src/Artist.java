import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Artist extends Person{
    private ArrayList<MusicInstrument> instruments=new ArrayList<>();


    public Artist(String firstName, String lastName, LocalDate birthdate) {

        super(firstName,lastName,birthdate);
    }

    public boolean addInstrument(MusicInstrument instrument) {

        if (!instruments.contains(instrument)) {
            instruments.add(instrument);
            return true;
        }
        return false;
//        for (MusicInstrument inst : this.instruments) {
//            if (inst.equals(instrument)) {
//                System.out.printf("The instrument %s is already in the List\n",instrument.getName());
//                return false;
//            }
//        }
//        this.instruments.add(Objects.requireNonNull(instrument,"The Instrument must be non-null"));
//        System.out.printf("The instrument %s was added to List \n",instrument.getName());
    }

    public boolean removeInstrument(MusicInstrument instrument) {
        if (instruments.contains(instrument)) {
            instruments.remove(instrument);
            return true;
        }
        return false;
//        for (MusicInstrument instr:this.instruments) {
//            if (instr.equals(instrument)) {
//                this.instruments.remove(instr);
//                System.out.printf("The Instrument %s  was REMOVED \n",instrument.getName());
//                return;
//            }
//        }
//        System.out.printf("\nThe Instrument %s was not found in the List \n",instrument.getName());
    }
    @Override

    public String toString() {
        String format="%s plays %d instruments".formatted(super.toString(),this.instruments.size());
        return format;
    }

    public void listInstruments() {
        for (MusicInstrument instr:this.instruments) {
            System.out.println(instr.getName());
        }
    }
}
