package com.thinkingcaoo.springbootmail;

import com.thinkingcaoo.springbootmail.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMailApplicationTests {
    @Autowired
    private EmailService emailService;

    @Test
    public void contextLoads() {
    }

    //发送简单邮件
    @Test
    public void sendSimpleMail() throws Exception {
        emailService.sendSimpleEmail("caowencao0206@163.com", "这是一封测试邮件", " SpringBoot邮件测试");
    }

    //发送HTML邮件
    @Test
    public void sendHtmlMail() throws Exception {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>你好，这是Html格式邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        emailService.sendHtmlEmail("caowencao0206@163.com", "this is html mail", content);
    }

    //发送附件邮件
    @Test
    public void sendAttachmentsMail() {
        String filePath = "D:\\images\\pikaqiu.png";
        emailService.sendAttachmentsEmail("caowencao0206@163.com", "主题：请查收带附件的邮件", "收到附件，请查收！", filePath);

    }

    //发送带图片的邮件
    @Test
    public void test2() {
        String to = "xxx@163.com";
        String subject = "今晚要加班，不用等我了";
        String rscId = "img110";
        String content = "<html><body><img width='250px' src=\'cid:" + rscId + "\'></body></html>";
        // 此处为linux系统路径
        String imgPath = "/Users/kx/WechatIMG16.jpeg";
        try {
            emailService.sendInlineResourceEmail(to, subject, content, imgPath, rscId);
            System.out.println("成功了");
        } catch (Exception e) {
            System.out.println("失败了");
            e.printStackTrace();
        }
    }


}
