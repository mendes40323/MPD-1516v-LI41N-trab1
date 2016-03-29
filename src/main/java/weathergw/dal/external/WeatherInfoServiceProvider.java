package weathergw.dal.external;

import java.util.List;

/**
 * Created by tonym on 29/03/2016.
 */
public class WeatherInfoServiceProvider extends WeatherInfoExternalProvider {


    public WeatherInfoServiceProvider(String location) {
        super(location);
    }

    @Override
    protected List<String> readFile() {
        return null;
    }
}
