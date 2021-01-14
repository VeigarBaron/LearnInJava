package algorithm算法.快手LeetCode;

/**
 * @author VeigarBaron
 * @date 2020/9/7 14:47
 * @Description *
 */
public class 验证IP地址 {
    public String validIPAddress(String IP) {
        if (IP == null)
            return null;

        boolean bool;
        if (IP.contains(".")){
            String[] strings = IP.split("\\.");
            if (strings.length != 4)
                return "Neither";
            for (String string : strings) {
                if (string.startsWith("0") && string.length() != 1 || string.length() > 3 || Integer.parseInt(string) > 256)
                    return "Neither";
            }
            return "IPv4";

        } else if (IP.contains(":")){
            String hexdigits = "0123456789abcdefABCDEF";
            String[] strings = IP.split(":");
            if (strings.length != 8)
                return "Neither";
            for (String string : strings) {
                if (string.length() == 0 || string.length() > 4) return "Neither";
                for (Character ch : string.toCharArray()) {
                    if (hexdigits.indexOf(ch) == -1) return "Neither";
                }
            }
            return "IPv6";
        } else {
            return "Neither";
        }
    }
}
