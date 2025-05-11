
public class DigitalClock extends Clock {

    public enum ClockType {
        H24, H12;
    }

    private ClockType type;

    public DigitalClock(ClockType type) {
        this.type = type;
        setCurrentTime();
    }

    @Override
    public String toString() {
        if (type == ClockType.H24) {
            return super.toString();
        } else  {
            int h = getHour();
            int m = getMinute();
            int s = getSecond();
        }
    }

    private int getSecond() {
        return
    }

    private int getMinute() {
        return
    }

    private int getHour() {

    }


}
