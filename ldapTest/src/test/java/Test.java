import com.it.utils.MailUtil;

public class Test {
    @org.junit.Test
    public void Test1(){

        String email = "2080244933@qq.com";
        String title = "测试";
        String text = "测试";
        boolean b = MailUtil.sendMail(email, title, text);
        System.out.println(b);
    }
}
