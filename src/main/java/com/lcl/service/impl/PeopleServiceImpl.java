package com.lcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcl.dao.PeopleDao;
import com.lcl.dao.UserDao;
import com.lcl.model.User;
import com.lcl.model.UserImg;
import com.lcl.model.UserIntroduce;
import com.lcl.model.UserPerfectInfo;
import com.lcl.pojo.UserInfo;
import com.lcl.pojo.UserShow;
import com.lcl.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lcl
 * @date 2019/11/15 17:11
 * @Description
 */
@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    PeopleDao peopleDao;
 @Autowired
 UserDao userDao;

    @Override
    public PageInfo<UserShow> queryUserShow(int pageNum, int PageSize) {
        System.out.println(peopleDao);
         PageHelper.startPage(pageNum,PageSize);
        List<UserShow> userShows = peopleDao.queryUserShow();
        PageInfo<UserShow> pageInfo = new PageInfo<>(userShows);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Transactional
    @Override
    public UserInfo queryAllInfobyName(String name) throws Exception {

        User user = userDao.selectByName(name);

        List<UserImg> userImgs = peopleDao.queryPictureByName(name,"life");

        UserPerfectInfo userPerfectInfo = userDao.userSelectPerfectInfo(name);
        if (userPerfectInfo == null) {
            userPerfectInfo = new UserPerfectInfo();
        }

        UserIntroduce userIntroduce = userDao.querryIntroByUsername(name);
        if (userIntroduce == null) {
            userIntroduce = new UserIntroduce();
            userIntroduce.setUsername(name);
            userIntroduce.setIntroduce("这个人很懒，什么都没写");
        }

        String imgUrl = peopleDao.queryPhotobyName(name, "photo");


        UserInfo userInfo = new UserInfo(user, userImgs, userPerfectInfo, userIntroduce,imgUrl);
        System.out.println("peopleController"+userInfo);
        return userInfo;
    }

    @Override
    public boolean isPhotoExit(String name) {

        return peopleDao.isPhotoExitbyName(name,"photo");
    }

    @Override
    @Transactional
    public boolean changeCollection(String collecter, String collected) {
        int collNum = peopleDao.queryCollNum(collected);
        System.err.println(collNum);
        if(peopleDao.queryCollRelation(collecter, collected)){//如果已经收藏
            peopleDao.deleteCollRelation(collecter, collected); //取消收藏
            peopleDao.updateCollNum(collected, collNum, false);  //  修改收藏数   true：未收藏  false：已收藏
        return true;    //取消收藏成功
        }else {
            peopleDao.addCollRelation(collecter, collected);    //添加收藏
            peopleDao.updateCollNum(collected, collNum, true);
            return false;   //添加收藏成功
        }

    }

    @Override
    public int queryCollNum(String name) {

        return peopleDao.queryCollNum(name);
    }




    
   /* public static void main(String[] args){
        PeopleServiceImpl p = new PeopleServiceImpl();
        List<UserShow> userShows = p.queryUserShow(1,10);
        for (UserShow userShow:userShows) {
            System.out.println(userShow);
        }
    }*/
}
