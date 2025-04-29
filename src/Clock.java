import java.time.LocalTime;

public abstract class Clock {

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

    public setCity {

    }

}
