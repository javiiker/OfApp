package com.spartakdebruguers.ofapp;

import android.app.Application;
import com.spartakdebruguers.ofapp.utils.ConfigUtils;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public class SpartakApplication extends Application {
    private boolean isShowingMenu;

    public void onCreate() {
        super.onCreate();

        isShowingMenu = false; // At the beginning menu is not showing

        // UNIVERSAL IMAGE LOADER SETUP
        ConfigUtils.configImageLoader(getApplicationContext());
    }

    public boolean isShowingMenu() {
        return isShowingMenu;
    }

    public void setIsShowingMenu(boolean isShowingMenu) {
        this.isShowingMenu = isShowingMenu;
    }
}