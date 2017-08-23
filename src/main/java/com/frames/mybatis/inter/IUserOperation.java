package com.frames.mybatis.inter;

import com.frames.mybatis.models.Article;
import com.frames.mybatis.models.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by jack_ on 2016/5/18.
 */
public interface IUserOperation {
    public User selectUserByID(int id);//请注意，这里面有一个方法名 selectUserByID 必须与 interfaceWay.xml 里面配置的 select 的id 对应（<select id="selectUserByID"）

    public List<User> selectUsers(String userName);
    public int addUser(User user);
    public int addUsers(List<User> users);

    public void updateUser(User user);

    public void deleteUser(int id);


    public List<Article> getUserArticles(int userid);

    public List<User> selectUsers0(@Param("userName")String userName);

    public Map getUserId();
    public String getUserId1();


}
