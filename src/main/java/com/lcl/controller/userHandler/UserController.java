package com.lcl.controller.userHandler;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lcl.converter.NumberFormatUtil;
import com.lcl.model.*;
import com.lcl.pojo.UserShow;
import com.lcl.service.PeopleService;
import com.lcl.service.UserService;
import com.lcl.util.PathUtil;
import com.lcl.util.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

/**
 * @author lcl
 * @date 2019/10/22 19:59
 * @Description
 */

@SessionAttributes(value = {"photourl", "user", "username","userId","path","pageInfo"})
@Controller
@RequestMapping("/userController")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PeopleService peopleService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    UserImg userImg;

    @RequestMapping("/welc")
    @ResponseBody
    public String welcome() {
        return "wozaizheli";
    }

    //进入注册页面
    @RequestMapping("/toRegister")
    public String toRegister() {

        return "people/register";
    }

    @RequestMapping("/toLogin")//进入登录页面
    public String toLogin() {

        return "people/login";
    }

    @RequestMapping("/toMain")//进入主界面
    public String toMain( @ModelAttribute("pageInfo") PageInfo pageInfo) {

        return "people/main";
    }


    /*@ModelAttribute("pageInfo")
    public PageInfo<UserShow> AllUser(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                      ModelMap modelMap) {
       
       System.out.println("当前页码："+pageNum);
        String moren="/img/me.jpg";
System.out.println("================================================");
        PageInfo<UserShow> pageInfo =  peopleService.queryUserShow(pageNum,pageSize);

        for (UserShow userShow : pageInfo.getList()) {
            String name  =userShow.getUsername();
            String imgurl = "/user/userImg/" + name + "/";
            if(userShow.getImg()==null){
                userShow.setImg(moren);
            }else{
                String img = userShow.getImg();
                userShow.setImg(imgurl+img);
            }
        }
        //modelAndView.setViewName("/people/main");
       *//* modelMap.addAttribute("pageInfo", pageInfo);
        //获得当前页
        modelMap.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        modelMap.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        modelMap.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        modelMap.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        modelMap.addAttribute("isLastPage", pageInfo.isIsLastPage());*//*
        return pageInfo;
    }*/

    @RequestMapping("/toUpload")//进入上传头像
    public String toUpload() {
        return "user/upload";
    }

    @RequestMapping("toPerfectInfo")
    public String toPerfectInfo(ModelMap modelMap) {
        String username = (String) modelMap.getAttribute("username");
        List<UserDict> userDicts = userService.queryUserDict();

        UserPerfectInfo userPerfectInfo = userService.queryPerfectInfo(username);
        modelMap.addAttribute("userDicts", userDicts);
        modelMap.addAttribute("userPerfectInfo", userPerfectInfo);

        return "user/perfectInfo";
    }

