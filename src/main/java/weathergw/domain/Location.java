package weathergw.domain;

import weathergw.dal.ProviderManager;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by lfalcao on 07/03/16.
 */
public class Location {
    private String name;
    private final ProviderManager PROVIDER_MANAGER;

    public Location(String name, ProviderManager provider_manager) {
        this.name = name;
        PROVIDER_MANAGER = provider_manager;
    }


    public void add(WeatherInfo weatherInfo) {
        Objects.requireNonNull(weatherInfo, "weatherInfo cannot be null");

    }

  /*  public WeatherInfo get(LocalDate date) {
        return weatherInfos.get(date);
    }


    @Override
    public Iterator<WeatherInfo> iterator() {
        return weatherInfos.values().iterator();
    }

    public Collection<WeatherInfo> weatherInfos() {
        return Collections.unmodifiableCollection(weatherInfos.values());
    }
*/
    public List<WeatherInfo> getHistory(LocalDate start, LocalDate end) {

        return PROVIDER_MANAGER.getHistory(name, start, end);
    }

}
