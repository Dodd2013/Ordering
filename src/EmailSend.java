import com.util.mail.Email;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dodd on 2015/4/18.
 */
public class EmailSend extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         *
         *************切切注意********
         *
         *注意  用此程序发邮件必须邮箱支持smtp服务  在2006年以后申请的163邮箱是不支持的
         *我知道sina邮箱  sohu邮箱 qq邮箱支持  但是sina和qq邮箱需要手工设置开启此功能
         *所以在测试时最好使用这三个邮箱
         *sina邮箱的smtp设置方法如下
         *登录sina邮箱 依次点击 邮箱设置--->帐户--->POP/SMTP设置 将开启复选框选中 然后保存
         *
         *************切切注意********
         */
        Email themail = new Email("smtp.qq.com");//这里以新浪邮箱为例子
        String mailbody = "<a href=''' target='_blank'>验证码为" + req.getParameter("code") + "</a>";//邮件正文
        themail.setNeedAuth(true);
        themail.setSubject("JAVA发邮件的测试");//邮件主题
        themail.setBody(mailbody);//邮件正文
        themail.setTo(req.getParameter("email"));//收件人地址
        themail.setFrom("Dodd@Dodd2014.com");//发件人地址
        //themail.addFileAffix("F:/download/email.rar");// 附件文件路径,例如：C:/222.jpg,*注；"/"的写法； 如果没有可以不写
        themail.setNamePass("Dodd@Dodd2014.com", "CHENDAOXIANG123@");//发件人地址和密码 **改为相应邮箱密码
        themail.sendout();
    }
}
