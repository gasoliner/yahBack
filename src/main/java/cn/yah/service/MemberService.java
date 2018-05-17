package cn.yah.service;

import cn.yah.po.Page;
import cn.yah.po.Member;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface MemberService {
    List<Member> list(Page page);

    int insert(Member record);

    int delete(Integer id);

    int update(Member record);

    long count();

    Member selectByPrimaryKey(Integer id);

}
