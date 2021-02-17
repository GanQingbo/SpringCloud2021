import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author G
 * @version 1.0
 * @date 2021/2/6 10:38
 */
public class T2 {
    public static void main(String[] args) {
        ZonedDateTime zdt=ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);
    }
}
