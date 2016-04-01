package weathergw.dal;

import java.time.LocalDate;

/**
 * Created by tonym on 01/04/2016.
 */
public class DatesInterval {

       private final LocalDate START, END;

    public DatesInterval(LocalDate start, LocalDate end) {
        START = start;
        END = end;
    }

    public LocalDate getSTART() {
        return START;
    }

    public LocalDate getEND() {
        return END;
    }
}
