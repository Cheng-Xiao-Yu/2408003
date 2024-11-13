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
        log.debug("用户登录信息加载到控制层：{}",userLoginParam);
        //Alt+Enter 提示生成方法
        UserVO userVO = userService.login(userLoginParam);
        log.debug("登录完成，登录信息返回到控制层：{}",userVO);
        return JsonResult.ok(userVO);
    }
    @PostMapping("save")
    public JsonResult saveUser(@RequestBody UserSaveParam userSaveParam){
        log.debug("用户信息加载到控制层，开始保存：{}",userSaveParam);
        userService.saveUser(userSaveParam);
        log.debug("保存完成，保存结果返回至控制层");
        return JsonResult.ok();
    }
    @GetMapping("/select")
    public JsonResult select(UserQuery userQuery){
        log.debug("控制层获取到用户输入的信息：{}，准备开始查询",userQuery);
        List<UserVO> list=userService.selectUser(userQuery);
        log.debug("查询完成，控制层获得查询结果：{}，开始传给前端",list);
        return JsonResult.ok(list);
    }
    @PostMapping("/update/password/{userId}")
    public JsonResult resetPassword(@PathVariable Long userId){
        log.debug("控制层开始处理重置密码:userId={}",userId);
        userService.resetPassword(userId);
        log.debug("控制层：{}密码重置完成",userId);
        return JsonResult.ok();
    }
    @PostMapping("/update/status/{userId}/{status}")
    public JsonResult resetStatus(@PathVariable Long userId,@PathVariable String status){
        log.debug("控制层重置用户{}的状态，重置为{}",userId,status);
        userService.resetStatus(userId,status);
        log.debug("控制层获取重置状态成功");
        return JsonResult.ok();
    }
    @PostMapping("/delete/{userId}")
    public JsonResult deleteUser(@PathVariable Long userId){
        log.debug("控制层开始处理删除{}用户",userId);
        userService.deleteUser(userId);
        log.debug("控制层：用户{}删除完成",userId);
        return JsonResult.ok();
    }
}
