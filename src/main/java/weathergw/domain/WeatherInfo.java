package weathergw.domain;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

/**
 * Instances of this class represent the weather information for one day
 */
public class WeatherInfo {

    private LocalDate localDate;
    private int maxTempC;
    private int minTempC;
    private LocalTime sunrise;
    private LocalTime sunset;
    private LocalTime moonrise;
    private LocalTime moonset;
    private Collection<HourlyInfo> hourlyInfo;

    public WeatherInfo(LocalDate localDate, int maxTempC, int minTempC, LocalTime sunrise, LocalTime sunset, LocalTime moonrise, LocalTime moonset) {
        this.localDate = localDate;
        this.maxTempC = maxTempC;
        this.minTempC = minTempC;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moonrise = moonrise;
        this.moonset = moonset;
    }

    public LocalDate getDate() {
        return localDate;
    }

    public int getMaxTempC() {
        return maxTempC;
    }

    public int getMinTempC() {
        return minTempC;
    }

    public LocalTime getSunrise() {
        return sunrise;
    }

    public LocalTime getSunset() {
        return sunset;
    }

    public LocalTime getMoonrise() {
        return moonrise;
    }

    public LocalTime getMoonset() {
        return moonset;
    }

    public Collection<HourlyInfo> getHourlyInfo() {
        return hourlyInfo;
    }
}
