package algorithm算法.刷完的题目;

/**
 * @author VeigarBaron
 * @date 2021/2/1 15:04
 * @Description *
 */
public class MoveZeroes {

    // 删除替换0
    public void moveZeroes0(int[] nums) {

        int off = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[off] = nums[i];
                off++;
            }
        }
        for (int j = 0; j < nums.length - off; j++){
            nums[off + j] = 0;
        }
    }

    // 双指针移动
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {3,5,0,4,9,1,0,7,6,0,2};
        moveZeroes.moveZeroes(nums);
    }
}
