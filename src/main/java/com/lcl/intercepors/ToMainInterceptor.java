
package com.lcl.intercepors;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lcl.model.User;
import com.lcl.pojo.UserShow;
import com.lcl.service.PeopleService;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author lcl
 * @date 2019/11/16 9:57
 * @Description
 */

@Component
public class ToMainInterceptor implements HandlerInterceptor {
    @Autowired
    PeopleService peopleService;
    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        int pageNum = Integer.parseInt( request.getParameter("pageNum")==null?"1":request.getParameter("pageNum"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize")==null?"5":request.getParameter("pageSize"));
     //   System.out.println("当前页码："+pageNum);
        String moren="/img/me.jpg";

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
        session.setAttribute("pageInfo", pageInfo);
        /*modelMap.addAttribute("pageInfo", pageInfo);
        //获得当前页
        modelMap.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        modelMap.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        modelMap.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        modelMap.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        modelMap.addAttribute("isLastPage", pageInfo.isIsLastPage());*/
            return true;    //如果session里有user，表示该用户已经登陆，放行，用户即可继续调用自己需要的接口

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {




    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }

}

