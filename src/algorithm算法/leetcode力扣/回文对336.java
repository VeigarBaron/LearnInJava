package algorithm算法.leetcode力扣;

import java.util.*;

/**
 *  @author VeigarBaron
 *  @date 2020/8/6
 *  @Description
 *  给定一组互不相同的单词，找出所有不同的索引对(i, j)，使得列表中的两个单词，words[i] + words[j] ，可拼接成回文串。
 *  输入：["abcd","dcba","lls","s","sssll"]
 *  输出：[[0,1],[1,0],[3,2],[2,4]]
 *  解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 *
 */
public class 回文对336 {

    // 自己的解法:
    /*public List<List<Integer>> palindromePairs(String[] words) {
        long timeMillisBegin = System.currentTimeMillis();
        int wordLength = words.length;
        List<List<Integer>> endList = new ArrayList<>();
        for (int i = 0; i < wordLength; i++){
            for (int j = 0; j < wordLength; j++){
                int length = words[i].length() + words[j].length();
                if (i != j){
                    String strTemp;
                    int intTemp;
                    if (length%2 == 0 || length == 1){
                        strTemp = words[i] + words[j];
                        intTemp = (words[i].length() + words[j].length())/2;

                    } else {
                        strTemp = words[i] + words[j];
                        intTemp = (strTemp.length() - 1)/2;
                        strTemp = strTemp.substring(0,intTemp) + strTemp.substring(intTemp + 1);
                    }
                    String qwer = strTemp.substring(0,intTemp);
                    String asdf = strTemp.substring(intTemp,2 * intTemp);
                    char[] chars = asdf.toCharArray();
                    String reverse = "";
                    for (int z = chars.length - 1; z >= 0; z--) {
                        reverse += chars[z];
                    }
                    asdf = reverse;
                    if (qwer.equals(asdf)){
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        endList.add(list);
                    }

                }
            }
        }
        long timeMillisEnd = System.currentTimeMillis();
        long time = timeMillisEnd - timeMillisBegin;
        System.out.println("time" + time + "ms");
        return endList;
    }*/

