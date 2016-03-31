package weathergw.dal;

import weathergw.dal.external.ExternalProviderManager;
import weathergw.domain.WeatherInfo;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by tonym on 29/03/2016.
 */
public class WeatherInfoMemoryProvider {

    private Collection<WeatherInfo> weatherInfos;



    public WeatherInfoMemoryProvider() {

    }


    public void setWeatherInfos(Collection<WeatherInfo> weatherInfos) {
        this.weatherInfos = weatherInfos;
    }

    public Collection<WeatherInfo> getWeatherInfos() {
        return weatherInfos;
    }

    public boolean isInMemory(LocalDate start, LocalDate end){
        if ( weatherInfos == null || weatherInfos.isEmpty())
            return false;

        LocalDate localDate = start;

        Iterator<WeatherInfo> iterator = weatherInfos.iterator();

        while (iterator.hasNext() && (localDate.isAfter(end) && !localDate.equals(end))) {
            if (!weatherInfos.contains(localDate))
                return false;
            localDate = localDate.plusDays(1);
        }

        return true;
    }
}
