package com.lcl;

import com.lcl.dao.PeopleDao;
import com.lcl.dao.UserDao;
import com.lcl.model.User;
import com.lcl.pojo.UserShow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FriendApplicationTests {
    @Autowired
    UserDao userDao;
    @Autowired
    PeopleDao peopleDao;
    @Test
    void contextLoads() {
//        User user = new User("zs1","1231","1231");

//        userDao.insertUserBasic(user);
        List<UserShow> shows = peopleDao.queryUserShow();
        System.out.println(shows);
    }

}
