package com.lcl.controller.peopleHandler;

import com.lcl.model.User;
import com.lcl.model.UserIntroduce;
import com.lcl.pojo.UserInfo;
import com.lcl.service.PeopleService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author lcl
 * @date 2019/11/17 8:46
 * @Description
 */
@SessionAttributes(value = {"path","ouser"})
@Controller
@RequestMapping("/userController")
public class PeopleController {
    @Autowired
    PeopleService peopleService;

    @RequestMapping("/queryOthers")
    public String queryOthers(@RequestParam("username")String username, ModelMap modelMap) throws Exception {
        UserInfo userInfo = peopleService.queryAllInfobyName(username);
        String url = userInfo.getImgUrl();
        String path = "/user/userImg/" + username + "/";
        if(peopleService.isPhotoExit(username)){
            modelMap.addAttribute("imgurl", path + url);
        }else{
            modelMap.addAttribute("imgurl", "/img/me.jpg");
        }

        modelMap.addAttribute("ouser", userInfo.getUser());
        modelMap.addAttribute("userImgs",userInfo.getUserImgs());

        modelMap.addAttribute("userIntroduce",userInfo.getUserIntroduce());

        modelMap.addAttribute("path", path);
        modelMap.addAttribute("userPerfectInfo", userInfo.getUserPerfectInfo());


        return "people/userInfo";
    }

    @RequestMapping("changeCollection")
    @ResponseBody
    public int changeConnection(@RequestParam("collecter") String collecter,@RequestParam("collected") String collected,
                                   @SessionAttribute("ouser")User user, ModelMap modelMap) {

       /* String collecter = (String) params.get("collecter");
        String collected = (String) params.get("collected");*/
        System.err.println("==========================================");
        boolean flag = peopleService.changeCollection(collecter, collected);

        String coll = "收藏";
        if (!flag) {//收藏成功
            coll="取消收藏";
        }
        int collNum = peopleService.queryCollNum(collected);
        System.out.println("收藏数"+collNum);
        System.out.println("ouser"+user);
        user.setCollection(collNum);
        modelMap.addAttribute("coll", coll);
        modelMap.addAttribute("ouser", user);
        

        return collNum;
    }
    /*@RequestMapping("changeCollection")
    @ResponseBody
    public int changeConnection(@RequestParam("collecter") String collecter,@RequestParam("collected") String collected,
                                   @SessionAttribute("ouser")User user, ModelMap modelMap) {

        boolean flag = peopleService.changeCollection(collecter, collected);

        String coll = "收藏";
        if (!flag) {//收藏成功
            coll="取消收藏";
        }
        int collNum = peopleService.queryCollNum(collected);
        System.out.println("收藏数"+collNum);
        System.out.println("ouser"+user);
        user.setCollection(collNum);
        modelMap.addAttribute("coll", coll);
        modelMap.addAttribute("ouser", user);

        System.err.println("==========================================");
        return collNum;
    }*/

}
