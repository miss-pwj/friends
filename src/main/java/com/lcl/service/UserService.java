package com.lcl.service;

import com.lcl.model.*;

import java.util.List;

/**
 * @author lcl
 * @date 2019/10/20 23:05
 * @Description
 */
public interface UserService {
    //查询用户名是否已存在
    public User selectByName(String name);
    //插入用户基本信息
    public int insertUserBasic(User user);

    //查询邮箱是否注册
    public User selectByEmail(String email);

    //查询用户名 邮箱 手机号  username email phone
    public User selectByAccount(User user);


    //判断用户登录
    public boolean isLoginOK(String account,String password);
    //通过账号查询用户名
    public String backUsernamebyAccount(String account);

    //通过账号查询用户编号
    public long backIdbyAccount(String account);

    //绑定手机号并返回用户信息
    public User updatePhoneNum(String username, String phone);

    //修改用户头像
    public boolean changePhoto(UserImg userImg);

    //用户是否上传过用户头像
    public UserImg isPhotoExit(UserImg userImg);
    //根据用户名修改用户基本信息
    public boolean changeUserbasicByname(User user);
    //查询用户选择范围
    List<UserDict> queryUserDict();

    //用户完善信息
    boolean userToPerfectInfo(UserPerfectInfo userPerfectInfo);

    //用户查看详细信息
    UserPerfectInfo queryPerfectInfo(String username);

    //用户是否添加过介绍
    boolean isExitIntroduce(String username);
    //用户自我介绍
    boolean addUserIntroduce(UserIntroduce userIntroduce);

    //查询用户的介绍
    UserIntroduce querryIntroByUsername(String username) ;
    //插入用户生活照
    boolean addLifePicture(UserImg userImg);
    //查询用户生活照是否存在
    boolean isExitLifePicture(UserImg userImg);
    //查询用户生活照
    List<UserImg> queryLifePicture(UserImg userImg) throws Exception;

}
