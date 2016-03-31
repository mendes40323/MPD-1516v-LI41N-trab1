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
<<<<<<< HEAD

    private final String FILE_EXTENSION;

    public WeatherInfoFileProvider(String location, String file_extension) {
        super(location);
        FILE_EXTENSION = file_extension;
=======
    private String fileExtension;
    public WeatherInfoFileProvider(String location, String fileExtension) {
        super(location);
        this.fileExtension = fileExtension;
>>>>>>> 8f3ecb9dedc545501eb30f1ac85e5560a48b6eeb
    }


    @Override
    protected List<String> readFile() {
        try {

<<<<<<< HEAD
            Path p = Paths.get(ClassLoader.getSystemResource(location + FILE_EXTENSION).toURI());
=======
            Path p = Paths.get(ClassLoader.getSystemResource(location+fileExtension).toURI());
>>>>>>> 8f3ecb9dedc545501eb30f1ac85e5560a48b6eeb
            return Files.readAllLines(p);


        } catch (IOException | URISyntaxException e) {
            // TODO Should log to some log mechanism
            e.printStackTrace();
            return null;
        }

    }
}
