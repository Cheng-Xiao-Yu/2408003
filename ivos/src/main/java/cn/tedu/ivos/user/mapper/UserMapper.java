package cn.tedu.ivos.user.mapper;

import cn.tedu.ivos.user.pojo.dto.UserQuery;
import cn.tedu.ivos.user.pojo.entity.User;
import cn.tedu.ivos.user.pojo.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    UserVO selectByUsername(String username);
    List<UserVO> selectUser(UserQuery userQuery);
    void insert(User user);
    void update(User user);
    void delete(Long userId);
}
