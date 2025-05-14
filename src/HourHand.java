import java.time.LocalTime;
import java.util.Locale;

public class HourHand extends ClockHand {

    public HourHand(int length) {
        super(length);
    }

    @Override
    public void setTime(LocalTime time) {
        int hours = time.getHour() % 12;
        this.angle = hours *30;
    }

    @Override
    public String toSvg() {
        return String.format(Locale.US,"""
            <line x1="%d" y1="%d" x2="%d" y2="%d"
                  stroke="black" stroke-width="4.5"
                  transform="rotate(%.1f %d %d)" />
        """,        centerX, centerY, centerX, centerY - length,
                angle, centerX, centerY);
    }
}