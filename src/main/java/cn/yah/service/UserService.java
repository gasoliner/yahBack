package cn.yah.service;

import cn.yah.po.User;
import cn.yah.po.Page;
import cn.yah.vo.VoUser;

import java.util.List;

public interface UserService {
    List<User> list(Page page);

    int insert(User record);

    int delete(Integer id);

    int update(User record);

    long count();

    User selectByPrimaryKey(Integer id);

    List<VoUser> vo(List<User> list);
}
