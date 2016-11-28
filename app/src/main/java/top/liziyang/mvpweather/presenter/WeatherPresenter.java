package top.liziyang.mvpweather.presenter;


import android.os.Handler;

import top.liziyang.mvpweather.biz.IWeatherBiz;
import top.liziyang.mvpweather.biz.OnWeatherListener;
import top.liziyang.mvpweather.biz.WeatherBiz;
import top.liziyang.mvpweather.view.IWeatherMVPView;

/**
 * class description.
 *
 * @author liziyang
 * @version 1.0.0
 * @since 2016/11/26
 */

public class WeatherPresenter {
    /**
     * Presenter持有View对象，WeatherMVPActivity，因为WeatherMVPActivity是View接口的实现类
     */
    IWeatherMVPView iWeatherMVPView;

    IWeatherBiz iWeatherBiz;

    Handler handler;


    public WeatherPresenter(IWeatherMVPView iWeatherMVPView) {
        this.iWeatherMVPView = iWeatherMVPView;
        iWeatherBiz = new WeatherBiz();
        handler = new Handler();
    }

    /**
     * @param weatherUrl
     */
    public void getWeatherDetail(String weatherUrl) {
        // Presenter控制View的变化
        iWeatherMVPView.showWeatherDetail("");
        iWeatherMVPView.showLoading();

        iWeatherBiz.getWeatherDetail(weatherUrl, new OnWeatherListener() {
            @Override
            public void onSuccess(final String weatherDetail) {
                // 更新UI
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iWeatherMVPView.dismissLoading();
                        iWeatherMVPView.showWeatherDetail(weatherDetail);
                    }
                });
            }

            @Override
            public void onError() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iWeatherMVPView.dismissLoading();
                    }
                });
            }
        });
    }
}
