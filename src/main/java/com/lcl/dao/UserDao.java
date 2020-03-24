package com.lcl.dao;

import com.lcl.model.*;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lcl
 * @date 2019/10/20 23:03
 * @Description
 */

@Repository
public interface UserDao {
    Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

    //插入用户注册的数据
    boolean insertUserBasic(@Param("user") User user);

    //根据姓名查询数据
    User selectByName(@Param("username") String name);

    //根据邮箱查询数据
    User selectByEmail(@Param("email") String email);

    //根据账号查询用户 username / email /phone
    User selectByAccount(@Param("user") User user);

    //通过其他登录方式查询用户名
    String selectUnameByAccount(@Param("user") User user);


    //用户账号登录
    boolean isLoginOK(@Param("account") String account, @Param("password") String password);

//    根据账号名返回用户名
    String backUsernamebyAccount(@Param("account") String account);
//通过用户名返回用户编号
    long backIdbyAccount(@Param("account") String account);

    //绑定手机号
    boolean updatePhoneNum(@Param("username") String username, @Param("phone") String phone);

    //换头像
    boolean insertPhoto(@Param("userImg") UserImg userImg);
    boolean updatePhoto(@Param("userImg") UserImg userImg);
    //头像是否存在
    UserImg isPhotoExit(@Param("userImg") UserImg userImg);
    //通过用户名修改用户基本信息
     boolean changeUserbasicByname(@Param("user") User user);
    //查询用户选择范围
    List<UserDict> queryUserDict();
    //用户完善详细信息
    boolean userInsertPerfectInfo(@Param("userPerfectInfo")UserPerfectInfo userPerfectInfo);
    //用户修改详细信息
    boolean  userUpdatePerfectInfo(@Param("userPerfectInfo")UserPerfectInfo userPerfectInfo);

    //查询用户是否完善详细信息
    UserPerfectInfo userSelectPerfectInfo(@Param("username") String username);

    //判断用户是否添加过你自我介绍
    boolean isExitIntroduce (@Param("username") String  username);

    //增加用户自我介绍userIntroduce
    boolean addUserIntroduce(@Param("userIntroduce") UserIntroduce userIntroduce);
    //当用户增加过自我介绍后，修改
    boolean changeUserIntroduce(@Param("userIntroduce") UserIntroduce userIntroduce);
    //查询用户的自我介绍
    UserIntroduce querryIntroByUsername(@Param("username") String username);

    //添加生活照
    boolean addLifePicture(@Param("userImg") UserImg userImg);

    //查询是否添加生活照
    boolean isExitLifePicture(@Param("userImg") UserImg userImg);
    //查询生活照
    List<UserImg> queryLifePicture(@Param("userImg") UserImg userImg);



}


/*
public abstract class UserDao  extends SqlSessionDaoSupport {
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }


*/
