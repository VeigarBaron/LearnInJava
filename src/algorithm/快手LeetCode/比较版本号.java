package algorithm.快手LeetCode;

/**
 * @author VeigarBaron
 * @date 2020/9/7 17:30
 * @Description *
 */
public class 比较版本号 {
    public int compareVersion(String version1, String version2) {
        String[] str = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int num1 = str.length, num2 = str2.length;
        for (int i = 0; i < Math.max(num1,num2); i++){
            int r1 = i < num1 ? Integer.parseInt(str[i]) : 0;
            int r2 = i < num2 ? Integer.parseInt(str2[i]) : 0;
            if (r1 != r2)
                return r1 > r2 ? 1 : -1;
        }
        return 0;
    }
}
