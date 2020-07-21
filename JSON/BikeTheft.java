import java.util.Date;

public class BikeTheft {
    String title,city;
    int id;
    long time;
    public BikeTheft(int id, String title, String city)    {
        this.id=id;
        this.title=title;
        this.city=city;
    }
    public String getTime () {
        java.util.Date time = new java.util.Date(this.time*1000);
        return time.toString();
    }
    public void setTime (long time) {
        this.time=time;
    }
    public String toString () {
        String showtime = this.getTime();
        return title+" (id="+time+"), (city="+city+"), (time="+showtime+")";
    }
}
