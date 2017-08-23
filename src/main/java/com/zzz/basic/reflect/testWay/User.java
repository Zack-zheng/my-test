package com.zzz.basic.reflect.testWay;


public class User extends ParameterBase
{
    String userName ;
    String passWorld;
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getPassWorld()
    {
        return passWorld;
    }
    public void setPassWorld(String passWorld)
    {
        this.passWorld = passWorld;
    }

    public static void main(String[] args)
    {
        User u = new  User();
        u.passWorld = "123";
        u.userName = "aaaaa";
        System.out.println(u.getClassInfo().toString());

    }
}
