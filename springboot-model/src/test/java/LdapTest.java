import com.it.Application;
import com.it.utils.LdapUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class LdapTest {

    @Autowired
    private LdapTemplate ldapTemplate;

    @Test
    public void authUser() throws NamingException {
        String userDN = null;
        SearchControls contro = new SearchControls();
        contro.setSearchScope(SearchControls.SUBTREE_SCOPE);
        //, "title","userPrincipalName","employeeNumber","employeeID","telephoneNumber"
        contro.setReturningAttributes(new String[] {"cn","title","userPrincipalName","employeeNumber","employeeID","serialNumber","manager"});
        DirContext ctx = LdapUtil.ldapConnect();
        NamingEnumeration<SearchResult> search = ctx.search("DC=corp,DC=JABIL,DC=org", "employeeNumber=3554536", contro);
        System.out.println(search.next());
        try {
            if (ctx != null) {
                ctx.close();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }












//        Object lookup = ctx.lookup("cn=3554536");
//        Attributes attributes = ctx.getAttributes("3554536");
//        System.out.println(lookup);
//        NamingEnumeration<SearchResult> en = ctx.search("DC=corp,DC=JABIL,DC=org", "cn=3554536" , contro);
//        if (en == null || !en.hasMoreElements()) {
//            System.out.println("null");
//        }
//        while (en.hasMoreElements()) {
//            Object obj = en.nextElement();
//            if (obj instanceof SearchResult) {
//                SearchResult si = (SearchResult) obj;
//                Attributes attrs = si.getAttributes();
//                userDN = (String) attrs.get("distinguishedName").get();
//                break;
//            }
//        }
//        System.out.println(userDN);
    }

}

