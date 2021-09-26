package com.xncoding.pos.controller;

import com.xncoding.pos.common.dao.entity.BaseResponse;
import com.xncoding.pos.common.dao.entity.User;
import com.xncoding.pos.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger _logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * 查询用户信息列表
     * @param user
     * @return
     */
    @GetMapping(value = "/")
    public BaseResponse<List<User>> getUserList(User user) {
        List<User> userList = userService.selectUserList(user);
        return new BaseResponse<>(true, "查询列表成功", userList);
    }

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    @PostMapping(value = "/")
    public BaseResponse<String> addUser(@ModelAttribute User user) {
        userService.insertUser(user);
        return new BaseResponse<>(true, "新增成功", "");
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public BaseResponse<User> getUserById(@PathVariable Integer id) {
        return new BaseResponse<>(true, "查询成功", userService.findById(id));
    }

    /**
     * 根据id更新用户信息
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    public BaseResponse<String> updateUserById(@PathVariable Integer id, @ModelAttribute User user) {
        userService.updateUser(user);
        return new BaseResponse<>(true, "更新成功", "");
    }

    /**
     * 根据id删除用户信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public BaseResponse<String> deleteUserById(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new BaseResponse<>(true, "删除成功", "");
    }
}
