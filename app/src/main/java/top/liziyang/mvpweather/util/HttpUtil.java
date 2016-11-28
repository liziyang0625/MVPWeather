package top.liziyang.mvpweather.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by stefan on 15/5/29.
 * 用来请求天气
 */
public class HttpUtil {
    public static void sendHttpRequest(final String httpAddress, final HttpCallbackListener httpCallbackListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    connection = (HttpURLConnection) (new URL(httpAddress)).openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }

                    // 回调
                    if (httpCallbackListener != null) {
                        httpCallbackListener.onFinish(stringBuilder.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    // 回调
                    httpCallbackListener.onError(e);
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }

            }
        }).start();
    }
}
