package cn.tedu.ivos.user.service;

import cn.tedu.ivos.user.pojo.dto.UserLoginParam;
import cn.tedu.ivos.user.pojo.dto.UserQuery;
import cn.tedu.ivos.user.pojo.dto.UserSaveParam;
import cn.tedu.ivos.user.pojo.vo.UserVO;

import java.util.List;

public interface UserService {
    UserVO login(UserLoginParam userLoginParam);
    List<UserVO> selectUser(UserQuery userQuery);
    void saveUser(UserSaveParam userSaveParam);
    void resetPassword(Long userId);
    void resetStatus(Long userId,String status);
    void deleteUser(Long userId);
}
