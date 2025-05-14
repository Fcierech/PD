
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, City> cityMap = City.parseFile("strefy.csv");

        Clock clock = new DigitalClock(cityMap.get("Warszawa"), DigitalClock.ClockType.H12);
        System.out.println("Czas w Warszawie: " + clock);

        clock.setCity(cityMap.get("Kijow"));
        System.out.println("Czas w Kijowie: " + clock);


        List<City> cities = new ArrayList<>(City.parseFile("strefy.csv").values());

        cities.sort(City.worstTimezoneFit());

        for (City c : cities) {
            System.out.println(c.getName() + " - Odchylenie: " + c.timeZoneFit() + " sekund");
        }

        AnalogClock ac = new AnalogClock(cityMap.get("Warszawa"));
        ac.setCurrentTime();
        ac.toSvg("zegar.svg");

        AnalogClock analogClock = new AnalogClock(new City("Warszawa", 2, 52, 21));
        analogClock.toSvg("zegar.svg");

        City.generateAnalogClocksSvg(cities, new AnalogClock(cities.get(0)));
    }
}