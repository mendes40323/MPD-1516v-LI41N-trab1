package weathergw.domain;

/**
 * Created by lfalcao on 07/03/16.
 */
public class HourlyInfo {
    private int hour;
    private int tempC;
    private int windSpeedKmh;
    private WeatherInfo weatherInfo;

    public HourlyInfo(int hour, int tempC, int windSpeedKmh, WeatherInfo weatherInfo) {
        this.hour = hour;
        this.tempC = tempC;
        this.windSpeedKmh = windSpeedKmh;
        this.weatherInfo = weatherInfo;
    }

    public int getTempC() {
        return tempC;
    }

    public int getWindSpeedKmh() {
        return windSpeedKmh;
    }

    public int getHour() {
        return hour;
    }

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }
}