/*
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
*/

    //用户注册
    @RequestMapping("/userRegister")
    public String userRegister(User user, ModelMap modelMap) {
        System.err.println(user);
        //如果两次密码不同
        if (!user.getPassword().equals(user.getConfpassword())) {
            modelMap.addAttribute("double", "原密码与确认密码不同");

            return "people/register";
        }
        //如果查询到该用户名
        if (userService.insertUserBasic(user) == -1) {
            modelMap.addAttribute("nickname", "该用户名已存在");

            return "people/register";
        }
        //如果查询到该邮箱
        if (userService.insertUserBasic(user) == -2) {
            modelMap.addAttribute("email", "注册成功，请登录");

            return "people/register";
        }

        if (userService.insertUserBasic(user) == 1) {
//            userService.changePhoto(userImg);

            return "people/main";
        }

        return "error";
    }

    //用户登录
    @RequestMapping("/userLogin")
    public String userLogin(@RequestParam("account") String account,
                            @RequestParam("password") String password,
                            ModelMap modelMap) {
        if (userService.isLoginOK(account, password)) {
            long id = userService.backIdbyAccount(account);
            String username = userService.backUsernamebyAccount(account);//根据账号查询用户名
            User user = userService.selectByName(username); //根据用户名查找用户所有信息
            modelMap.addAttribute("user", user);
//            System.out.println("用户名" + user.getUsername() + "," + "密码" + user.getPassword());
            userImg.setUsername(username);
            modelMap.addAttribute("username", username);
            modelMap.addAttribute("userId", id);
            UserImg userImg1 = userService.isPhotoExit(userImg);
            System.out.println("userImg1"+userImg1);
            if (userImg1 == null) {
                modelMap.addAttribute("photourl", "/img/me.jpg");
            } else {
                String photourl = "/user/userImg/" + username + "/";
                //modelMap.addAttribute("photourl", photourl+userImg1.getImg());

                modelMap.addAttribute("photourl", photourl + userImg1.getImg());
                System.err.println("头像图片路径：" + photourl + userImg1.getImg());

            }
            System.err.println("刀面"+modelMap.getAttribute("pageInfo"));

            return "people/main";
        } else {
            modelMap.addAttribute("result", "登录失败");
            return "people/login";
        }
    }

    @RequestMapping("toUserInfo")
    public String toUserInfo(ModelMap modelMap) {
        HttpSession session = request.getSession();
        User user2 = (User) session.getAttribute("user");
        String username = user2.getUsername();
        User user = userService.selectByName(username);
        modelMap.addAttribute("muser", user);
        return "user/userInfo";
    }

    @RequestMapping("addPhoneNum")//绑定手机号
    public String addPhoneNum(@RequestParam("phone") String phone, ModelMap modelMap) {
        HttpSession session = request.getSession();

        User user2 = (User) session.getAttribute("user");
        String username = user2.getUsername();
        User user = userService.updatePhoneNum(username, phone);
        //  session.setAttribute("user",user);
        System.err.println("电话:" + user.getPhone());
        if (user.getPhone() == null || user.getPhone().equals("")) {
            modelMap.addAttribute("result", "手机绑定失败");
        } else {
            modelMap.addAttribute("muser", user);
        }
        return "user/userInfo";
    }

    @RequestMapping("/uploadPhoto")//上传头像
    public String uploadPhoto(@RequestParam("file") MultipartFile file, ModelMap modelMap) throws IOException {
        //判断文件是否为空
        if (file.isEmpty()) {
            modelMap.addAttribute("upload?", "上传失败");
            return "user/upload";
        }

        User user = (User) request.getSession().getAttribute("user");
        //文件名
        String fileName = Upload.makeFileName(file.getOriginalFilename());
       /* //获取项目路径
        String path=request.getServletPath();
        //设置文件路径
        String filePath2 = path+"userResource/userImg/"+user.getUsername()+"/"+fileName;*/
        //获取图片存储路径
        String filePath = PathUtil.getImgUrl() + user.getUsername() + "/";

        System.out.println("上传头像："+filePath);
        InputStream input = file.getInputStream();

        //当文件夹不存在时，创建文件夹
        File file1 = PathUtil.creatFile(filePath, fileName);//设置图片存储路径

        OutputStream out = new FileOutputStream(file1);

        byte[] bytes = new byte[1024];    //缓冲区
        int len = -1;
        while ((len = input.read(bytes)) != -1)
            out.write(bytes, 0, len);
        out.close();
        input.close();

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        userImg.setUsername(user.getUsername());
        userImg.setType("photo");
        userImg.setImg(fileName);
        //将头像路径存储到数据库
        if (userService.changePhoto(userImg)) {
            System.out.println("插入成功");
        }

        modelMap.addAttribute("upload?", "上传成功");
        modelMap.addAttribute("filePath", filePath);
        String photourl = "/user/userImg/" + user.getUsername() + "/";
        HttpSession session = request.getSession();
        UserImg userImg1 = userService.isPhotoExit(userImg);

        modelMap.addAttribute("photourl", photourl + userImg1.getImg());
        System.err.println(photourl + fileName);

        return "people/main";

    }

    //修改用户基本信息
    @RequestMapping("/changeUserbasicByname")
    public String changeUserbasicByname(User user, ModelMap modelMap) {
        System.err.println("这里" + user);
        if (userService.changeUserbasicByname(user)) {
            User user1 = userService.selectByName(user.getUsername());
            modelMap.addAttribute("change", "信息修改成功");
            modelMap.addAttribute("muser", user1);

        } else {
            modelMap.addAttribute("change", "信息修改失败");

        }

        return "user/userInfo";
    }

    //类型转换器
    @InitBinder("/userPerfectInfo")
    protected void initBinder(WebDataBinder binder) throws Exception {

        NumberFormatUtil.registerFloatFormat(binder);

    }

    //完善用户信息
    @RequestMapping("/userPerfectInfo")
    public String userPerfectInfo(UserPerfectInfo userPerfectInfo, ModelMap modelMap) throws Exception {
        User user = (User) modelMap.getAttribute("user");
        String username = user.getUsername();
        userPerfectInfo.setUsername(username);
        if (userService.userToPerfectInfo(userPerfectInfo)) {
            modelMap.addAttribute("userPerfectInfo", userPerfectInfo);
        } else {
            System.out.println("Controller:userPerfectInfo失败了");
        }
        System.err.println("Controller获取birthday" + userPerfectInfo.getBirthday());
        UserPerfectInfo userPerfectInfo2 = userService.queryPerfectInfo(username);
        modelMap.addAttribute("userPerfectInfo", userPerfectInfo2);

        return "user/showMoreInfo";
    }

    //显示用户详细信息
    @RequestMapping("/toShowMoreInfo")
    public String toShowMoreInfo(ModelMap modelMap) {
        String username = (String) modelMap.getAttribute("username");
        System.out.println("UserController:toShowMoreInfo用户名" + username);

        UserPerfectInfo userPerfectInfo = userService.queryPerfectInfo(username);
        System.out.println("Database获取birthday" + userPerfectInfo.getBirthday());
        modelMap.addAttribute("userPerfectInfo", userPerfectInfo);
        return "user/showMoreInfo";
    }

    //跳转到上传信息界面
    @RequestMapping("/tophotoWall")
    public String tophotoWall(@SessionAttribute("username") String username,ModelMap modelMap) {
        userImg.setUsername(username);
      try{
            List<UserImg> userImgs = userService.queryLifePicture(userImg);
            String path = "/user/userImg/" + userImg.getUsername() + "/";
            modelMap.addAttribute("path", path);
            modelMap.addAttribute("userImgs",userImgs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "user/photowall";
    }

    //上传生活照界面
    @RequestMapping("/uploadImg")
    public String courtship(@RequestParam("username") String username,@RequestParam("file") MultipartFile[] multipartFiles,
                            ModelMap modelMap){
        userImg.setUsername(username);
            //判断file数组不能为空并且长度大于0

            if(multipartFiles!=null&&multipartFiles.length>0){

                //循环获取file数组中得文件
                for(int i = 0;i<multipartFiles.length;i++){
                    if( multipartFiles[0].getOriginalFilename()==null||multipartFiles[0].getOriginalFilename().equals("")){
                        break;
                    }
                    MultipartFile file = multipartFiles[i];
                    //保存文件
                  String filename =  Upload.saveImg(file,username);
                   userImg.setImg(filename);
                    userService.addLifePicture(userImg);
                }
            }

            if(userService.isExitLifePicture(userImg)){
                try {
                    List<UserImg> userImgs = userService.queryLifePicture(userImg);
                    String url = "/user/userImg/" + username + "/";
                    modelMap.addAttribute("path", url);
                    modelMap.addAttribute("userImgs", userImgs);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else{
                modelMap.addAttribute("userImgs", null);
            }


            return "user/photowall";
    }

    //用户自我介绍
    @RequestMapping("/toIntroduce")
    public String toIntroduce(@SessionAttribute("username")String username, ModelMap modelMap)  {
        UserIntroduce userIntroduce = userService.querryIntroByUsername(username);

     //   System.out.println("自我介绍："+userIntroduce.getIntroduce());
        modelMap.addAttribute("userIntroduce",userIntroduce);
        return "user/userIntroduce";
    }


    @RequestMapping("/userIntroduceInfo")
    public String userIntroduce(UserIntroduce userIntroduce,ModelMap modelMap){
        //将自我介绍存储到数据库
            if(userService.addUserIntroduce(userIntroduce)){
                userService.selectByName(userIntroduce.getUsername());
            }
            System.err.println(userIntroduce.getIntroduce());
           String username = userIntroduce.getUsername();

            if(userService.isExitIntroduce(username)){
                UserIntroduce userIntroduce1 = null;
                try {
                    userIntroduce1 = userService.querryIntroByUsername(username);
                    System.out.println("自我介绍："+userIntroduce1.getIntroduce());
                    modelMap.addAttribute("userIntroduce",userIntroduce1);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            return "user/userIntroduce";
    }


}
