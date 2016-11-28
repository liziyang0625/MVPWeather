package top.liziyang.mvpweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import top.liziyang.mvpweather.util.HttpCallbackListener;
import top.liziyang.mvpweather.util.HttpUtil;
import top.liziyang.mvpweather.util.WeatherUtil;

public class WeatherNormalActivity extends AppCompatActivity {

    private static final String WEATHER_API = "http://wthrcdn.etouch.cn/WeatherApi?citykey=";
    private static final String GUANGZHOU_CODE = "101280101";

    Button button;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 发起网络请求
                HttpUtil.sendHttpRequest(WEATHER_API + GUANGZHOU_CODE, new HttpCallbackListener() {
                    @Override
                    public void onFinish(String response) {
                        final String weatherDetail = WeatherUtil.handleWeatherXmlResponse(response);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(weatherDetail);
                            }
                        });
                    }

                    @Override
                    public void onError(Exception e) {
                        textView.setText("查询失败");
                    }
                });
            }
        });

        textView = (TextView) findViewById(R.id.text_weather);
    }
}
