package com.h.goodweather.ui;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import com.h.goodweather.R;
import com.h.goodweather.databinding.ActivityAboutUsBinding;
import com.h.goodweather.utils.StatusBarUtil;
import com.h.goodweather.utils.ToastUtils;
import com.h.mvplibrary.base.vb.BaseVBActivity;
import com.h.mvplibrary.bean.AppVersion;
import com.h.mvplibrary.utils.SizeUtils;
import com.h.mvplibrary.view.dialog.AlertDialog;
import org.litepal.LitePal;
import java.io.File;

/**
 * 关于 Good Weather
 *
 * @author h
 */
public class AboutUsActivity extends BaseVBActivity<ActivityAboutUsBinding> {
    @Override
    public void initData() {
        Back(binding.toolbar);
        //蓝色状态栏
        StatusBarUtil.setStatusBarColor(context, R.color.about_bg_color);

        AppVersion appVersion = LitePal.find(AppVersion.class, 1);
    }
    @SuppressLint("NonConstantResourceId")

    /**
     * 清除APK
     */
    public static File clearApk(String apkName) {
        File apkFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), apkName);
        if (apkFile.exists()) {
            apkFile.delete();
        }
        return apkFile;
    }

    /**
     * 下载APK
     */
    private void downloadApk(String downloadUrl) {
        clearApk("GoodWeather.apk");
        //下载管理器 获取系统下载服务
        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
        //设置运行使用的网络类型，移动网络或者Wifi都可以
        request.setAllowedNetworkTypes(request.NETWORK_MOBILE | request.NETWORK_WIFI);
        //设置是否允许漫游
        request.setAllowedOverRoaming(true);
        //设置文件类型
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        String mimeString = mimeTypeMap.getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(downloadUrl));
        request.setMimeType(mimeString);
        //设置下载时或者下载完成时，通知栏是否显示
        request.setNotificationVisibility(request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setTitle("下载新版本");
        request.setVisibleInDownloadsUi(true);//下载UI
        //sdcard目录下的download文件夹
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "GoodWeather.apk");
        //将下载请求放入队列
        downloadManager.enqueue(request);
    }
}
