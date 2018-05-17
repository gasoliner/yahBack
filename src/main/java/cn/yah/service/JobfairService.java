package cn.yah.service;

import cn.yah.po.Page;
import cn.yah.po.Jobfair;
import cn.yah.vo.VoJobfair;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface JobfairService {
    List<Jobfair> list(Page page);

    int insert(Jobfair record);

    int delete(Integer id);

    int update(Jobfair record);

    long count();

    Jobfair selectByPrimaryKey(Integer id);

    List<VoJobfair> vo(List<Jobfair> list);
}
