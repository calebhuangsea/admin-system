package com.caleb.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caleb.common.vo.Result;
import com.caleb.sys.entity.User;
import com.caleb.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caleb
 * @since 2023-10-01
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/all")
    public Result<List<User>> getAllUser(){
        return Result.success(userService.list(), "success");
    }

    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody User user){
        Map<String, Object> data = userService.login(user);
        if (data != null) {
            return Result.success(data, "success");
        }
        return Result.fail(20002, "username or password is wrong");
    }

    @GetMapping("/info")
    public Result<Map<String, Object>> getUserInfo(@RequestParam String token){
        Map<String, Object> data = userService.getUserInfo(token);
        if (data != null) {
            return Result.success(data, "success");
        }
        return Result.fail(20003, "information is invalid, please login again");
    }

    @PostMapping("/logout")
    public Result<?> logout(@RequestHeader("X-Token") String token){
        userService.logout(token);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<Map<String, Object>> getUserList(@RequestParam(value = "username", required = false) String username,
                                               @RequestParam(value = "phone", required = false) String phone,
                                               @RequestParam(value = "pageNo", required = false) Long pageNo,
                                               @RequestParam(value = "pageSize", required = false) Long pageSize) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(username), User::getUsername, username);
        wrapper.eq(StringUtils.hasLength(phone), User::getPhone, phone);
        wrapper.orderByDesc(User::getId);

        Page<User> page = new Page<>(pageNo, pageSize);
        userService.page(page, wrapper);

        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("rows", page.getRecords());

        return Result.success(data);
    }

    @PostMapping
    public Result<?> addUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return Result.success("User added successfully");
    }

    @PutMapping
    public Result<?> updateUser(@RequestBody User user) {
        user.setPassword(null);
        userService.updateById(user);
        return Result.success("User updated successfully");
    }

    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable Integer id) {
        User byId = userService.getById(id);
        return Result.success(byId);
    }

    @DeleteMapping("/{id}")
    public Result<User> deleteUserById(@PathVariable Integer id) {
       userService.removeById(id);
        return Result.success("User deleted successfully");
    }
}
