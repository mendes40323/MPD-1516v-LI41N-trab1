package weathergw.dal;

import weathergw.dal.external.ExternalProviderManager;
import weathergw.domain.WeatherInfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tonym on 29/03/2016.
 */
public class WeatherInfoMemoryProvider {

    private Map<LocalDate, WeatherInfo> weatherInfos;



    public WeatherInfoMemoryProvider() {

    }


    public void setWeatherInfos(Map<LocalDate, WeatherInfo> weatherInfos) {
        this.weatherInfos = weatherInfos;
    }

    public Map<LocalDate, WeatherInfo> getWeatherInfos() {
        return weatherInfos;
    }

    public boolean isInMemory(LocalDate start, LocalDate end){
        if ( weatherInfos == null || weatherInfos.isEmpty())
            return false;

        LocalDate localDate = start;

        while (localDate.isAfter(end) || localDate.isEqual(end)) {
            if (!weatherInfos.containsKey(localDate))
                return false;
            localDate = localDate.plusDays(1);
        }

        return true;
    }
}
