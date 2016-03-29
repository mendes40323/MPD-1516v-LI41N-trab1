package weathergw.dal.external;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by tonym on 29/03/2016.
 */
public class WeatherInfoFileProvider extends WeatherInfoExternalProvider {
    public WeatherInfoFileProvider(String location) {
        super(location);
    }

    @Override
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
