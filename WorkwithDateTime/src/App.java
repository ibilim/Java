import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.net.*;

public class App {
    public static void main(String[] args) {
//        Player player=new Player("jack");
//        Player player1=new Player("jones");
//        Candy lolipop=new Candy("lollipop");
//        Candy schoko=new Candy("Schokolade");
//        player.setCandy(lolipop);
//        player1.setCandy(schoko);
//        player.setCandy(schoko);
//
//        lolipop.getOwner();
//        player1.getCandy();
//        player.getCandy();

        Duration duration=Duration.ofSeconds(285);
        Track oynama_sikidim=new Track("OYNAMA SIKIDIM SIKIDIM",duration);
        System.out.println(oynama_sikidim);
        //oynama_sikidim.setTitel("OYNAMA SIKIDIM SIKIDIM2");
        //System.out.println(oynama_sikidim.getTitel());
        oynama_sikidim.setDuration(3,1);
        //System.out.println(oynama_sikidim.getLengthInSeconds());
        //System.out.println(oynama_sikidim.getDuration());
        Duration duration2=duration.minusMinutes(1);
        Track simarik=new Track("SIMARIK",duration2);
        Track dudu=simarik.of("Du Du",duration.plusMinutes(2));
        Track sen_baskasin=dudu.of("Sen Baskasin",0,2,60);

        //System.out.println(simarik.equals(simarik));
        Album tarkan=new Album("TARKAN");
        tarkan.addTrack(oynama_sikidim);
        tarkan.addTrack(simarik);
        tarkan.addTrack(dudu);
        tarkan.addTrack(Track.of("Zilli",2,24,10));
        tarkan.addTrack(sen_baskasin);
        System.out.println(tarkan);
        System.out.println(tarkan.getTotalDuration());
        tarkan.listTracks();
        //System.out.println(simarik.equals(tarkan.));
        tarkan.removeTrack(simarik);
        tarkan.removeTrack(simarik);
        tarkan.listTracks();
        System.out.println(tarkan);
        tarkan.setGenre(MusicGenre.POP);
        //simarik.setTitel(null);
        LocalDate birthdate=LocalDate.of(1985,8,10);
        Artist jack_jones=new Artist("Jack","Jones",birthdate);
        System.out.println(jack_jones.getBirthdate());
        System.out.println(jack_jones);
        MusicInstrument zurna=new MusicInstrument("zurna");
        //System.out.println(zurna);
        MusicInstrument davul=new MusicInstrument("davul");
        //System.out.println(davul);
        jack_jones.addInstrument(zurna);
        jack_jones.addInstrument(davul);
//        System.out.println(davul.equals(davul));
        jack_jones.addInstrument(davul);
        //jack_jones.addInstrument(davul);
        jack_jones.listInstruments();
        jack_jones.removeInstrument(davul);
        jack_jones.removeInstrument(davul);
        //jack_jones.removeInstrument(zurna);
        jack_jones.listInstruments();
        System.out.println(jack_jones);


        SubClass subObject=new SubClass();
        SuperClass superObject=new SuperClass();
        subObject=(SubClass) superObject;  //downcasting
        SuperClass o=new SubClass(); //upcasting

        SubClass subObjekt_new=new SubClass();
        subObjekt_new.method("vom konsole");


    }
}
