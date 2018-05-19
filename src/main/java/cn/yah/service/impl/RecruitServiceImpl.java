package cn.yah.service.impl;

import cn.yah.mapper.RecruitMapper;
import cn.yah.po.Recruit;
import cn.yah.po.RecruitExample;
import cn.yah.po.Page;
import cn.yah.service.CategoryService;
import cn.yah.service.EnterpriseService;
import cn.yah.service.RecruitService;
import cn.yah.vo.VoRecruit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("recruitService")
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    CategoryService categoryService;

    @Autowired
    EnterpriseService enterpriseService;

    @Autowired
    RecruitMapper recruitMapper;


    long total = 0L;

    @Override
    public List<Recruit> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Recruit> list = recruitMapper.selectByExample(new RecruitExample());
        PageInfo<Recruit> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Recruit record) {
        return recruitMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return recruitMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Recruit record) {
        return recruitMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public List<VoRecruit> vo(List<Recruit> list) {
        List<VoRecruit> list1 = new ArrayList<>();
        for (Recruit recruit:
                list) {
            VoRecruit voRecruit = new VoRecruit(recruit);
            voRecruit.setVoCid(categoryService.selectByPrimaryKey(voRecruit.getRid()).getName());
            voRecruit.setVoEid(enterpriseService.selectByPrimaryKey(voRecruit.getEid()).getName());
            list1.add(voRecruit);
        }
        return list1;
    }

    @Override
    public List<Recruit> listByEid(Page page, int id) {
        PageHelper.startPage(page.getPage(), page.getRows());
        RecruitExample example = new RecruitExample();
        RecruitExample.Criteria criteria = example.createCriteria();
        criteria.andEidEqualTo(id);
        List<Recruit> list = recruitMapper.selectByExample(example);
        PageInfo<Recruit> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public Recruit selectByPrimaryKey(Integer id) {
        return recruitMapper.selectByPrimaryKey(id);
    }

}
