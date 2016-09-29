package com.ourfuture.back_front.controller;

import com.ourfuture.back_front.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;
import com.ourfuture.back_front.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    /**
     * 添加用户(该方法用来测试ajax正常调用)
     * 
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addUser(HttpServletRequest request,
            HttpServletResponse response) {
        User user = new User();
        user.setUsername("ice");
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            userService.saveOrUpdateUser(user);
            map.put("flag", true);
        } catch (Exception e) {
            map.put("flag", false);
        }
        setHeaderTitle(response);
        return map;
    }

    /**
     * 获取用户列表()
     * 
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getUserList(HttpServletRequest request,
            HttpServletResponse response) {
        String sPage = WebUtils.findParameterValue(request, "page");
        String sPageSize = request.getParameter("pageSize");
        int page = Integer.parseInt(sPage);
        int pageSize = Integer.parseInt(sPageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> userList = userService.getUserList(page, pageSize);
        map.put("userList", userList);
        setHeaderTitle(response);
        return map;
    }

    /**
     * 获取用户列表
     * 
     * @return
     */
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    @ResponseBody
    public List<User> userList(HttpServletRequest request,HttpServletResponse response) {
        String sPage = WebUtils.findParameterValue(request, "page");
        String sPageSize = request.getParameter("pageSize");
        int page = Integer.parseInt(sPage);
        int pageSize = Integer.parseInt(sPageSize);
        List<User> userList = userService.getUserList(page, pageSize);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
        return userList;
    }

    /**
     * 添加用户
     * 
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    @ResponseBody
    public List<User> addUser(@RequestBody User user, HttpServletRequest request,HttpServletResponse response) {
        String sPage = WebUtils.findParameterValue(request, "page");
        String sPageSize = request.getParameter("pageSize");
        int page = Integer.parseInt(sPage);
        int pageSize = Integer.parseInt(sPageSize);
        userService.saveOrUpdateUser(user);
        List<User> userList = userService.getUserList(page, pageSize);
        setHeaderTitle(response);
        return userList;
    }

    /**
     * 更新用户
     * 
     * @param user
     *            前台获取用户对象
     * @param request
     *            请求对象
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public List<User> updateUser(@RequestBody User user,
            HttpServletRequest request,HttpServletResponse response) {
        String sPage = WebUtils.findParameterValue(request, "page");
        String sPageSize = request.getParameter("pageSize");
        int page = Integer.parseInt(sPage);
        int pageSize = Integer.parseInt(sPageSize);
        userService.saveOrUpdateUser(user);
        List<User> list = userService.getUserList(page, pageSize);
        setHeaderTitle(response);
        return list;
    }

    /**
     * 删除用户
     * 
     * @param request
     *            请求对象
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public List<User> deleteUser(HttpServletRequest request,HttpServletResponse response) {
        String userId = request.getParameter("id");
        String sPage = WebUtils.findParameterValue(request, "page");
        String sPageSize = request.getParameter("pageSize");
        int page = Integer.parseInt(sPage);
        int pageSize = Integer.parseInt(sPageSize);
        User user = new User(userId);
        userService.deleteUser(user);
        List<User> list = userService.getUserList(page, pageSize);
        setHeaderTitle(response);
        return list;
    }

    private void setHeaderTitle(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
    }

    /**
     * 用户业务接口
     */
    @Autowired
    private IUserService userService;

}
