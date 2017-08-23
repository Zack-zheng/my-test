package com.frames.mybatis.test;


import com.frames.mybatis.inter.IUserOperation;
import com.frames.mybatis.models.Article;
import com.frames.mybatis.models.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;
import java.util.Map;

/**
 * Created by jack_ on 2016/5/18.
 */
public class CRUDMethod {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;


    static{
        try{
            reader    = Resources.getResourceAsReader("com/frames/mybatis/Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }



    public void selectByIdInterfaceWay(int id){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            User user = userOperation.selectUserByID(id);
            System.out.println(user.getUserAddress());
            System.out.println(user.getUserName());
        } finally {
            session.close();
        }
    }
    public void selectByIdNamespaceWay(int id){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = (User) session.selectOne("com.frames.mybatis.inter.UserMapper.selectUserByID", id);
            System.out.println(user.getUserAddress());
            System.out.println(user.getUserName());
        } finally {
            session.close();
        }
    }
    public void getUserList(String userName){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            List<User> users = userOperation.selectUsers(userName);
            for(User user:users){
                System.out.println(user.getId()+":"+user.getUserName()+":"+user.getUserAddress());
            }

        } finally {
            session.close();
        }
    }
    public void getUserList0(String userName){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            List<User> users = userOperation.selectUsers0(userName);
            for(User user:users){
                System.out.println(user.getId()+":"+user.getUserName()+":"+user.getUserAddress());
            }

        } finally {
            session.close();
        }
    }
    /**
     * 测试增加,增加后，必须提交事务，否则不会写入到数据库.
     */
    public void addUser(User user){

        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            int i = userOperation.addUser(user);
            System.out.println(i);
            session.commit();
            System.out.println("当前增加的用户 id为:"+user.getId());
        } finally {
            session.close();
        }
    }

    public void updateUser(int id, String address){
        //先得到用户,然后修改，提交。
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            User user = userOperation.selectUserByID(id);
            user.setUserAddress(address);
            userOperation.updateUser(user);
            session.commit();

        } finally {
            session.close();
        }
    }

    /**
     * 删除数据，删除一定要 commit.
     * @param id
     */
    public void deleteUser(int id){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            userOperation.deleteUser(id);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void getUserArticles(int userid){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            List<Article> articles = userOperation.getUserArticles(userid);
            for(Article article:articles){
                System.out.println(article.getTitle()+":"+article.getContent()+
                        ":作者是:"+article.getUser().getUserName()+":地址:"+
                        article.getUser().getUserAddress());
            }
        } finally {
            session.close();
        }
    }

    public void getUserId(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            Map map = userOperation.getUserId();
            System.out.println(map+" " + map.get("id"));

        } finally {
            session.close();
        }
    }
    public void getUserId1(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            String a = userOperation.getUserId1();
            System.out.println(a);

        } finally {
            session.close();
        }
    }

    public void insertUsers(List<User> list){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            int a = userOperation.addUsers(list);
            System.out.println(a);

        } finally {
            session.close();
        }
    }

}