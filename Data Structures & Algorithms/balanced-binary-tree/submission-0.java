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
    boolean ans = true;
    
    public boolean isBalanced(TreeNode root) {
        helper( root );
        return ans;
    
    }

    int helper( TreeNode root ) {
        if(root == null)
            return 0;
        
        int lHeight = helper( root.left );
        int rHeight = helper( root.right );

        ans = ans && (Math.abs( lHeight - rHeight ) <= 1);   
        return 1 + Math.max(lHeight, rHeight);
    }
}
