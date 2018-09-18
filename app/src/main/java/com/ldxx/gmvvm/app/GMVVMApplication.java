package com.ldxx.gmvvm.app;

import android.app.Application;
import android.content.Context;

import com.ldxx.gmvvm.db.DaoManager;
import com.ldxx.gmvvm.db.UserDao;

public class GMVVMApplication extends Application {

    private static GMVVMApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static GMVVMApplication getContext() {
        return mContext;
    }

    public UserDao getUserDao() {
        return DaoManager.getInstance().getSession().getUserDao();
    }

}
