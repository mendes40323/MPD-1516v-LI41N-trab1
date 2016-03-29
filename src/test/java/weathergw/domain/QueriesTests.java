package weathergw.domain;

import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

/**
 * Created by lfalcao on 14/03/16.
 */
public class QueriesTests {

    @Test
    public void shouldObtainMaxTemp() {
        Supplier<Collection<WeatherInfo>> sup = getSupplier(25, 10, 15);

        WeatherInfoQueries queries = new WeatherInfoQueries(sup);
        int maxTemp = queries.getMaxTemp();

        assertEquals(25, maxTemp);
    }

    @Test
    public void shouldWeatherInfosBetweenMaxTemperatures() {
        Supplier<Collection<WeatherInfo>> sup = getSupplier(25, 10, 20, 19);


        WeatherInfoQueries queries = new WeatherInfoQueries(sup);
        List<WeatherInfo> winfos = queries.getWithMaxTemperaturesBetween(10, 20);

        assertEquals(2, winfos.size());
        assertEquals(10, winfos.get(0).getMaxTempC());
        assertEquals(19, winfos.get(1).getMaxTempC());
    }

    @Test
    public void shouldWeatherInfosBetweenMinTemperatures() {
        Supplier<Collection<WeatherInfo>> sup = getSupplier(25, 10, 20, 19);


        WeatherInfoQueries queries = new WeatherInfoQueries(sup);
        List<WeatherInfo> winfos = queries.getWithMinTemperaturesBetween(10, 20);

        assertEquals(2, winfos.size());
        assertEquals(10, winfos.get(0).getMinTempC());
        assertEquals(19, winfos.get(1).getMinTempC());
    }



    private Supplier<Collection<WeatherInfo>> getSupplier(final int ...maxTemps) {
        return new Supplier<Collection<WeatherInfo>>() {

            @Override
            public Collection<WeatherInfo> get() {
                ArrayList<WeatherInfo> al = new ArrayList<>();
                for (int i: maxTemps) {
                    al.add(new WeatherInfo(null, i, 0, null, null, null, null));
                }
                return al;
            }
        };
    }


}
