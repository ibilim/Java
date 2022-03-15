import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;

public class Album {
    private ArrayList<Track> tracks=new ArrayList<Track>();
    private String title;
    private MusicGenre genre;
    private Artist artist;


    public Album(String album_name) {
        Objects.requireNonNull(album_name,"ALbum title can not be null");
        this.title=album_name;

    }

    public boolean addTrack(Track track) {

//        if (!tracks.contains(track)) {
//            tracks.add(track);
//            return true;
//        }
//        return false;
        for (Track trck: tracks) {
            if (trck.equals(track)) {
                System.out.printf("\nThe Track :%s  is already in Album\n", track.getTitel());
                return false;
            }
        }
        tracks.add(Objects.requireNonNull(track,"Track can not be null"));
        return true;
    }

    public boolean removeTrack(Track track) {
//        if (tracks.contains(track)) {
//            tracks.remove(track);
//            return true;
//        } return false;
        for (int i = 0; i < tracks.size(); i = i + 1) {
            if (tracks.get(i).equals(track)) {
                tracks.remove(i);
                System.out.printf("\nThe track : %s was  REMOVED from the Album \n",track.getTitel());
                return true;
            }
        }
        System.out.printf("\nThe track : %s was not found in ALbum\n",track.getTitel());
        return false;
    }
    public boolean removeTrack(String title) {
        for (int i = 0; i < tracks.size(); i = i + 1) {
            if (tracks.get(i).getTitel()==title) {
                tracks.remove(tracks.get(i));
                System.out.printf("\nThe track : %s was  REMOVED from the Album ",title);
                //this.listTracks();
                return true;
            }
            else {
                System.out.printf("\nThe track : %s was not found in ALbum",title);
                return false;
            }
        }
        return false;
    }

    public Duration getTotalDuration() {
        Duration duration=Duration.ofSeconds(0);
        for (int i=0;i<this.tracks.size();i=i+1) {
            duration=duration.plus(this.tracks.get(i).getDuration());
        }
        return duration;
    }

    public void listTracks() {
        for (int i = 0; i < tracks.size(); i = i + 1) {
            String track_name="%d. ".formatted(i+1)+tracks.get(i).getTitel();
            System.out.println(track_name);
        }
    }

    public void setGenre(MusicGenre genre) {
        this.genre=genre;
    }

    public MusicGenre getGenre() {
        return this.genre;
    }

    public void setTitel(String title) {
        this.title=title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setArtist(Artist artist) {
        this.artist=artist;
    }

    public Artist getArtist() {
        return this.artist;
    }

    @Override
    public String toString() {
        String format="%s (%d Tracks, %d Minutes %d Seconds) ".formatted(this.title,tracks.size(),this.getTotalDuration().toMinutesPart(),this.getTotalDuration().toSecondsPart());
        return format;
    }

}
