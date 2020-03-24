package com.lcl.service;

import com.github.pagehelper.PageInfo;
import com.lcl.pojo.UserInfo;
import com.lcl.pojo.UserShow;

/**
 * @author lcl
 * @date 2019/11/15 17:10
 * @Description
 */

public interface PeopleService {

    //主界面展示所有用户的信息
    PageInfo<UserShow> queryUserShow(int pageNum, int PageSize);

    //根据用户名查询用户信息
    UserInfo queryAllInfobyName(String name) throws Exception;

    //头像是否存在
    boolean isPhotoExit(String name);

    //收藏用户
    boolean changeCollection(String collecter,String collected);

    //查询用户收藏的数量
    int queryCollNum(String name);
}
