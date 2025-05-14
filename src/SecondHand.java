import java.time.LocalTime;
import java.util.Locale;

public class SecondHand extends ClockHand {
    public SecondHand(int length) {
        super(length);
    }

    @Override
    public void setTime(LocalTime time) {
        int seconds = time.getSecond();
        this.angle = seconds *6;
    }

    @Override
    public String toSvg() {
        return String.format(Locale.US, """
            <line x1="%d" y1="%d" x2="%d" y2="%d"
                  stroke="red" stroke-width="1.5"
                  transform="rotate(%.1f %d %d)" />
        """,        centerX, centerY, centerX, centerY - length,
                angle, centerX, centerY);
    }
}
