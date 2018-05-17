package cn.yah.mapper;

import cn.yah.po.Jobfair;
import cn.yah.po.JobfairExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobfairMapper {
    long countByExample(JobfairExample example);

    int deleteByExample(JobfairExample example);

    int deleteByPrimaryKey(Integer jfid);

    int insert(Jobfair record);

    int insertSelective(Jobfair record);

    List<Jobfair> selectByExample(JobfairExample example);

    Jobfair selectByPrimaryKey(Integer jfid);

    int updateByExampleSelective(@Param("record") Jobfair record, @Param("example") JobfairExample example);

    int updateByExample(@Param("record") Jobfair record, @Param("example") JobfairExample example);

    int updateByPrimaryKeySelective(Jobfair record);

    int updateByPrimaryKey(Jobfair record);
}