package top.liziyang.mvpweather.util;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

/**
 * Created by stefan on 15/5/29.
 */
public class WeatherUtil {

    public static String handleWeatherXmlResponse(String response) {
//        String updateTime = "";
        String currentTemperature = "";
        String fengli = "";
        String fengxiang = "";
        String shidu = "";
        String sunrise = "";
        String sunset = "";

        try {
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
            xmlPullParser.setInput(new StringReader(response));
            int eventType = xmlPullParser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        switch (nodeName) {
                            case "city":
//                                cityName = xmlPullParser.nextText();
                                break;
                            case "updatetime":
//                                updateTime = xmlPullParser.nextText();
                                break;
                            case "wendu":
                                currentTemperature = xmlPullParser.nextText();
                                break;
                            case "fengli":
                                fengli = xmlPullParser.nextText();
                                break;
                            case "shidu":
                                shidu = xmlPullParser.nextText();
                                break;
                            case "fengxiang":
                                fengxiang = xmlPullParser.nextText();
                                break;
                            case "sunrise_1":
                                sunrise = xmlPullParser.nextText();
                                break;
                            case "sunset_1":
                                sunset = xmlPullParser.nextText();
                                break;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                eventType = xmlPullParser.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "当前气温：" + currentTemperature + "℃\n"
                + "湿度：" + shidu + "\n"
                + fengxiang + fengli + "\n"
                + "日出：" + sunrise + "\n"
                + "日落：" + sunset;
//        saveWeatherInfo(context, cityName, cityId, updateTime, currentTemperature, fengli, fengxiang, shidu, sunrise, sunset);
    }

//    public static void saveWeatherInfo(Context context, String cityName, String cityId, String updateTime, String currentTemperature, String fengli, String fengxiang, String shidu, String sunrise, String sunset) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年M月d日", Locale.CHINA);
//
//        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
//        editor.putBoolean("city_selected", true);
//        editor.putString("city_name", cityName);
//        editor.putString("city_id", cityId);
//        editor.putString("current_temperature", currentTemperature);
//        editor.putString("update_time", updateTime);
//        editor.putString("feng_li", fengli);
//        editor.putString("feng_xiang", fengxiang);
//        editor.putString("shi_du", shidu);
//        editor.putString("sun_rise", sunrise);
//        editor.putString("sun_set", sunset);
//        editor.putString("current_date", simpleDateFormat.format(new Date()));
//        editor.commit();
//    }
}
