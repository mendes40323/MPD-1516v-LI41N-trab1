package weathergw.dal;

import org.junit.Test;
import weathergw.domain.WeatherInfo;

import java.util.Collection;
import java.util.function.Supplier;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by lfalcao on 11/03/16.
 */
public class WeatherDataSuplierTests {
    @Test
    public void shouldObtainWeatherInfosFromFile() {
        validateWeaherInfoSupplier(new WeatherInfoFileSupplier("weather-data.csv"));
    }

    @Test
    public void shouldObtainWeatherInfosFromService() {
        validateWeaherInfoSupplier( new WeatherInfoServiceSupplier("http://api.worldweatheronline.com/free/v2/past-weather.ashx?key=25781444d49842dc5be040ff259c5&q=lisbon&format=csv&date=2016-2-1&enddate=2016-2-29&tp=6"));
    }


    //////// Helper test methods ///////////////////////////
    private void validateWeaherInfoSupplier(Supplier<Collection<WeatherInfo>> d) {
        Collection<WeatherInfo> weatherInfos = d.get();

        assertNotNull(weatherInfos);
        for (WeatherInfo wi: weatherInfos) {
            assertNotNull(wi);
            assertTrue(wi.getMaxTempC() > -150);
            assertTrue(wi.getMaxTempC() < 65);
            assertTrue(wi.getMaxTempC() >= wi.getMinTempC());
        }
    }

}
