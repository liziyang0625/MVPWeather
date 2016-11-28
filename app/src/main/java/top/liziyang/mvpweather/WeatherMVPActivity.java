package top.liziyang.mvpweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import top.liziyang.mvpweather.presenter.WeatherPresenter;
import top.liziyang.mvpweather.view.IWeatherMVPView;

public class WeatherMVPActivity extends AppCompatActivity implements IWeatherMVPView {

    private static final String WEATHER_API = "http://wthrcdn.etouch.cn/WeatherApi?citykey=";
    private static final String GUANGZHOU_CODE = "101280101";

    Button button;
    TextView textView;
    ProgressBar progressBarLoading;

    WeatherPresenter weatherPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.text_weather);
        progressBarLoading = (ProgressBar) findViewById(R.id.progress_loading);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 让Presenter去查询数据，具体的过程View不可见
                weatherPresenter.getWeatherDetail(WEATHER_API + GUANGZHOU_CODE);
            }
        });

        weatherPresenter = new WeatherPresenter(this);
    }

    /**
     * 以下这三个方法明显感觉到View只负责View相关的操作
     */
    @Override
    public void showLoading() {
        progressBarLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoading() {
        progressBarLoading.setVisibility(View.GONE);
    }

    @Override
    public void showWeatherDetail(String weatherDetail) {
        textView.setText(weatherDetail);
    }
}
