import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    public static void main(String[] args) {
        String answer= "{[1,2,3][3,4,5][4,6,8]}";
        Pattern p =  Pattern.compile("\\d");
        Matcher m = p.matcher(answer);
        m.find();
            System.out.println(m.group(1));
    }
}
