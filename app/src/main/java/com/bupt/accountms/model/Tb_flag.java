package com.bupt.accountms.model;

/**
 * Created by ZhaoJie1234 on 2016/7/30.
 */
public class Tb_flag {
    private int id;
    private String flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Tb_flag(int id,String flag){
        super();
        this.id = id;
        this.flag = flag;
    }
}
