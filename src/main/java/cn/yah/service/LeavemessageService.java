package cn.yah.service;

import cn.yah.po.Leavemessage;
import cn.yah.po.Page;
import cn.yah.vo.VoLeavemessage;

import java.util.List;


public interface LeavemessageService {
    List<Leavemessage> list(Page page);

    int insert(Leavemessage record);

    int delete(Integer id);

    int update(Leavemessage record);

    long count();

    Leavemessage selectByPrimaryKey(Integer id);

    List<VoLeavemessage> vo(List<Leavemessage> list);
}
