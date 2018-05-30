package cn.yah.vo;
import java.util.Date;

import cn.yah.po.Mail;


public class VoMail extends Mail {

    private String voSender;

    private String voReceiver;

    public VoMail(Mail mail) {
        this.setMaid(mail.getMaid());
        this.setName(mail.getName());
        this.setSender(mail.getSender());
        this.setReceiver(mail.getReceiver());
        this.setContent(mail.getContent());
        this.setTime(mail.getTime());
    }

    public VoMail() {}

    public String getVoSender() {
        return voSender;
    }

    public void setVoSender(String voSender) {
        this.voSender = voSender;
    }

    public String getVoReceiver() {
        return voReceiver;
    }

    public void setVoReceiver(String voReceiver) {
        this.voReceiver = voReceiver;
    }
}
