package weathergw.domain;

import weathergw.common.Predicate;
import weathergw.dal.WeatherInfoFileSupplier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

/**
 * Supports several queries for WeatherInfo collections.
 */
public class WeatherInfoQueries {
    private static Supplier<Collection<WeatherInfo>> supplier;

    public WeatherInfoQueries(Supplier<Collection<WeatherInfo>> supplier) {

        this.supplier = supplier;
    }

    public int getMaxTemp() {
        Collection<WeatherInfo> weatherInfos = supplier.get();
        WeatherInfo maxWi = null;
        for (WeatherInfo wi: weatherInfos) {
            if(maxWi == null) {
                maxWi = wi;
            } else {
                if(wi.getMaxTempC() > maxWi.getMaxTempC()) {
                    maxWi = wi;
                }
            }
        }

        return maxWi.getMaxTempC();
    }

    public List<WeatherInfo> getWithMaxTemperaturesBetween(int min, int max) {
//        return filter(new Predicate<WeatherInfo>() {
//            @Override
//            public boolean evaluate(WeatherInfo wi) {
//                return wi.getMaxTempC() >= min && wi.getMaxTempC() < max;
//            }
//        });
        return  filter(wi -> wi.getMinTempC() >= min && wi.getMinTempC() < max);
    }

    public List<WeatherInfo> getWithMinTemperaturesBetween(int min, int max) {
        return filter(new Predicate<WeatherInfo>() {
            @Override
            public boolean evaluate(WeatherInfo wi) {
                return wi.getMinTempC() >= min && wi.getMinTempC() < max;
            }
        });
    }

    public List<WeatherInfo> filter(Predicate<WeatherInfo> pred) {
        Collection<WeatherInfo> weatherInfos = supplier.get();
        List<WeatherInfo> filtered = new ArrayList<>();
        for (WeatherInfo wi: weatherInfos) {
            if(pred.evaluate(wi)) {
                filtered.add(wi);
            }
        }
        return filtered;
    }
}
