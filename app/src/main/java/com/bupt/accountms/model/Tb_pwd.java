package com.bupt.accountms.model;

/**
 * Created by ZhaoJie1234 on 2016/7/30.
 */
public class Tb_pwd {
    private String name;
    private String password;

    public Tb_pwd(String name,String password) {

        super();
        this.name = name;
        this.password = password;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
