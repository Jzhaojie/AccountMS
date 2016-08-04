package com.bupt.accountms.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bupt.accountms.model.Tb_pwd;

/**
 * Created by ZhaoJie1234 on 2016/7/31.
 */
public class PwdDAO {
    private DBOpenHelper helper;
    private SQLiteDatabase db;
    public PwdDAO(Context context){
        helper = new DBOpenHelper(context);
    }
    public void register(Tb_pwd tb_pwd){
        db = helper.getWritableDatabase(); //初始化SQLiteDatabas对象
        db.execSQL("insert into tb_pwd(name,password) values(?,?)",new Object[]{
                tb_pwd.getName(),tb_pwd.getPassword()
        });
    }
    public long getCount(Tb_pwd tb_pwd){
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select* from tb_pwd where name = ? and password = ?",new String[]{tb_pwd.getName(),tb_pwd.getPassword()});
        if(cursor.moveToNext()){
            return cursor.getLong(0);

        }

    }
}
