import com.zh3ng.club.pmd.custom.Main;
import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.lang.LanguageFilenameFilter;
import org.junit.Test;

/**
 * @author zhangxingang
 * @created on 2020/5/2
 */
public class WhileLoopTest {

    /**
     * 自己在该目录下 写点.java 文件用于测试规则检测
     */
    private static String DEFAULT_TEST_JAVA_FILE_PATH = "src/test";

    public static void main(String[] args) {
    }

    @Test
    public void testParameterCommaRule(){
        String[] args = new String[]{
                "-d",DEFAULT_TEST_JAVA_FILE_PATH,
                "-R", "rulesets/zh3ng-parameter-rules.xml"};
        Main.main(args);
    }

    @Test
    public void testParameterCommaRule1(){
        String[] args = new String[]{"-d",DEFAULT_TEST_JAVA_FILE_PATH,"-R", "rulesets/zh3ng-parameter-rules.xml"};
        Main.main(args);
    }

    @Test
    public void testNamingRule(){
        String[] args = new String[]{"-d",DEFAULT_TEST_JAVA_FILE_PATH,"-R", "rulesets/ali-naming.xml"};
        Main.main(args);
    }

}
