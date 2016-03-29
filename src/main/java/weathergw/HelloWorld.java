package weathergw;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

/**
 * Created by lfalcao on 07/03/16.
 */
public class HelloWorld {
    public static void main(String[] args) {
        URL url = ClassLoader.getSystemResource("foo/text.txt");
        Path path = null;
        try {

            LocalDate ld1 = LocalDate.of(2017,05,01);
            LocalDate ld2 = LocalDate.of(2016,06,15);

            long total1 = (ld1.isLeapYear()?ld1.getYear()*366:365);

            long total2 = (ld2.isLeapYear()?ld2.getYear()*366:365) + ld2.getMonthValue() + ld2.getDayOfMonth();


            System.out.println(ld1.plusDays(6).getDayOfYear());

            path = Paths.get(url.toURI());

            System.out.println("Em primeiro lugar, boa noite. Em 2º o Sporting.");

            System.out.println(Files.readAllLines(path));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
