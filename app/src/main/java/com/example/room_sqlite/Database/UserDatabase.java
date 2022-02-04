package com.example.room_sqlite.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.room_sqlite.Model.User;
import com.example.room_sqlite.dao.UserDao;

@Database(entities = User.class,exportSchema = false,version = 3)
public abstract class   UserDatabase extends RoomDatabase {

        public static UserDatabase userDatabase;
//         static Migration migration=new Migration(1,2) {
//            @Override
//            public void migrate(@NonNull SupportSQLiteDatabase database) {
//             database.execSQL("ALTER TABLE userD " +"ADD COLUMN address String");
//            }
//        };

        public static UserDatabase getInstance(Context context){
            if(userDatabase==null){
                userDatabase= Room.databaseBuilder(context, UserDatabase.class, "DataBas").fallbackToDestructiveMigration()
                        .build();
            }
            return userDatabase;
        }

        public abstract UserDao userDao();
}
