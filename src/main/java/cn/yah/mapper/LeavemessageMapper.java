package cn.yah.mapper;

import cn.yah.po.Leavemessage;
import cn.yah.po.LeavemessageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeavemessageMapper {
    long countByExample(LeavemessageExample example);

    int deleteByExample(LeavemessageExample example);

    int deleteByPrimaryKey(Integer lmid);

    int insert(Leavemessage record);

    int insertSelective(Leavemessage record);

    List<Leavemessage> selectByExample(LeavemessageExample example);

    Leavemessage selectByPrimaryKey(Integer lmid);

    int updateByExampleSelective(@Param("record") Leavemessage record, @Param("example") LeavemessageExample example);

    int updateByExample(@Param("record") Leavemessage record, @Param("example") LeavemessageExample example);

    int updateByPrimaryKeySelective(Leavemessage record);

    int updateByPrimaryKey(Leavemessage record);
}