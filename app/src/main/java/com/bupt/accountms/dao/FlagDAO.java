package com.bupt.accountms.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bupt.accountms.model.Tb_flag;
import com.bupt.accountms.model.Tb_inaccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhaoJie1234 on 2016/7/31.
 */
public class FlagDAO {
    private DBOpenHelper helper;
    private SQLiteDatabase db;
    public FlagDAO(Context context){
        helper = new DBOpenHelper(context);
    }
    public void add(Tb_flag tb_flag){
        db = helper.getWritableDatabase(); //初始化SQLiteDatabas对象
        //执行添加收入信息操作
        db.execSQL("insert into tb_flag (id,flag) values (?,?)",new
                Object[]
                {tb_flag.getId(),tb_flag.getFlag()} );
    }

    public void updata(Tb_flag tb_flag){
        db = helper.getWritableDatabase();
        db.execSQL("updata tb_flag set flag = ?",new Object[]
                {tb_flag.getFlag()});
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
    public List<Tb_flag> getScrollData(int start, int count){
        List<Tb_flag>tb_flag = new ArrayList<Tb_flag>();
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_inaccount limit ?,?",new String[]{String.valueOf(start),String.valueOf(count)});
        while(cursor.moveToNext()){
            tb_flag.add(new Tb_flag(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("flag"))));
        }
        if(cursor != null){
            cursor.close();
        }
        return tb_flag;
    }
}
