package com.lcl.service.impl;

import com.lcl.dao.UserDao;
import com.lcl.model.*;
import com.lcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lcl
 * @date 2019/10/20 23:05
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public User selectByName(String name) {
        User user = userDao.selectByName(name);
        return user;
    }

    public User selectByEmail(String email) {
        User user = userDao.selectByEmail(email);
        return user;
    }

    //用户登录查询
    public User selectByAccount(User user) {
        User users = null;
        if ((users = userDao.selectByAccount(user)) != null)
            return users;
        System.err.println("当前UserServiceImpl  36行");
        return user;
    }

    @Override
    public boolean isLoginOK(String account, String password) {
        if (userDao.isLoginOK(account, password)) {
            return true;
        }
        return false;
    }

    @Override
    public String backUsernamebyAccount(String account) {
        String username = userDao.backUsernamebyAccount(account);

        return username;
    }

    @Override
    public long backIdbyAccount(String account) {
        long id = userDao.backIdbyAccount(account);
        return id;
    }

    @Override
    public User updatePhoneNum(String username, String phone) {
        User user = null;
        if (userDao.updatePhoneNum(username, phone)) {

            user = userDao.selectByName(username);
        }
        System.err.println("userService:" + user);
        return user;
    }

    //修改用户头像
    @Override
    public boolean changePhoto(UserImg userImg) {
        boolean b = false;
        if (userDao.isPhotoExit(userImg) == null) {
            b = userDao.insertPhoto(userImg);
        } else {
            b = userDao.updatePhoto(userImg);
        }
        return b;
    }

    @Override
    public UserImg isPhotoExit(UserImg userImg) {
        userImg.setType("photo");
        UserImg userImg1 = userDao.isPhotoExit(userImg);
        return userImg1;
    }

    @Override
    public boolean changeUserbasicByname(User user) {
        if (userDao.changeUserbasicByname(user)) {
            return true;
        } else {
            System.err.println("用户修改基本信息失败");
        }
        return false;
    }

    @Override
    public List<UserDict> queryUserDict() {
        List<UserDict> userDicts = null;
        if (userDao.queryUserDict() == null) {
            System.err.println("service：查询数据空");
            try {
                throw new Exception("查询用户选择范围信息失败");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            userDicts = userDao.queryUserDict();
        }
        for (UserDict userDict : userDicts) {
            System.err.println("咋：" + userDict);
        }

        return userDicts;
    }

    @Override
    public boolean userToPerfectInfo(UserPerfectInfo userPerfectInfo) {
        boolean b = false;
        if (userDao.userSelectPerfectInfo(userPerfectInfo.getUsername()) == null) {
            b = userDao.userInsertPerfectInfo(userPerfectInfo);

        } else {
            b = userDao.userUpdatePerfectInfo(userPerfectInfo);
        }
        System.out.println(userPerfectInfo.getBirthday() + "==");
        return b;
    }

    @Override
    public UserPerfectInfo queryPerfectInfo(String username) {

        UserPerfectInfo userPerfectInfo = userDao.userSelectPerfectInfo(username);
        if (userPerfectInfo == null) {
            userPerfectInfo = new UserPerfectInfo();
        }
        System.out.println("详细信息：" + userPerfectInfo.getEducation());
        return userPerfectInfo;
    }

    @Override
    public boolean isExitIntroduce(String username) {
        return userDao.isExitIntroduce(username);
    }

    @Override
    public boolean addUserIntroduce(UserIntroduce userIntroduce) {
        boolean b = false;
        if (!userDao.isExitIntroduce(userIntroduce.getUsername())) {//是否添加过介绍，是-》修改 ，不是-》增加
            b = userDao.addUserIntroduce(userIntroduce);
        } else {
            b = userDao.changeUserIntroduce(userIntroduce);
        }
        return b;
    }

    @Override
    public UserIntroduce querryIntroByUsername(String username)  {
        UserIntroduce userIntroduce = userDao.querryIntroByUsername(username);
        if (userIntroduce == null) {
            return null;
        }
        return userIntroduce;
    }

    @Override
    public boolean addLifePicture(UserImg userImg) {
        userImg.setType("life");
        boolean b = false;
        if(userImg.getImg()==null){
            return false;
        }
        b = userDao.addLifePicture(userImg);
        return b;
    }

    @Override
    public boolean isExitLifePicture(UserImg userImg) {

        return userDao.isExitLifePicture(userImg);
    }

    @Override
    public List<UserImg> queryLifePicture(UserImg userImg) throws Exception {
        userImg.setType("life");
        List<UserImg> list = null;
        if(userDao.isExitLifePicture(userImg)){ //图片存在时
         list = userDao.queryLifePicture(userImg);

      }else {
            throw new Exception("并没有生活图片");
        }
        return list;
    }


    @Override
    public int insertUserBasic(User user) {
        User user1 = null;
        if ((user1=userDao.selectByEmail(user.getEmail())) != null) {
            System.out.println("202"+user1);
            return -2;//表示邮箱已存在
        }
        if (userDao.selectByName(user.getUsername()) != null) {
            System.err.println("test" + userDao.selectByName(user.getUsername()));
            return -1;  //表示用户名已存在
        }

        if (userDao.insertUserBasic(user)) {
            return 1;   //插入数据成功
        }
        return 0;
    }
}
