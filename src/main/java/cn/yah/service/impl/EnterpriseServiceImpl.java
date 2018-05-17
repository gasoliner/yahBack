package cn.yah.service.impl;

import cn.yah.mapper.EnterpriseMapper;
import cn.yah.po.Page;
import cn.yah.po.Enterprise;
import cn.yah.po.EnterpriseExample;
import cn.yah.service.EnterpriseService;
import cn.yah.vo.VoEnterprise;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("enterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    EnterpriseMapper enterpriseMapper;


    long total = 0L;

    @Override
    public List<Enterprise> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        EnterpriseExample example = new EnterpriseExample();
        List<Enterprise> list = enterpriseMapper.selectByExample(example);
        PageInfo<Enterprise> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public List<Enterprise> unlock_list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        EnterpriseExample example = new EnterpriseExample();
        EnterpriseExample.Criteria criteria = example.createCriteria();
        criteria.andIslockEqualTo(1);
        List<Enterprise> list = enterpriseMapper.selectByExample(example);
        PageInfo<Enterprise> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Enterprise record) {
        return enterpriseMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return enterpriseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Enterprise record) {
        return enterpriseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public List<VoEnterprise> vo(List<Enterprise> list) {
        List<VoEnterprise> list1 = new ArrayList<>();
        for (Enterprise enterprise:
                list) {
            VoEnterprise voEnterprise = new VoEnterprise(enterprise);
            voEnterprise.setVoImg("<a href = \"#\" onclick=\"showEnterprisePic('" + voEnterprise.getEid() + "')\">查看</a>");
            if (voEnterprise.getIslock() == 0) {
                voEnterprise.setVoIslock("<a href = \"#\" onclick=\"unlockEnterprise('" + voEnterprise.getEid() + "')\">审批通过</a>");
            } else {
                voEnterprise.setVoIslock("<a href = \"#\" onclick=\"lockEnterprise('" + voEnterprise.getEid() + "')\">下线该企业</a>");
            }
            list1.add(voEnterprise);
        }
        return list1;
    }

    @Override
    public List<Enterprise> lock_list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        EnterpriseExample example = new EnterpriseExample();
        EnterpriseExample.Criteria criteria = example.createCriteria();
        criteria.andIslockEqualTo(0);
        List<Enterprise> list = enterpriseMapper.selectByExample(example);
        PageInfo<Enterprise> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public Enterprise selectByPrimaryKey(Integer id) {
        return enterpriseMapper.selectByPrimaryKey(id);
    }

}
