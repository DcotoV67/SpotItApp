package com.example.spotitv2;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class AppViewModel extends AndroidViewModel {

    AppDao appDao;
    MutableLiveData<Boolean> usuarioNoDisponible = new MutableLiveData<>();

    public AppViewModel(@NonNull Application application) {
        super(application);

        appDao = AppDatabase.getInstance(application).appDao();
    }

    public void registraUsuario(final String email, final String password, final String username) {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                User user = appDao.comprobarEmailDisponible(email);

                if (user == null){
                    appDao.insertarUsuario(new User(email, password, username));
                }else{
                    usuarioNoDisponible.postValue(true);
                }

            }
        });

    }
}
