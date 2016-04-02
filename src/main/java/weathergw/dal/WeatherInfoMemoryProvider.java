package weathergw.dal;

import weathergw.dal.external.ExternalProviderManager;
import weathergw.domain.WeatherInfo;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by tonym on 29/03/2016.
 */
public class WeatherInfoMemoryProvider {

    private Collection<WeatherInfo> weatherInfos;



    public WeatherInfoMemoryProvider() {

    }


    public void setWeatherInfos(Collection<WeatherInfo> weatherInfos) {
        if (this.weatherInfos == null || this.weatherInfos.isEmpty())
            this.weatherInfos = weatherInfos;

        else {
            for (WeatherInfo wi : weatherInfos) {

                this.weatherInfos.add(wi);
            }

            this.weatherInfos = sortWeatherInfos(weatherInfos);

        }



    }


    private Collection<WeatherInfo> sortWeatherInfos(Collection<WeatherInfo> weatherInfos) {

        ArrayList<WeatherInfo> array = (ArrayList<WeatherInfo>) weatherInfos;

        for (int i = 0; i < array.size() - 1; ++i) {
            for (int j = array.size() - 1; j > i; --j){
                if ((array.get(j-1).getDate().isAfter(array.get(j).getDate()))){
                   WeatherInfo aux = array.get(j-1);

                    array.set(j-1, array.get(j));

                    array.set(j, aux);

                }
            }
        }



        return array;
    }

    public Collection<WeatherInfo> getWeatherInfos() {
        return weatherInfos;
    }

    public DatesInterval isInMemory(LocalDate start, LocalDate end){
        if ( weatherInfos == null || weatherInfos.isEmpty())
            return new DatesInterval(start,end);

        LocalDate auxStart = start, auxEnd = end;

        Iterator<WeatherInfo> iterator = weatherInfos.iterator();

        while ((weatherInfos.contains(auxStart) || weatherInfos.contains(auxEnd)) && ! auxStart.isEqual(auxEnd)) {

            if (weatherInfos.contains(auxStart))
                auxStart = auxStart.plusDays(1);

            if (weatherInfos.contains(auxEnd))
                auxEnd = auxEnd.minusDays(1);

        }

        return new DatesInterval(auxStart, auxEnd);
    }
}
