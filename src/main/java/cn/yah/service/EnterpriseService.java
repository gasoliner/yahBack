package cn.yah.service;

import cn.yah.po.Page;
import cn.yah.po.Enterprise;
import cn.yah.vo.VoEnterprise;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface EnterpriseService {
    List<Enterprise> list(Page page);

    int insert(Enterprise record);

    int delete(Integer id);

    int update(Enterprise record);

    long count();

    Enterprise selectByPrimaryKey(Integer id);

    List<VoEnterprise> vo(List<Enterprise> list);

    List<Enterprise> lock_list(Page page);
}
