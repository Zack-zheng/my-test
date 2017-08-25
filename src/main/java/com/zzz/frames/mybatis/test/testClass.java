package com.zzz.frames.mybatis.test;

import com.zzz.frames.mybatis.models.User;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jack_ on 2016/5/19.
 */
public class testClass {
    CRUDMethod crudMethod = new CRUDMethod();
    @Test
    public void testSelectByIdInterfaceWay(){

        crudMethod.selectByIdInterfaceWay(1);
    }

    @Test
    public void testSelectByIdNamespaceWay(){
        crudMethod.selectByIdNamespaceWay(1);
    }
    @Test
    public void testSelectByCondition(){
        crudMethod.getUserList("%");
    }
    @Test
    public void testInsert(){
        User user=new User();
        user.setUserAddress("人民广场");
        user.setUserName("飞鸟");
        user.setUserAge("80");
        crudMethod.addUser(user);
    }
    @Test
    public void testInsertUsers(){
        List<User> users = new LinkedList<User>();
        for (int i=0; i<5;i++){
            User user=new User();
            user.setUserAddress("人民广场");
            user.setUserName("飞鸟");
            user.setUserAge(Integer.toBinaryString(i));
            users.add(user);
        }

        crudMethod.insertUsers(users);

    }
    @Test
    public void testUpdate(){

        crudMethod.updateUser(1, "中山精神病院");
    }

    @Test
    public void testDelete(){
        crudMethod.deleteUser(4);
    }

    @Test
    public void testGetUserArticles(){
        crudMethod.getUserArticles(1);
    }


    @Test
    public void testGetUserId(){
        crudMethod.getUserId();
    }
    @Test
    public void testGetUserId1(){
        crudMethod.getUserId1();
    }


}
