import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalogClock extends Clock {


    private final List<ClockHand> hands;

    public AnalogClock(City city) {
        super(city, false);
        this.hands = new ArrayList<>();
        this.hands.add(new HourHand(50));
        this.hands.add(new MinuteHand(70));
        this.hands.add(new SecondHand(90));
        setCurrentTime();
    }
    @Override
    protected void onTimeChanged() {
        if (hands != null) {
            for (ClockHand hand : hands) {
                hand.setTime(this.time);
            }
        } else {
            System.out.println("Lista wskazówek (hands) jest null!");
        }
    }

    public void toSvg (String svgFile){
        int size = 200;
        int center = size/2;
        int radius = center - 10;

        StringBuilder svg = new StringBuilder();
        svg.append(String.format("""
            <svg xmlns="http://www.w3.org/2000/svg" width="%d" height="%d">
                <circle cx="%d" cy="%d" r="%d" stroke="black" stroke-width="4" fill="white" />
        """, size, size, center, center, radius));

        for (ClockHand hand : hands) {
            svg.append("  ").append(hand.toSvg()).append("\n");
        }

        svg.append("\n</svg>");

        try (FileWriter writer = new FileWriter(svgFile))  {
            writer.write(svg.toString());
        } catch (IOException e) {

        }
    }

}
