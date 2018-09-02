package com.yuanbao.park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yuanbao.park.entity.User;
import com.yuanbao.park.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户控制层
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserRestController {
	
	private static Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
    @Autowired
    private UserService userService;

    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public User findByName(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "userName", required = true) String userName) {
        return userService.findByName(userName);
    }
    
}
