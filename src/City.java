import java.io.*;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
    private final String name;
    private int utc;
    private final double latitude;
    private final double longitude;


    public City(String name, int utc, double latitude, double longitude) {
        this.name = name;
        this.utc = utc;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public int getUtc() {
        return utc;
    }


    private static City parseLine(String line) {
        String[] values = line.split(",");
        if (values.length != 4) {
            throw new IllegalArgumentException("Nieprawidłowy format.");
        }

        String name = values[0].trim();
        int utc = Integer.parseInt(values[1].trim());

        double lat = parseCoords(values[2].trim());
        double lon = parseCoords(values[3].trim());

        return new City(name, utc, lat, lon);

    }

    private static double parseCoords(String line) {
        String[] coords = line.split(" ");
        double value = Double.parseDouble(coords[0]);

        return value;
    }

    public static Map<String, City> parseFile(String csvFile) {
        Map<String, City> fileData = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean header = true;
            while ((line = reader.readLine()) != null)  {
                if (header) {
                    header = false;
                    continue;
                }

                City city = parseLine(line);
                fileData.put(city.getName(), city);

            }

        } catch (FileNotFoundException e) {
            System.err.println("Brak Pliku: "+ e.getMessage());
        } catch (IOException e) {
            System.err.println("Błąd Odczytu Pliku: "+ e.getMessage());
        }

        return fileData;
    }
    public LocalTime localMeanTime(LocalTime time) {
        double geographicOffsetHours = longitude / 15.0;
        double diff = geographicOffsetHours - utc;

        long diffSeconds = Math.round(diff * 3600);
        return time.plusSeconds(diffSeconds);
    }
    public int timeZoneFit() {
        double geographicOffset = longitude / 15.0;
        double diffHours = geographicOffset - utc;
        return (int) Math.round(Math.abs(diffHours * 3600));
    }
    public static Comparator<City> worstTimezoneFit() {
        return (a, b) -> Integer.compare(b.timeZoneFit(), a.timeZoneFit());
    }



    public static void generateAnalogClocksSvg (List<City> cities, AnalogClock clock) {
        clock.setCurrentTime();
        String catalogName = "AnalogClocks";
        File catalog = new File(catalogName);
        if (!catalog.exists()) {
            catalog.mkdir();
        }

        for (City city : cities) {
            clock.setCity(city);
            clock.setCurrentTime();

            String svgFile = catalogName + "/" + city.getName().replace(" ", "_") + ".svg";
            clock.toSvg(svgFile);
        }
    }
}
