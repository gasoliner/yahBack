package cn.yah.mapper;

import cn.yah.po.Interviewskill;
import cn.yah.po.InterviewskillExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InterviewskillMapper {
    long countByExample(InterviewskillExample example);

    int deleteByExample(InterviewskillExample example);

    int deleteByPrimaryKey(Integer iid);

    int insert(Interviewskill record);

    int insertSelective(Interviewskill record);

    List<Interviewskill> selectByExample(InterviewskillExample example);

    Interviewskill selectByPrimaryKey(Integer iid);

    int updateByExampleSelective(@Param("record") Interviewskill record, @Param("example") InterviewskillExample example);

    int updateByExample(@Param("record") Interviewskill record, @Param("example") InterviewskillExample example);

    int updateByPrimaryKeySelective(Interviewskill record);

    int updateByPrimaryKey(Interviewskill record);
}