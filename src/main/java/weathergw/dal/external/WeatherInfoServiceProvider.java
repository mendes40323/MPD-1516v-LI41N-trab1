package weathergw.dal.external;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tonym on 29/03/2016.
 */
public class WeatherInfoServiceProvider extends WeatherInfoExternalProvider {
    private final int MAX_DAYS  = 5;;

    // apikey: 7574602f709e42efb7c151423163103

    // apikey1: 3daff3baaa094ec8a3d171756163103
    public WeatherInfoServiceProvider(String location, String fileExtension) {
        super(location, fileExtension);
    }



    @Override
    protected List<String> readFile() {

        HttpURLConnection conn = null;

        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null ;

        try {

            URL url = new URL(getUrl());

            conn = (HttpURLConnection) url.openConnection();

            fileWriter = new FileWriter("./src/main/resources/" + location + "." + fileExtension);

            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            //bufferedWriter = new BufferedWriter(fileWriter);

            return getServiceReply(bufferedReader, fileWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {
                conn.disconnect();

                fileWriter.close();

                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    private List<String> getServiceReply(BufferedReader bufferedReader, FileWriter bufferedWriter) throws IOException {
        String line;

        List<String> result = new ArrayList<>();

        while((line = bufferedReader.readLine())!= null) {

            result.add(line);

            bufferedWriter.write(line + "\n");

        }

        return result;

    }

    private String getUrl() {

        LocalDate start = LocalDate.now(), end = LocalDate.now().plusDays(MAX_DAYS);

      //  return  "http://api.worldweatheronline.com/free/v2/past-weather.ashx?key=3daff3baaa094ec8a3d171756163103&q=" +
        //       location + "&format=" + fileExtension +"&date=" + start + "&enddate=" + end +"&tp=6";

        return "http://api.worldweatheronline.com/free/v2/past-weather.ashx?key=25781444d49842dc5be040ff259c5&q=lisbon&format=csv&date=2016-2-1&enddate=2016-2-29&tp=24";
    }
}