    // LeetCode的解法:
    List<String> wordsRev = new ArrayList<String>();
    Map<String, Integer> indices = new HashMap<String, Integer>();

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        for (String word: words) {
            wordsRev.add(new StringBuffer(word).reverse().toString());
        }
        for (int i = 0; i < n; ++i) {
            indices.put(wordsRev.get(i), i);
        }

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = words[i].length();
            if (m == 0) {
                continue;
            }
            for (int j = 0; j <= m; j++) {
                if (isPalindrome(word, j, m - 1)) {
                    int leftId = findWord(word, 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    int rightId = findWord(word, j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int findWord(String s, int left, int right) {
        return indices.getOrDefault(s.substring(left, right + 1), -1);
    }

    public static void main(String[] args) {
        回文对336 df = new 回文对336();
        String[] words = {"abcd","dcba","lls","s","sssll"};
//        String[] words = {"a","abc","aba",""};
//        String[] words = {"jhcfidbhfgcfibd","hicdeiadibhedccih","ddeeiigdce","d","ehaddhh","e","jch","gi","eihjbggcjgdigjjejf","cghdihihjbfbfbghg","chbjihdbhijcd","bjfhihdacggjejd","jiddjaddac","bacgejbeeg","bchechbfdccficj","aidgggedgjajdeg","g","dedf","ecahgg","aebiaebgeahabbegf","icegehifadjejigaaeb","bfejbheia","hcfidbfdidhhbbbgj","dcagh","jegfiedjieia","ibhicjihhacgfaa","deaejchfiighbahfcadi","cbbficbfj","dgjichecijfgffcb","ghdfgjiihgcegagjc","ecaediahcgcjfji","gcjicjhdhgajfg","bidijahbhi","bbiiebijjeijb","hcagjcafeichc","hcd","aacgjg","ajdjijjiehcjjijgaeha","hjjcheiicdihiaiaja","hecfgaieddijdeifi","j","f","fbjdebihf","ehgc","jgdaa","effhecjfehfecfh","dbfhcjff","ihbdfgebg","jibdaaieehj","ahaddbfgdeci","cibjcf","fcdajjddjchej","gbhbabfgiggjfajade","idbcghc","adbg","hbdbdbebbbfage","c","iicbiebjegdh","dafbeedhcajiihjfa","gihbbeacedddh","fejhhigigjcbi","ebhfb","bdbf","gagcffajh","acbgifcjegihbje","bbabbbfeefhfd","eji","jjibabbcjihj","caa","h","fbi","hbgaded","hafe","aahfajbeeaab","iidfggjfgd","dijaabbehcfhje","b","fg","gjijhacihh","iabieibecfhhijjgh","acdgfdjbfbib","aci","bhaeeiacb","bcdb","jj","eddgfbcjeg","baffbhijaij","idighfidhdjij","gd","faj","ebdjfagdhceea","ggdfgihd","dhaafcdddgi","ajji","bbdhbdd","dajchdhbaafb","ffbaagejh","dabace","jfcggdjeifdiaghiij","gcdgdfbfiiegdcej","jhfheicafifbbah","egjajdehdbhjabj","hgbdheifebdidciifdfa","diadcahdccbf","hjeacfcfcgcfadieh","jgdejaeajfibcgeigga","hbceggffehfhf","jbcdfc","ahi","bhadj","cgjgb","efbadieeafdgdcfiaig","daeedhjccagah","bfejgijbbjeg","fdjfeejijbchfchhahhd","ibadjfacbcbafh","idedeibg","igdjjfbfibebdabijgc","bjji","bijgbdidffaafaacaec","dgbefibfadb","ccjcecihf","cgjghgcdiagaic","fbhicbeccd","aae","aaicgihifbbefbde","hcfcfcfbeaifafcaddh","hajidbebbg","feief","ajdhfafagid","fba","hbdciicbhfifebhichhf","behhajhhbgg","ghgffacagbhdf","fhdhff","edfa","cjbhcab","bjcjeeeacg","dbjigagbjegc","igeefhehijgiciji","fgfibjfefjeahbcacea","hfceeifcgaaehd","ge","bcigbegbdieifihgjdg","icdfagbcd","abhijeedhfbghbjdfb","fgfjbg","ejbjjdhejfcdeha","didcjff","bfhdchadc","i","cjafig","acghahiiddbfjecjjcaf","hhhaefiajdiia","jh","egch","ccchcdfhb","cbahbjhjhi","ijjjf","fdf","fedeabahdgebef","didjfcjhdafgeaeej","bd","eegfjcchaeacd","afea","bidjccjfijchbig","egecc","fb","fcidaibfd","eceijdhibcadedbj","egcgbefdcf","ahihachihecfbah","ag","jedadjbgf","ciecbg","cjdiiejecjbe","ehheggbahfifehef","hgahbbgee","eechihcbgjjd","bgadi","gg","jebiedacbbadci","ijbeefadacgeejeghg","ghedffgd","cecd","cfiag","djegi","hebahjjcjbjceaegbg","ejecdcjifchibfgaj","chhcfi","ediffhjbbb","dfhafc","aheeheg","eaeccjccihibfaig","ieada","gbcbgajj","bhbabjdjjacec","feaedfheafihciac","jji","jdabggaeddjhag","ghcicjchfhbjjbfgh","idefjhfajicdd","eddjeadiebi","iffhaiaffehhic","bfeeedejhdhg","feddbbga","eb","addhefadhecjbedhcg","aedfgf","ghbhahfdadacaadahcdg","jijbcfjedj","iefjihgcafdbjgij","ahacbfgjiagcbigcieg","hefcidbc","geffd","iighbeacecbig","agfghehejgiicdfgdbf","cjdgeh","chfdhbedg","ehbibah","jc","egaeigheahcc","ggefccagabehdh","afbbifihffejfdg","eacag","gdddaieacfhfhce","hiijicfhhffcfiehh","ghgcaijhbhih","hbcgahjbh","gbifhggffecidjcejh","fafag","fghbaaehdg","ic","adcd","deedjibf","ejd","aajeifh","fbiaa","jhdgchgddbd","dedfegefigbcihh","haciaadejjjgchg","fjaafda","fgcffidjha","bje","ib","cacfcgfjc","hhf","ibhhibejib","id","gihbgeedccjcehi","bceagiaaa","fdffeafjb","bfafdagjgged","ecchedfiejhggdebbgaf","ceaja","digbefcaeijcffejgeii","edjaidfh","dgcbgjfadfbdh","ifhgbffif","ef","ajifdiadgiajecebbja","ehejieeabeh","iacfdeijbdgafjg","idgggibggbhffefgf","aibede","bddchdcbc","idfahhfbajab","dccdd","cdcabjfbedbafdj","didddhdfcd","fdgddfb","edfaffdajaedg","jgjbd","cbdjadgcefdacjebahdg","dhhfjhjbhehjjfj","iedfgdecghcbifc","cjef","gbjifbbjichcdejfc","gcjhidjcccidgcjg","cfifdi","gihcgj","aieegdicbfcbfaciig","defjageefihgbbifjf","jcddffhc","fiagiedgfigefj","gdehbid","gfbifi","cfidbbiejgigd","efbccgjiea","ghjbgeiagf","ffbhibgj","afacgbdjggihbadhh","bgig","fgga","diifggchaaiigbj","abiegigfhjdjhadj","eafabc","egbejhbc","jeidhhfcbcdagcja","hicecebgjabibjgj","gic","cbgiieffdcdgjgcgf","bihb","cjdhdceegdhdj","biagajcfdeijjbdibfi","hahfbgbfjjcdf","fhiaggcgecebcbhecdfg","biiahhfabbb","jdiaedgehbgdcebgabbh","diaibbgeeedbaifhcja","aefejibecchaibhifhha","ejbddjjabjb","aifa","agj","hhabggaegajicif","bi","ibah","da","dfeggaheedd","bagccffgjfhaihc","eeihdefjdjfgab","ehaidfihgeaadbeafbb","jbhgbjhhagi","ghfijdfjd","aaihhjffhbiehgcjjddf","fdee","ajjebaace","fjgdidhgjheejageach","eghagd","djajbehifgdbgghjj","ebhdjahibj","adafbfjhafd","jgajcadig","hcaijehhhhcceag","jhaeafjafghjjbc","ggdadjgbjcfcecdce","bbhfhgjhidad","aahcdhjg","fbdeheajih","gid","cdefddhecigbhfijd","bif","hf","hiahedcfdhcgagdjif","cahfgda","fcafia","jag","efjibhigjegg","beid","fadbfidjgaaddjfhjd","bafbbdcihbadiacbfgh","ddgafdij","fehicbgejdf","jgbihibjecjf","fifdaghejhffjdjaeaeb","dejhdggc","ggehg","ibbjbddbaigjg","jhgd","a","behijbdjdfefceceeib","jibcege","fabbhfgddbcbfbjbbia","iahjiaaaefajejiigf","bg","egdahebebdagd","echciejcjggggighfh","fdjg","bdehb","bcjefb","dgefebib","hdcihhgjeifiiceabg","idgagaageadgcge","fbghchddahiccf","jidjhhefichbbfd","fjjejjg","hcdjacejfadcbc","cfigcfjgdddfbdgfdfia","igbijaibejiijdbebc","dfjcheciffaecjdfg","eccgcbgbgffcbhd","je","aacggic","cdcahdhbj","afehechbhjgefgeb","aadia","abhifdcaaiigaeheg","biaagjcd","dcbggcjigifhbeceagc","idigdidhijifbf","jdfi","dj","eejhdji","cbe","db","cfaghagjehihdbhb","ciccabcc","jhijiccfbbccjajbdfbe","aajcijbhe","aihedggjcchcae","ehjeahfeg","gjeefbcjicfadaicbdbg","bbbjaejihgbaeadgaiac","ih","cgffeiiadeghegga","gfhhfgdccebfjcjcje","cjhajdhiegacghi","fdhaejfabacb","ghddccddbfbhieah","ehaeh","jeh","ajejajihhagji","haj","edhjjgifcjgg","ieggjhbfhjgcbghdacg","bhijidfgcaghjibhfj","hffdbdijhicbf","ab","fefaiedcbaddgc","cffie","jgdbdjgbfe","bbae","cfcjcadjdgchbf","jaefibjhaiiehfdjhb","gdadfai","caahcgifjfhb","bjhejjjahghcdchbia","ehabdi","ghgahccdgbhdbdfia","ggffcdb","agahfjjacie","ifeiiejhdhgdca","aiedddgjdeaai","biageedeeg","bfgbdegdhgggchaeehj","cbcfacbfdhdafdje","hifeaghjbei","hbhfi","ad","cgjfhge","fdebhbicaiejbceb","jbhcedghdafjjjdcbgd","ihecijjd","feeijicddieb","eh","baijccdgfeedgeiafejg","bjjddecijfaicbiiiij","cafcgdggcdihacbdhfi","fc","iibafgedhggig","eigag","bdigighda","fifgajfdab","eai","cjjdeaidbddgbfhcf","aaahhjfhhjbfdhdggbb","aggcddijidfajbe","hgbbhacjdiaggfh","icbhddefgcbbda","bgh","dchd","gbbaajb","aadfachjghcijh","bdbidagcjgffff","jaefgh","jjhiedghei","dajaijbebjjhagbieci","jjjihdjeggefg","hdhfjbccdbijghcgij","ccjjb","ghcegibbdigfahh","igafaejdcejcabeabbei","fihhgefihhcg","gedfaahed","jffheedecifdhcdhfi","cijhbajejhag","eed","dgch","ggjedbabhfgjfe","efhcaejffddebg","fh","acfgfdbaif","djeffiieifijgffd","figg","eeihafdfbddjji","hghbagjgi","hjbbjbhabefbca","hiid","daheefigbe","gcihgegjidjb","ehf","ghdbcgeacafgdcjgjj","dhecaifgbcafhfbda","ehdehafaidf","hheagiaafjgfhbcjahci","jfbdiifgdhb","iefbbggaafciabdaacg","fdiaedgefeca","hhiebebf","hfbebacbfcihcehe","hgadbg","egbebdahjcdge","fbibhfgdcacbafbcj","bc","igibdh","daabdbjhhg","ghcebfjbfedi","ahhihgh","gaggd","ifhdagcidc","gadbfichabgifdg","ciibaacaejc","bhbafbaghfjhf","dedjcjheigedeafjai","gjhgdgf","ifbehgij","dbcddhai","biabbgji","figbghjjgbbj","abicebig","jhgcebadjfidhhbhhif","baahhjhegajfgdf","hbdjcjjbcajcfchh","ee","aibedcfjde","gihdjbbjifbifgbf","jaedhcfgfj","bgbhcegdegcbb","didbdgjbfajejbaji","fhiaaca","bcjfbjcjiehhhj","icfcdhjcdfg","cffbjjdfbchjdj","igefbdgeecjcfhigfhbd","aahbiaah","gbfieeggidfigcgih","dbbfbihehjaggagafcag","jiccdefheidchdei","hbgg","bgdec"};
        List<List<Integer>> str = df.palindromePairs(words);
        System.out.printf("List<List<Integer>>" + str);
    }
}
