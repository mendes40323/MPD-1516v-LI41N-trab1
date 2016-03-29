package weathergw.common;

import weathergw.domain.WeatherInfo;

/**
 * Created by lfalcao on 18/03/16.
 */
public interface Predicate<T> {
    boolean evaluate(T wi);
}

