import org.junit.Before;
import org.junit.Test;
import weathergw.domain.Location;
import weathergw.domain.WeatherInfo;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Assert;

/**
 * Created by lfalcao on 07/03/16.
 */
public class LocationTests {
    private Location location;
    private WeatherInfo weatherInfo1;
    private WeatherInfo weatherInfo2;
/*
    @Before
    public void before() {
        location = new Location("Lisbon", provider_manager);
        weatherInfo1 = new WeatherInfo(LocalDate.now(), 14, 11, LocalTime.of(7, 43), LocalTime.of(17, 58), LocalTime.of(1, 9), LocalTime.of(12, 9));
        weatherInfo2 = new WeatherInfo(LocalDate.now().minusDays(1), 14, 11, LocalTime.of(7, 43), LocalTime.of(17, 58), LocalTime.of(1, 9), LocalTime.of(12, 9));


    }

    @Test
    public void shouldBeAbleToAddWeatherInfosToLocation() {
        location.add(weatherInfo1);
        location.add(weatherInfo2);


        int count = 0;
        for (WeatherInfo wi: location) {
            ++count;
        }

        Assert.assertEquals(2, count);
    }
    */
}
