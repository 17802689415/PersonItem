import javax.naming.NamingException;

import com.it.Application;
import com.it.utils.ldap.LdapServiceImpl;
import com.it.utils.ldap.LdapUser;
import com.it.utils.ldap.LdapUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class LdapTest {

    @Autowired
    private LdapTemplate ldapTemplate;

    @Test
    public void authUser(){
        DirContextAdapter obj = (DirContextAdapter) ldapTemplate.lookup("uid=3554536,ou=users");
        System.out.println(obj);
    }

}

