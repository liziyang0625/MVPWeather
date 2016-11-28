package top.liziyang.mvpweather.biz;

/**
 * class description.
 *
 * @author liziyang
 * @version 1.0.0
 * @since 2016/11/26
 */

public interface IWeatherBiz {
    void getWeatherDetail(String weatherUrl, OnWeatherListener onWeatherListener);
}
