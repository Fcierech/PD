import java.time.LocalTime;

public abstract class Clock {

    public int h, m, s;
    private City city;

    public Clock(City city) {
        this.city = city;
        setCurrentTime();
    }

    public void setCurrentTime() {
        LocalTime now = LocalTime.now();
        int utc = now.getHour();

        if (city != null) {
            utc += city.getUtc();
            utc = (utc + 24) % 24;
        }

        this.h = utc;
        this.m = now.getMinute();
        this.s = now.getSecond();
    }

    private LocalTime time;
    public void time(int h, int m, int s){
        if(h >= 24 || h<0){
            throw new IllegalArgumentException("Godzina nie jest w zakresie");
        }
        if(m >= 60 || m < 0){
            throw new IllegalArgumentException("Minuta nie jest w zakresie");
        }
        if(s >= 60 || s < 0){
            throw new IllegalArgumentException("Sekunda nie jest w zakresie");
        }
        this.time = LocalTime.of(h,m,s);
    }
    public String toString(){
        return String.format("%02d:%02d:%02d",time.getHour(), time.getMinute(), time.getSecond());
    }

    public void setCity (City newCity) {
        int oldUtc = city != null ? city.getUtc() : 0;
        int newUtc = newCity.getUtc();
        int utcDiff = newUtc - oldUtc;

        this.h = (this.h + utcDiff + 24) % 24;
        this.city = newCity;
    }

}
