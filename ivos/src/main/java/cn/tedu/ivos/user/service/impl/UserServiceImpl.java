package cn.tedu.ivos.user.service.impl;

import cn.tedu.ivos.base.exception.ServiceException;
import cn.tedu.ivos.base.response.StatusCode;
import cn.tedu.ivos.user.mapper.UserMapper;
import cn.tedu.ivos.user.pojo.dto.UserLoginParam;
import cn.tedu.ivos.user.pojo.dto.UserQuery;
import cn.tedu.ivos.user.pojo.dto.UserSaveParam;
import cn.tedu.ivos.user.pojo.entity.User;
import cn.tedu.ivos.user.pojo.vo.UserVO;
import cn.tedu.ivos.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserVO login(UserLoginParam userLoginParam) {
        log.debug("用户登录信息加载到业务层：{}",userLoginParam);
        UserVO userVO = userMapper.selectByUsername(userLoginParam.getUsername());
        log.debug("登录完成，登录信息返回到业务层：{}",userVO);
        if(userVO==null){
            throw new ServiceException(StatusCode.USERNAME_ERROR);
        }
        if(!userVO.getPassword().equals(userLoginParam.getPassword())){
            throw new ServiceException(StatusCode.PASSWORD_ERROR);
        }
        return userVO;
    }

    @Override
    public List<UserVO> selectUser(UserQuery userQuery) {
        log.debug("业务层获取到用户输入的信息：{}，准备开始查询",userQuery);
        List<UserVO>list=userMapper.selectUser(userQuery);
        log.debug("查询完成，业务层获得查询结果：{}，开始传给前端",list);
        return list;
    }
    @Override
    public void saveUser(UserSaveParam userSaveParam) {
        log.debug("用户信息加载到业务层，开始保存：{}",userSaveParam);
        User user = new User();
        BeanUtils.copyProperties(userSaveParam,user);
        if(user.getId()==null){//新增操作
            user.setPassword("123456");
            user.setCreateTime(new Date());
            userMapper.insert(user);
            log.debug("保存完成，保存结果返回至业务层");
        }else{
            //TODO:修改用户
            user.setUpdateTime(new Date());
            userMapper.update(user);
            log.debug("更新完成，更新结果返回至业务层");
        }
    }
    @Override
    public void resetPassword(Long userId) {
        log.debug("重置密码业务，参数：{}", userId);
        User user = new User();
        user.setId(userId);
        user.setPassword("root");
        user.setUpdateTime(new Date());
        userMapper.update(user);
    }

    @Override
    public void resetStatus(Long userId, String status) {
        log.debug("业务层修改了{}号用户的状态，修改为{}",userId,status);
        User user=new User();
        user.setId(userId);
        user.setStatus(status);
        user.setUpdateTime(new Date());
        userMapper.update(user);
    }

    @Override
    public void deleteUser(Long userId) {
        log.debug("业务层执行了删除{}用户的操作",userId);
        userMapper.delete(userId);
    }
}
