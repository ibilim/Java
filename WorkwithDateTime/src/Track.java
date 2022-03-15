import java.time.Duration;
import java.util.Objects;

public class Track {
    private String titel;
    private Duration duration;

    public Track(String track_name,Duration duration) {
        this.checkRequirements(track_name,duration);
        this.titel=track_name;
        this.duration=duration;
    }

    private void checkRequirements(String title,Duration duration) {
        if (title == null) {
            throw  new IllegalArgumentException("Title can not be null");
        }
        else if (duration == null ) {
            throw  new IllegalArgumentException("duration can not be null");
        }
        else if (duration.toSeconds() <= 0 ) {
            throw  new IllegalArgumentException("Duration must be greater then 0");
        }
    }
    public void setTitel(String titel_name) {
        this.checkRequirements(titel_name,this.duration);
        this.titel=titel_name;
    }

    public String getTitel() {
        return this.titel;
    }

    public void setDuration(Duration time) {
        this.checkRequirements(this.titel,time);
        this.duration=time;
    }

    public void setDuration(long minute,long second) {
        Duration duration=Duration.ofMinutes(minute);
        duration=duration.plusSeconds(second);
        this.checkRequirements(this.titel,duration);
        this.duration=duration;
    }

    public Duration getDuration() {

        return this.duration;
    }

    public int getLengthInSeconds() {
        long long_new=this.duration.toSeconds();
        int long_int=Integer.parseInt(String.valueOf(long_new));
        return long_int;
    }

//    @Override
//    public int hashCode() {
//
//        return (this.titel.hashCode(),this.duration.hashCode());
//    }
    @Override
    public String toString() {
        return "%s  %02d:%02d:%02d ".formatted(this.titel,this.duration.toHours(),this.duration.toMinutesPart(),this.duration.toSecondsPart());
    }

    @Override

    public  boolean equals(Object track) {
        Track a_track=(Track) track;
        if (a_track.getTitel().equals(this.getTitel()) && a_track.getLengthInSeconds()==this.getLengthInSeconds()) {
            return true;
        }
        return false;
    }

     public static Track of(String title,int hours,int minutes, int seconds) {
        long hour_long=hours;
        long minutes_long=minutes;
        long seconds_long=seconds;
        Duration duration=Duration.ofHours(hour_long).plusMinutes(minutes_long).plusSeconds(seconds_long);
        return new Track(title,duration);
    }

     public static Track of(String title, Duration duration) {
        return  new Track(title,duration);
    }
}
