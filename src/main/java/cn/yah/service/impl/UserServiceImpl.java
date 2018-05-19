package cn.yah.service.impl;

import cn.yah.mapper.UserMapper;
import cn.yah.po.User;
import cn.yah.po.UserExample;
import cn.yah.po.Page;
import cn.yah.service.EnterpriseService;
import cn.yah.service.UserService;
import cn.yah.vo.VoUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;


    long total = 0L;

    @Override
    public List<User> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<User> list = userMapper.selectByExample(new UserExample());
        PageInfo<User> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(User record) {
        userMapper.insertSelective(record);
        return record.getUid();
    }

    @Override
    public int delete(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public List<VoUser> vo(List<User> list) {
        List<VoUser> list1 = new ArrayList<>();
        for (User user:
                list) {
//            VoUser voUser = new VoUser(user);
//            voUser.setVoEid(enterpriseService.selectByPrimaryKey(voUser.getEid()).getName());
//            list1.add(voUser);
        }
        return list1;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
