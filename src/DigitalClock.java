public class DigitalClock extends Clock {

    public enum ClockType{
        H24, H12;
    }
    private ClockType type;

    public DigitalClock(ClockType type) {
        this.type = type;
    }

    DigitalClock clock = new DigitalClock(DigitalClock.ClockType.H12) {

    }
    if (ClockType = 12H){
        if(h > 12){
            h - 12;
        }
    }
}
