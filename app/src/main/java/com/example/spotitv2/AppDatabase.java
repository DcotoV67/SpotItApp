package com.example.spotitv2;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract AppDao appDao();

    static AppDatabase appDatabase;


    public static AppDatabase getInstance(Context context){
        if (appDatabase == null){
            appDatabase = Room
                    .databaseBuilder(context, AppDatabase.class, "app.db")
                    .fallbackToDestructiveMigration()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            addUser();
                        }
                    })
                    .build();
        }
        return appDatabase;
    }

    private static void addUser(){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                appDatabase.appDao().insertarUsuario(new User("admin", "admin", "admin"));

            }
        });

    }
}
