package cn.yah.service;

import cn.yah.po.Page;
import cn.yah.po.Jobfair;
import cn.yah.vo.VoJobfair;

import java.util.List;


public interface JobfairService {
    List<Jobfair> list(Page page);

    int insert(Jobfair record);

    int delete(Integer id);

    int update(Jobfair record);

    long count();

    Jobfair selectByPrimaryKey(Integer id);

    List<VoJobfair> vo(List<Jobfair> list);

    List<Jobfair> listByEid(Page page, int i);
}
