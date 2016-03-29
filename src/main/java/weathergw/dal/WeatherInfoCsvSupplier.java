package weathergw.dal;

import weathergw.domain.WeatherInfo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by lfalcao on 14/03/16.
 */
public abstract class WeatherInfoCsvSupplier {
    public static final int WEATHER_INFO_COLS = 9;
    private static final String COMMENT_PREFIX = "#";
    private static final String WEATHER_INFO_SEPARATOR = ",";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:m a");
    protected String location;

    public WeatherInfoCsvSupplier(String location) {
        this.location = location;
    }

    public Collection<WeatherInfo> get() {
        return parseWeatherInfo(readFile());
    }

    protected abstract List<String> readFile();

    private Collection<WeatherInfo> parseWeatherInfo(List<String> lines) {
        ArrayList<WeatherInfo> weatherInfos = new ArrayList<>();
        for (int i = 0; i < lines.size(); ++i) {
            String line = lines.get(i);
            if(isWeateherInfo(line)) {
                weatherInfos.add(parseLine(line));
            }
        }
        return weatherInfos;
    }

    private boolean isWeateherInfo(String line) {
        return !isComment(line) && line.split(WEATHER_INFO_SEPARATOR).length == WEATHER_INFO_COLS;
    }

    private boolean isComment(String line) {
        return line.startsWith(COMMENT_PREFIX);
    }

    private WeatherInfo parseLine(String line) {

        // #date(0),maxtempC(1),maxtempF(2),mintempC(3),
        // mintempF(4),sunrise(5),sunset(6),moonrise(7),moonset(8)
        String[] wicols = line.split(WEATHER_INFO_SEPARATOR);



        return new WeatherInfo(
                LocalDate.parse(wicols[0]), // localDate index 0
                Integer.parseInt(wicols[1]), // maxTempC index 1
                Integer.parseInt(wicols[3]), // minTempC index 3
                parseTime(wicols[5]), // sunrise index 5
                parseTime(wicols[6]), // sunset index 6
                parseTime(wicols[7]), // moonrise index 7
                parseTime(wicols[8]) // moonrise index 8
        );
    }

    private LocalTime parseTime(String timeStr) {

        try {
            return LocalTime.parse(timeStr, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
