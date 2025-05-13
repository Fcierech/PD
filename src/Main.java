import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, City> cities = City.parseFile("strefy.csv");

        Clock clock = new DigitalClock(cities.get("Warszawa"), DigitalClock.ClockType.H24);
        System.out.println("Czas w Warszawie: " + clock);

        clock.setCity(cities.get("Kijów"));
        System.out.println("Po zmianie na Kijów: " + clock);

    }
}