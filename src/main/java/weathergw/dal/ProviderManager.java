package weathergw.dal;

import weathergw.dal.external.ExternalProviderManager;
import weathergw.domain.WeatherInfo;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by tonym on 29/03/2016.
 */
public class ProviderManager {

    private final WeatherInfoMemoryProvider MEMORY_PROVIDER;

    private final ExternalProviderManager EXTERNAL_PROVIDER;

    public ProviderManager(ExternalProviderManager external_provider) {
        this.MEMORY_PROVIDER = new WeatherInfoMemoryProvider();
        EXTERNAL_PROVIDER = external_provider;
    }

    public List<WeatherInfo> getHistory(String location, LocalDate start, LocalDate end){

       return getWeatherInfos(location,start,end);
    }


    public List<WeatherInfo> getWeatherInfos(String location, LocalDate start, LocalDate end) {

        Map<LocalDate, WeatherInfo> result = null;

        if (!MEMORY_PROVIDER.isInMemory(start,end)){

            MEMORY_PROVIDER.setWeatherInfos(EXTERNAL_PROVIDER.getWeatherInfos(location));

        }


        return getSelectedDates(MEMORY_PROVIDER.getWeatherInfos(),start,end);

    }

    private List<WeatherInfo> getSelectedDates(Collection<WeatherInfo> weatherInfos, LocalDate start, LocalDate end) {

        List<WeatherInfo> result = new ArrayList<>();

        LocalDate curr = start;

        boolean copy = false; // to indicate when to start copying

        Iterator<WeatherInfo> iterator = weatherInfos.iterator();

        while (iterator.hasNext() && (curr.isBefore(end) || !curr.isBefore(end))){

            WeatherInfo weatherInfo = iterator.next();

            curr = weatherInfo.getDate();

            if (curr.equals(start))
                copy = true;

            if (copy)
                result.add(weatherInfo);
        }

        return result;
    }


}
