
public class DigitalClock extends Clock {

    public enum ClockType {
        H24, H12;
    }

    private ClockType type;

    public DigitalClock(City city, ClockType type) {
        super(city);
        this.type = type;
        setCurrentTime();
    }

    @Override
    public String toString() {
        if (type == ClockType.H24) {
            return super.toString();
        } else  {
            String ampm = h < 12 ? "AM" : "PM";
            h = h % 12;
            if (h == 0) h = 12; 
            return String.format("%d:%02d:%02d %s", h, m, s, ampm);
        }
    }

}
