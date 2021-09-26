package com.xncoding.pos.controller;

import com.xncoding.pos.common.dao.entity.BaseResponse;
import com.xncoding.pos.common.dao.entity.User;
import com.xncoding.pos.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@Api(value = "用户信息接口类", tags = "用户信息接口", description = "用户信息的增删改查")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "请求已完成"),
        @ApiResponse(code = 201, message = "资源成功被创建"),
        @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
        @ApiResponse(code = 401, message = "未授权客户机访问数据"),
        @ApiResponse(code = 403, message = "服务器接受请求，但是拒绝处理"),
        @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
        @ApiResponse(code = 500, message = "服务器出现异常")}
)
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
    @ApiOperation(value = "查询用户信息列表接口", notes = "查询所有用户信息", produces = "application/json")
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
    @ApiOperation(value = "新增用户信息接口", notes = "新增用户信息", produces = "application/json")
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
    @ApiOperation(value = "根据id查询用户信息接口", notes = "根据id查询用户信息", produces = "application/json")
    @GetMapping(value = "/{id}")
    public BaseResponse<User> getUserById(@PathVariable Integer id) {
        return new BaseResponse<>(true, "查询成功", userService.findById(id));
    }

    /**
     * 根据id更新用户信息
     * @param id
     * @return
     */
    @ApiOperation(value = "更新用户信息接口", notes = "更新用户信息", produces = "application/json")
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
    @ApiOperation(value = "删除用户信息接口", notes = "删除用户信息", produces = "application/json")
    @DeleteMapping(value = "/{id}")
    public BaseResponse<String> deleteUserById(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new BaseResponse<>(true, "删除成功", "");
    }
}
