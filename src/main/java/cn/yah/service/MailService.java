package cn.yah.service;

import cn.yah.po.Mail;
import cn.yah.po.Page;
import cn.yah.vo.VoMail;

import java.util.List;


public interface MailService {
    List<Mail> list(Page page);

    int insert(Mail record);

    int delete(Integer id);

    int update(Mail record);

    long count();

    Mail selectByPrimaryKey(Integer id);

    List<VoMail> vo(List<Mail> list);
}
