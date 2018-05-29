package cn.yah.service;

import cn.yah.po.Page;
import cn.yah.po.Apply;
import cn.yah.vo.VoApply;

import java.util.List;


public interface ApplyService {
    List<Apply> list(Page page);

    int insert(Apply record);

    int delete(Integer id);

    int update(Apply record);

    long count();

    Apply selectByPrimaryKey(Integer id);

    List<VoApply> vo(List<Apply> list);

    List<Apply> listByRid(Page page, int id);
}
