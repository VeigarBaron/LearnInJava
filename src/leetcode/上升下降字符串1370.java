package leetcode;

/**
 * @author VeigarBaron
 * @date 2020/8/27 10:29
 * @Description *
 */
public class 上升下降字符串1370 {
    public String sortString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()){
            count[c - 'a'] += 1;
        }
        StringBuilder stringBuilder =  new StringBuilder();
        while (stringBuilder.length() != s.length()) {
           for (int i = 0; i < 26; i ++){
               if (count[i] == 0){
                   continue;
               }
               stringBuilder.append((char)(i + 'a'));
               count[i] -= 1;
           }
            for (int i = 25; i >= 0; i --){
                if (count[i] == 0){
                    continue;
                }
                stringBuilder.append((char)(i + 'a'));
                count[i] -= 1;
            }
        }
        return stringBuilder.toString();
    }
}
