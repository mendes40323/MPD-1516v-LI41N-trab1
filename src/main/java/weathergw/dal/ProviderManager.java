package weathergw.dal;

import weathergw.dal.external.ExternalProviderManager;
import weathergw.domain.WeatherInfo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<WeatherInfo> getHistory(String localName, LocalDate start, LocalDate end){

        throw new UnsupportedOperationException();
    }


    public Map<LocalDate, WeatherInfo> getWeatherInfos(String localName, LocalDate start, LocalDate end) {

        Map<LocalDate, WeatherInfo> result = null;

        if (!MEMORY_PROVIDER.isInMemory(start,end)){

            MEMORY_PROVIDER.setWeatherInfos(EXTERNAL_PROVIDER.getWeatherInfos(localName));

        }


        result = getSelectedDates(MEMORY_PROVIDER.getWeatherInfos(),start,end);

        return result;
    }

    private Map<LocalDate,WeatherInfo> getSelectedDates(Map<LocalDate, WeatherInfo> weatherInfos, LocalDate start, LocalDate end) {

        Map<LocalDate, WeatherInfo> result = new HashMap<>();

        LocalDate curr = start;

        while (curr.isBefore(end) || !curr.isBefore(end)){

            result.put(curr,weatherInfos.get(curr));

            curr = curr.plusDays(1);

        }

        return result;
    }


}
