import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.io.FileReader;

public class City {
    private final String name;
    private int utc = 0;
    private final double latitude;
    private final double longitude;


    public City(String name, int utcOffset, double latitude, double longitude) {
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

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
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
    public LocalTime localMeanTime (LocalTime time) {
        long howManySecs = (long) ((longitude/180.0)*(12*60*60));
        return time.plusSeconds(howManySecs);

    }
    public int timeZoneFit(){
        timezone*60*60 - ((position-180.0)*(12*60*60))
    }
    public static int worstTimezoneFit (City a, City b){
        a.timeZoneFit - b.timeZoneFit();
    }


    public generateAnalogClocksSvg {
    }
}
