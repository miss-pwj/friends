package com.lcl.pojo;

import com.lcl.model.User;
import com.lcl.model.UserImg;
import com.lcl.model.UserIntroduce;
import com.lcl.model.UserPerfectInfo;

import java.util.List;

/**
 * @author lcl
 * @date 2019/11/17 9:47
 * @Description
 */
public class UserInfo {
    private User user;
    private List<UserImg> userImgs;
    private UserPerfectInfo userPerfectInfo;
    private UserIntroduce userIntroduce;
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public UserInfo(User user, List<UserImg> userImgs, UserPerfectInfo userPerfectInfo, UserIntroduce userIntroduce) {
        this.user = user;
        this.userImgs = userImgs;
        this.userPerfectInfo = userPerfectInfo;
        this.userIntroduce = userIntroduce;
    }

    public UserInfo(User user, List<UserImg> userImgs, UserPerfectInfo userPerfectInfo, UserIntroduce userIntroduce, String imgUrl) {
        this.user = user;
        this.userImgs = userImgs;
        this.userPerfectInfo = userPerfectInfo;
        this.userIntroduce = userIntroduce;
        this.imgUrl = imgUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UserImg> getUserImgs() {
        return userImgs;
    }

    public void setUserImgs(List<UserImg> userImgs) {
        this.userImgs = userImgs;
    }

    public UserPerfectInfo getUserPerfectInfo() {
        return userPerfectInfo;
    }

    public void setUserPerfectInfo(UserPerfectInfo userPerfectInfo) {
        this.userPerfectInfo = userPerfectInfo;
    }

    public UserIntroduce getUserIntroduce() {
        return userIntroduce;
    }

    public void setUserIntroduce(UserIntroduce userIntroduce) {
        this.userIntroduce = userIntroduce;
    }

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "user=" + user +
                ", userImgs=" + userImgs +
                ", userPerfectInfo=" + userPerfectInfo +
                ", userIntroduce=" + userIntroduce +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
