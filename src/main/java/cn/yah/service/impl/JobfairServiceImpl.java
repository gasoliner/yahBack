package cn.yah.service.impl;

import cn.yah.mapper.JobfairMapper;
import cn.yah.po.*;
import cn.yah.service.CategoryService;
import cn.yah.service.EnterpriseService;
import cn.yah.service.JobfairService;
import cn.yah.vo.VoJobfair;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("jobfairService")
public class JobfairServiceImpl implements JobfairService {

    @Autowired
    EnterpriseService enterpriseService;

    @Autowired
    JobfairMapper jobfairMapper;


    long total = 0L;

    @Override
    public List<Jobfair> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Jobfair> list = jobfairMapper.selectByExample(new JobfairExample());
        PageInfo<Jobfair> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Jobfair record) {
        return jobfairMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return jobfairMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Jobfair record) {
        return jobfairMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public List<VoJobfair> vo(List<Jobfair> list) {
        List<VoJobfair> list1 = new ArrayList<>();
        for (Jobfair Jobfair:
                list) {
            VoJobfair voJobfair = new VoJobfair(Jobfair);
            voJobfair.setVoEid(enterpriseService.selectByPrimaryKey(voJobfair.getEid()).getName());
            list1.add(voJobfair);
        }
        return list1;
    }

    @Override
    public List<Jobfair> listByEid(Page page, int i) {
        PageHelper.startPage(page.getPage(), page.getRows());
        JobfairExample example = new JobfairExample();
        JobfairExample.Criteria criteria = example.createCriteria();
        criteria.andEidEqualTo(i);
        List<Jobfair> list = jobfairMapper.selectByExample(example);
        PageInfo<Jobfair> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public Jobfair selectByPrimaryKey(Integer id) {
        return jobfairMapper.selectByPrimaryKey(id);
    }

}
