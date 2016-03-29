package weathergw.dal;

import weathergw.domain.WeatherInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

/**
 * Created by lfalcao on 11/03/16.
 */
public class WeatherInfoServiceSupplier extends WeatherInfoCsvSupplier implements Supplier<Collection<WeatherInfo>> {


    public WeatherInfoServiceSupplier(String url) {
        super(url);
    }

    protected List<String> readFile() {
        try {
            URL url = new URL(location);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            return reader.lines().collect(toList());
        } catch (IOException e) {
            // TODO Should log to some log mechanism
            e.printStackTrace();
            return null;
        }
    }
}
