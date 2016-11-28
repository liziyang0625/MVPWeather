package top.liziyang.mvpweather.biz;

import top.liziyang.mvpweather.util.HttpCallbackListener;
import top.liziyang.mvpweather.util.HttpUtil;
import top.liziyang.mvpweather.util.WeatherUtil;

/**
 * class description.
 *
 * @author liziyang
 * @version 1.0.0
 * @since 2016/11/27
 */

public class WeatherBiz implements IWeatherBiz {
    @Override
    public void getWeatherDetail(String weatherUrl, final OnWeatherListener onWeatherListener) {
        HttpUtil.sendHttpRequest(weatherUrl, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                String weatherDetail = WeatherUtil.handleWeatherXmlResponse(response);
                onWeatherListener.onSuccess(weatherDetail);
            }

            @Override
            public void onError(Exception e) {
                onWeatherListener.onError();
            }
        });
    }
}
