package com.lcl.dao;

import com.lcl.model.UserImg;
import com.lcl.pojo.UserShow;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lcl
 * @date 2019/11/15 16:54
 * @Description
 */

@Repository
public interface PeopleDao {
    Logger LOGGER = LoggerFactory.getLogger(PeopleDao.class);

    //   查询用户需要展示在主界面的信息
    List<UserShow> queryUserShow();

    //根据用户名查询所有图片
    List<UserImg> queryPictureByName(@Param("username") String username, @Param("type") String type);

    //根据用户名称查询头像是否存在
    boolean isPhotoExitbyName(@Param("username") String username, @Param("type") String type);

    //根据用户名查询头像
    String queryPhotobyName(@Param("username") String username, @Param("type") String type);

    //查询收藏关系
    boolean queryCollRelation(@Param("collecter") String collecter, @Param("collected") String collected);

    //删除收藏关系
    boolean deleteCollRelation(@Param("collecter") String collecter, @Param("collected") String collected);

    //增加收藏关系
    boolean addCollRelation(@Param("collecter") String collecter, @Param("collected") String collected);

    //查询用户收藏数量
    int queryCollNum(@Param("username") String username);

    //修改收藏数量
    boolean updateCollNum(@Param("username") String username,@Param("collection")int collection, @Param("change") boolean change);


}
