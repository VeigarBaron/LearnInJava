package algorithm算法.leetcode力扣;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author VeigarBaron
 * @date 2021/1/5 14:02
 * @Description *
 */
public class 较大分组位置 {

    public List<List<Integer>> largeGroupPositions(String s) {
        char [] chars = s.toCharArray();
        LinkedList linkedList = new LinkedList();
        LinkedList resultList = new LinkedList();
        HashMap<Character,Integer> hashMap = new HashMap();
        char tempChars = chars[0];
        for (int i = 0; i < chars.length; i++){
            if (i == 0){
                hashMap.put(chars[i], 1);
                continue;
            }
            if (tempChars == chars[i]){
                hashMap.put(chars[i], hashMap.get(chars[i]) + 1);
                if (i == chars.length -1 && hashMap.get(chars[i-1]) >= 3){
                    linkedList.add(i - hashMap.get(chars[i-1]) + 1);
                    linkedList.add(i);
                    resultList.add(linkedList);
                }
            } else {
                hashMap.put(chars[i], 1);
                if (hashMap.get(chars[i-1]) >= 3){
                    linkedList.add(i - hashMap.get(chars[i-1]));
                    linkedList.add(i-1);
                    resultList.add(linkedList);
                    linkedList = new LinkedList();
                }
                tempChars = chars[i];
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        较大分组位置 a = new 较大分组位置();
        System.out.println(a.largeGroupPositions("abcdddeeeeaabbbcd").toString());
    }
}
