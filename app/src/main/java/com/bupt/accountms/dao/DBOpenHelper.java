package com.bupt.accountms.dao;

import android.content.Context;
import android.database.ContentObservable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ZhaoJie1234 on 2016/7/30.
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    private static final int VERSION =1;                   //定义数据库的版本号
    private static final String DBNAME = "account.db";     //定义数据库名
    /*
    * 第一数据库sql语句
    */
    private static final String CREATE_OUTACCOUNT ="create table tb_outaccount" +
            "（id integer primary key,money decimal,time varchar(10),"+
            "type varchar(10),address varchar(100),mark varchar(200))";
    private static final String CREATE_INACCOUNT = "create table tb_inaccount" +
            "(id integer primary key,money decimal,time varchar(10)," +
            "type varchar(10),handler varchar(100),mark varchar200))";
    private static final String CREATE_PWD = "create table tb_pwd(name varchar(20),password varchar(20))";

    private static final String CREATE_FLAG = "create table tb_flag(id integer primary key,flag varchar(200))";


    public DBOpenHelper(Context context){
        super(context,DBNAME,null,VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
/*
* 创建数据库表
*/
        db.execSQL(CREATE_OUTACCOUNT);
        db.execSQL(CREATE_INACCOUNT);
        db.execSQL(CREATE_FLAG);
        db.execSQL(CREATE_PWD);
    }

    @Override
    //覆写基类的onUpgrade 方法，一以便数据库的更新
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
