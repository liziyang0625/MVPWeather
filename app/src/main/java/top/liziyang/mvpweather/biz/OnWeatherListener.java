package top.liziyang.mvpweather.biz;

/**
 * class description.
 *
 * @author liziyang
 * @version 1.0.0
 * @since 2016/11/27
 */

public interface OnWeatherListener {
    void onSuccess(String weatherDetail);
    void onError();
}
