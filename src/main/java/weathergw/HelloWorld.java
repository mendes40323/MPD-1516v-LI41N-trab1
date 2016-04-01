package weathergw;

import weathergw.dal.ProviderManager;
import weathergw.dal.WeatherInfoMemoryProvider;
import weathergw.dal.external.ExternalProviderManager;
import weathergw.dal.external.WeatherInfoExternalProvider;
import weathergw.dal.external.WeatherInfoFileProvider;
import weathergw.dal.external.WeatherInfoServiceProvider;
import weathergw.domain.Location;
import weathergw.domain.WeatherInfo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.CollationElementIterator;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * Created by lfalcao on 07/03/16.
 */
public class HelloWorld {

    private static String name = "lisbon";// fileName = "weather-data.cvs";
    private static Location location;
    private static ProviderManager providerManager;
    private static ExternalProviderManager externalProviderManager;
    private static WeatherInfoFileProvider fileProvider;
    private static WeatherInfoServiceProvider serviceProvider;
    private static WeatherInfoMemoryProvider memoryProvider;
    private static LocalDate start, end;

    public static void main(String[] args) {
        fileProvider = new WeatherInfoFileProvider(name, "csv");
        serviceProvider = new WeatherInfoServiceProvider(name,"csv");
        memoryProvider = new WeatherInfoMemoryProvider();

       Collection<WeatherInfoExternalProvider> weatherInfoExternalProviders = new ArrayList<>();
        weatherInfoExternalProviders.add(fileProvider);
        weatherInfoExternalProviders.add(serviceProvider);

        externalProviderManager = new ExternalProviderManager(weatherInfoExternalProviders);

        providerManager = new ProviderManager(externalProviderManager);

        location = new Location(name, providerManager);

        start = LocalDate.now().minusDays(10);
        end = start.plusDays(7);

        Collection<WeatherInfo> weatherInfos = location.getHistory(start,end);

        for (WeatherInfo w :weatherInfos)
            System.out.println(w.getDate());

        start = LocalDate.now().minusDays(50);
        end = start.plusDays(39);

        System.out.println();

        System.out.println("##############");
        weatherInfos = location.getHistory(start,end);

        for (WeatherInfo w :weatherInfos)
            System.out.println(w.getDate());


        start = LocalDate.now().minusDays(60);
        end = start.plusDays(49);

        System.out.println();

        System.out.println("##############");
        weatherInfos = location.getHistory(start,end);

        for (WeatherInfo w :weatherInfos)
            System.out.println(w.getDate());


        start = LocalDate.now().minusDays(90);
        end = start.plusDays(60);

        System.out.println();

        System.out.println("##############");
        weatherInfos = location.getHistory(start,end);

        for (WeatherInfo w :weatherInfos)
            System.out.println(w.getDate());



    }
}
