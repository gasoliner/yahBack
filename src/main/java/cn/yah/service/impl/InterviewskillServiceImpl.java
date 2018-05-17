package cn.yah.service.impl;

import cn.yah.mapper.InterviewskillMapper;
import cn.yah.po.Interviewskill;
import cn.yah.po.InterviewskillExample;
import cn.yah.po.Page;
import cn.yah.service.InterviewskillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("interviewskillService")
public class InterviewskillServiceImpl implements InterviewskillService {


    @Autowired
    InterviewskillMapper interviewskillMapper;


    long total = 0L;

    @Override
    public List<Interviewskill> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Interviewskill> list = interviewskillMapper.selectByExample(new InterviewskillExample());
        PageInfo<Interviewskill> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Interviewskill record) {
        return interviewskillMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return interviewskillMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Interviewskill record) {
        return interviewskillMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public Interviewskill selectByPrimaryKey(Integer id) {
        return interviewskillMapper.selectByPrimaryKey(id);
    }

}
