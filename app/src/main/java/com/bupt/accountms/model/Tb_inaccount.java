package com.bupt.accountms.model;

/**
 * Created by ZhaoJie1234 on 2016/7/30.
 */
public class Tb_inaccount {
    private int id;
    private double money;
    private String time;
    private String type;
    private String handler;
    private String mark;

    public Tb_inaccount() {
        super();
    }
    public Tb_inaccount(int id,double money,String time,String type,String handler,String mark){
        super();
        this.id=id;
        this.money = money;
        this.time = time;
        this.type = type;
        this.handler = handler;
        this.mark = mark;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
