package algorithm.bubbleSort;

/**
 * Created by HuoPing on 2019/1/8.
 */
public class forBubble {

    private static void bubbleSort(){
        int [] aa = {1,8,4,3,6,7,5,2,9,0};
        boolean b= false;
        for (int i = 0; i < aa.length; i++){
            for (int j = 1+i; j < aa.length ; j++){
                if (aa[i] > aa[j]){
                    int temp = aa[i];
                    aa[i] = aa[j];
                    aa[j] = temp;
                    b = true;
                }
            }
            if (!b){
                break;
            }
        }
        System.out.print("a");
        for (Integer a : aa){
            System.out.print(a);
        }
    }

    public static void main(String[] args) {
        bubbleSort();
    }
}
