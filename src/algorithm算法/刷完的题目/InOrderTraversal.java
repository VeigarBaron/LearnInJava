package algorithm算法.刷完的题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author VeigarBaron
 * @date 2021/3/9 10:40
 * @Description *
 */
public class InOrderTraversal {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversal2(root, list);
        return list;
    }

    public void inorderTraversal2(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        inorderTraversal2(root.left, list);
        list.add(root.val);
        inorderTraversal2(root.right, list);
    }

}
