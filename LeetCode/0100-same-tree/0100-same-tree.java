/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // 서로 val이 다르면 false return
        if(p == null && q == null) return true;
        else if(!(p != null && q != null)) return false;
        if(p.val != q.val) return false;

        if(p.left != null && q.left != null) {
            if(isSameTree(p.left, q.left) == false) return false;
        } else if(!(p.left == null && q.left == null)) return false;
        if(p.right != null && q.right != null) {
            if(isSameTree(p.right, q.right) == false) return false;
        } else if(!(p.right == null && q.right == null)) return false;
        
        return true;
    }
}