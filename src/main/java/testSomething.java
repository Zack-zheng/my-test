import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * Created by Jack on 25/05/2016.
 */
public class testSomething {
    @Test
    public void test1(){
        String[] s = StringUtils.tokenizeToStringArray("com.fndsoft.dgweixin.api.certification.dao,com.fndsoft.dgweixin.api.personalcenter.dao", ",; \t\n");
        for (String s1 : s){
            System.out.println(s1);
        }
    }
}
