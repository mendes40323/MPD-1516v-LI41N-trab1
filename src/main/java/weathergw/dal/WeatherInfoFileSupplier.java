package weathergw.dal;

import weathergw.domain.WeatherInfo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by lfalcao on 11/03/16.
 */
public class WeatherInfoFileSupplier extends WeatherInfoCsvSupplier implements Supplier<Collection<WeatherInfo>> {


    public WeatherInfoFileSupplier(String filename) {
        super(filename);
    }

    protected List<String> readFile() {
        try {
            //ClassLoader.getSystemResource
            Path p = Paths.get(ClassLoader.getSystemResource(location).toURI());
            return Files.readAllLines(p);

            //return Files.readAllLines(Paths.get(location));
        } catch (IOException | URISyntaxException e) {
            // TODO Should log to some log mechanism
            e.printStackTrace();
            return null;
        }
    }
}
