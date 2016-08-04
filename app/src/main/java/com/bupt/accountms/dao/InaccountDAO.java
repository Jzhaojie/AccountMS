package com.bupt.accountms.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bupt.accountms.model.Tb_inaccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhaoJie1234 on 2016/7/30.
 */
public class InaccountDAO {
    private DBOpenHelper helper;
    private SQLiteDatabase db;
    public InaccountDAO(Context context){
        helper = new DBOpenHelper(context);
    }
    /*
    *添加收入信息
    *
    */
    public void add(Tb_inaccount tb_inaccount){
        db = helper.getWritableDatabase(); //初始化SQLiteDatabas对象
        //执行添加收入信息操作
        db.execSQL("insert into tb_inaccount (id,money,time,type,handler,mark) values (?,?,?,?,?,?)",new
        Object[]
                {tb_inaccount.getId(),tb_inaccount.getMoney(),tb_inaccount.getTime(),tb_inaccount.getType(),
                tb_inaccount.getHandler(),tb_inaccount.getMark()} );
    }

    public void updata(Tb_inaccount tb_inaccount){
        db = helper.getWritableDatabase();
        db.execSQL("updata tb_inaccount set money = ?,time = ?,type = ?,handler = ?,mark = ? where id = ？",new Object[]
                {tb_inaccount.getMoney(),tb_inaccount.getTime(),tb_inaccount.getType(),tb_inaccount.getHandler(),tb_inaccount.getMark(),tb_inaccount.getId()});
    }
    public Tb_inaccount find(int id){
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select id,money,time,type,handler,mark from tb_inaccount where id = ?",
                new String[]
                        {String.valueOf(id)});
                         if(cursor.moveToNext()){
                             return new Tb_inaccount(cursor.getInt(cursor.getColumnIndex("id")),
                                     cursor.getDouble(cursor.getColumnIndex("money")),
                                     cursor.getString(cursor.getColumnIndex("time")),
                                     cursor.getString(cursor.getColumnIndex("type")),
                                     cursor.getString(cursor.getColumnIndex("handler")),
                                     cursor.getString(cursor.getColumnIndex("mark")));
                         }
        if(cursor != null){
            cursor.close();
        }
        return null;
    }
    public void delete(Integer... ids){
        if(ids.length > 0){
            StringBuffer sb = new StringBuffer();
            for(int i = 0;i < ids.length; i++){
                sb.append("?").append(",");               //方法很好，值得记下来
            }
            sb.deleteCharAt(sb.length()-1);
            db = helper.getWritableDatabase();
            db.execSQL("delete from tb_inaccount where id in(" + sb +")",(Object[])ids);   //这种写法，为什么要用StringBuffer,下面String也行
        }
    }
    public List<Tb_inaccount> getScrollData(int start,int count){
        List<Tb_inaccount>tb_inaccount = new ArrayList<Tb_inaccount>();
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_inaccount limit ?,?",new String[]{String.valueOf(start),String.valueOf(count)});
        while(cursor.moveToNext()){
            tb_inaccount.add(new Tb_inaccount(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getDouble(cursor.getColumnIndex("money")),
                    cursor.getString(cursor.getColumnIndex("time")),
                    cursor.getString(cursor.getColumnIndex("type")),
                    cursor.getString(cursor.getColumnIndex("handler")),
                    cursor.getString(cursor.getColumnIndex("mark"))));
        }
        if(cursor != null){
            cursor.close();
        }
        return tb_inaccount;
    }
    public long getCount(){
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select count(id) from tb_inaccount",null);
        if(cursor.moveToNext()){
            return cursor.getLong(0);       //返回总记录数
        }
        if(cursor != null){
            cursor.close();
        }
        return 0;
    }
    public int getMaxId(){
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select max(id) from tb_inaccount",null);
        while(cursor.moveToNext()){
            return cursor.getInt(0);
        }
        if(cursor != null){
            cursor.close();
        }
        return 0;
    }


}
