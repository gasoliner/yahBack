package cn.yah.service.impl;

import cn.yah.mapper.ApplyMapper;
import cn.yah.po.Member;
import cn.yah.po.Page;
import cn.yah.po.Apply;
import cn.yah.po.ApplyExample;
import cn.yah.service.*;
import cn.yah.vo.VoApply;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    RecruitService recruitService;

    @Autowired
    MemberService memberService;

    @Autowired
    ApplyMapper applyMapper;


    long total = 0L;

    @Override
    public List<Apply> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Apply> list = applyMapper.selectByExample(new ApplyExample());
        PageInfo<Apply> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Apply record) {
        return applyMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return applyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Apply record) {
        return applyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public List<VoApply> vo(List<Apply> list) {
        List<VoApply> list1 = new ArrayList<>();
        for (Apply apply:
                list) {
            VoApply voApply = new VoApply(apply);
            Member member = memberService.selectByPrimaryKey(voApply.getMid());
            voApply.setVoMid(member.getName());
            voApply.setVoRid(recruitService.selectByPrimaryKey(voApply.getRid()).getName());
            voApply.setVoResume("<a href = \"#\" onclick=\"showMemberResume('" + member.getMid() + "')\">查看简历</a>");
            voApply.setMember(member);
            voApply.setAction("*<a href = \"#\" onclick=\"editInterviewOffer('" + voApply.getAid() + "')\">通过并编辑面试邀约</a>* <br/> *<a href = \"#\" onclick=\"refuseThisMan('" + voApply.getAid() + "')\">拒绝</a>*");
            list1.add(voApply);
        }
        return list1;
    }

    @Override
    public Apply selectByPrimaryKey(Integer id) {
        return applyMapper.selectByPrimaryKey(id);
    }

}
