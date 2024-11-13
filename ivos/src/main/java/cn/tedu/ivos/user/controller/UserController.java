package cn.tedu.ivos.user.controller;

import cn.tedu.ivos.base.response.JsonResult;
import cn.tedu.ivos.user.pojo.dto.UserLoginParam;
import cn.tedu.ivos.user.pojo.dto.UserQuery;
import cn.tedu.ivos.user.pojo.dto.UserSaveParam;
import cn.tedu.ivos.user.pojo.vo.UserVO;
import cn.tedu.ivos.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("login")
    public JsonResult login(@RequestBody UserLoginParam userLoginParam){
        log.debug("用户登录:userLoginParam={}",userLoginParam);
        //Alt+Enter 提示生成方法
        UserVO userVO = userService.login(userLoginParam);
        return JsonResult.ok(userVO);
    }
    @PostMapping("save")
    public JsonResult saveUser(UserSaveParam userSaveParam){
        log.debug("保存用户:userSaveParam={}",userSaveParam);
        userService.saveUser(userSaveParam);
        return JsonResult.ok();
    }
    @GetMapping("/select")
    public JsonResult select(UserQuery userQuery){
        log.debug("查询用户：userQuery={}",userQuery);
        List<UserVO> list=userService.selectUser(userQuery);
        log.debug("最终返回给前端的list对象{}",list);
        return JsonResult.ok(list);
    }
    @PostMapping("/update/password/{userId}")
    public JsonResult resetPassword(@PathVariable Long userId){
        log.debug("重置密码:userId={}",userId);
        userService.resetPassword(userId);
        return JsonResult.ok();
    }
    @PostMapping("/update/status/{userId}/{status}")
    public JsonResult resetStatus(@PathVariable Long userId,@PathVariable String status){
        log.debug("控制层重置用户{}的状态，重置为{}",userId,status);
        userService.resetStatus(userId,status);
        return JsonResult.ok();
    }
    @PostMapping("/delete/{userId}")
    public JsonResult deleteUser(@PathVariable Long userId){
        log.debug("控制层删除了{}用户",userId);
        userService.deleteUser(userId);
        return JsonResult.ok();
    }
}
