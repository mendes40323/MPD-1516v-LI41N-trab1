package weathergw.dal.external;

import weathergw.dal.DatesInterval;
import weathergw.domain.WeatherInfo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by tonym on 29/03/2016.
 */
public class ExternalProviderManager {

    private final Collection<WeatherInfoExternalProvider> EXTERNAL_PROVIDERS;

    private Iterator<WeatherInfoExternalProvider> iterator;

    private WeatherInfoExternalProvider currentProvider = null;

    public ExternalProviderManager(Collection<WeatherInfoExternalProvider> external_providers) {
        EXTERNAL_PROVIDERS = external_providers;
        iterator = EXTERNAL_PROVIDERS.iterator();
    }

    public Collection<WeatherInfo> getWeatherInfos(String location, DatesInterval datesInterval) {
        Collection<WeatherInfo> result = null;

        if (!iterator.hasNext())
            iterator = EXTERNAL_PROVIDERS.iterator();

        while (iterator.hasNext()){

            WeatherInfoExternalProvider externalProvider = iterator.next();

            if (externalProvider.getLocation().compareToIgnoreCase(location) == 0) {

                result = externalProvider.get(datesInterval);

                if (result != null && !result.isEmpty() )
                    break;
            }
        }
        return result;

    }


}
