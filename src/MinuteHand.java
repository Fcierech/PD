import java.time.LocalTime;
import java.util.Locale;

public class MinuteHand extends ClockHand {
    public MinuteHand(int length) {
        super(length);
    }

    @Override
    public void setTime(LocalTime time) {
        int minutes = time.getMinute();
        this.angle = minutes *6;
    }

    @Override
    public String toSvg() {
        return String.format(Locale.US,"""
            <line x1="%d" y1="%d" x2="%d" y2="%d"
                  stroke="blue" stroke-width="2.5"
                  transform="rotate(%.1f %d %d)" />
        """,        centerX, centerY, centerX, centerY - length,
                angle, centerX, centerY);
    }
}
