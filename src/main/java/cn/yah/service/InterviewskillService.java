package cn.yah.service;

import cn.yah.po.Interviewskill;
import cn.yah.po.Page;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface InterviewskillService {
    List<Interviewskill> list(Page page);

    int insert(Interviewskill record);

    int delete(Integer id);

    int update(Interviewskill record);

    long count();

    Interviewskill selectByPrimaryKey(Integer id);

}
