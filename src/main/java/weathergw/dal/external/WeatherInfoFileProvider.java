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

    private final String FILE_EXTENSION;

    public WeatherInfoFileProvider(String location, String file_extension) {
        super(location);
        FILE_EXTENSION = file_extension;
    }


    @Override
    protected List<String> readFile() {
        try {

            Path p = Paths.get(ClassLoader.getSystemResource(location + FILE_EXTENSION).toURI());
            return Files.readAllLines(p);


        } catch (IOException | URISyntaxException e) {
            // TODO Should log to some log mechanism
            e.printStackTrace();
            return null;
        }

    }
}
