package cn.yah.service.impl;

import cn.yah.mapper.MailMapper;
import cn.yah.po.Mail;
import cn.yah.po.MailExample;
import cn.yah.po.Page;
import cn.yah.service.EnterpriseService;
import cn.yah.service.MailService;
import cn.yah.service.MemberService;
import cn.yah.vo.VoMail;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("mailService")
public class MailServiceImpl implements MailService {


    @Autowired
    EnterpriseService enterpriseService;

    @Autowired
    MemberService memberService;

    @Autowired
    MailMapper mailMapper;


    long total = 0L;

    @Override
    public List<Mail> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Mail> list = mailMapper.selectByExample(new MailExample());
        PageInfo<Mail> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Mail record) {
        return mailMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return mailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Mail record) {
        return mailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public Mail selectByPrimaryKey(Integer id) {
        return mailMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<VoMail> vo(List<Mail> list) {
        List<VoMail> list1 = new ArrayList<>();
        for (Mail mail:
                list) {
            VoMail voMail = new VoMail(mail);
            voMail.setVoSender(enterpriseService.selectByPrimaryKey(voMail.getSender()).getName());
            voMail.setVoReceiver(memberService.selectByPrimaryKey(voMail.getReceiver()).getName());
            list1.add(voMail);
        }
        return list1;
    }

}
