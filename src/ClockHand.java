import java.time.LocalTime;

public abstract class ClockHand {

    protected int centerX = 100;
    protected int centerY = 100;
    protected int length;
    protected double angle;

    public ClockHand(int length){
        this.length = length;
    }

    public abstract void setTime (LocalTime time);

    public abstract String toSvg();

}
