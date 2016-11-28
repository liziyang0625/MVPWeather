package top.liziyang.mvpweather.view;

/**
 * MVP中的View，View的操作抽象成接口，实现类是实际的Activity
 * View的操作有：
 *   1. 显示Loading
 *   2. 隐藏Loading
 *   3. 显示Weather详情
 *
 * @author liziyang
 * @version 1.0.0
 * @since 2016/11/26
 */
public interface IWeatherMVPView {
    void showLoading();
    void dismissLoading();
    void showWeatherDetail(String weatherDetail);
}
