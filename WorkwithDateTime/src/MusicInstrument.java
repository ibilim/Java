import java.util.Objects;

public class MusicInstrument {
    private String name;

    public MusicInstrument(String musicinstrument) {
        this.checkRequirements(musicinstrument);

        this.name=musicinstrument;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.checkRequirements(name);
        this.name=name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    private void checkRequirements(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can not be blank or null");
        }
    }
    @Override
    public boolean equals(Object instrument) {
        Objects.requireNonNull(instrument,"Instrument can not be null");
        MusicInstrument musicInstrument=(MusicInstrument) instrument;
        if (this.getName().equals(musicInstrument.getName())) {
            return true;
        }
        else {
            return false;
        }

//        if (instrument instanceof MusicInstrument otherInstrument) {
//
//            return this.name.equals(otherInstrument.name);
//        }


    }
    @Override
    public String toString() {
        return this.name;
    }

}
