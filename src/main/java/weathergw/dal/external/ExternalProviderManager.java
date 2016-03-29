package weathergw.dal.external;

import weathergw.domain.WeatherInfo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

/**
 * Created by tonym on 29/03/2016.
 */
public class ExternalProviderManager {

    private final Collection<WeatherInfoExternalProvider> EXTERNAL_PROVIDERS;

    public ExternalProviderManager(Collection<WeatherInfoExternalProvider> external_providers) {
        EXTERNAL_PROVIDERS = external_providers;

    }

    public Map<LocalDate,WeatherInfo> getWeatherInfos(String localName) {



        return null;
    }

}
