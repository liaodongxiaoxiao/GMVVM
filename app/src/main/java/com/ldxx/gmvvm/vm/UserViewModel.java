package com.ldxx.gmvvm.vm;

import android.arch.lifecycle.ViewModel;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ldxx.gmvvm.BR;
import com.ldxx.gmvvm.app.GMVVMApplication;
import com.ldxx.gmvvm.bean.User;
import com.ldxx.gmvvm.db.UserDao;

import java.util.UUID;

public class UserViewModel extends BaseObservable {
    //private MediatorLiveData<String> userCountLiveData = new MediatorLiveData<>();

    private String count;

    private UserDao dao;

    public UserViewModel() {
        dao = GMVVMApplication.getContext().getUserDao();
        this.count = getUserCount();
        notifyPropertyChanged(BR.count);
    }

    @Bindable
    public String getCount() {
        return count;
    }

    public void insertUser(String name,String age){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(name);
        user.setAge(age);

        dao.insert(user);

        this.count = getUserCount();
        notifyPropertyChanged(BR.count);
    }

    private String getUserCount(){
        return dao.queryBuilder().build().list().size()+"";
    }
}
