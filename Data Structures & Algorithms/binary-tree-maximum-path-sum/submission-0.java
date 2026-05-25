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
    int MIN = -(int)1e9;
    int maxSum = MIN;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    int helper( TreeNode root ) {
        if(root == null)
            return MIN;

        int lAns = helper(root.left);
        int rAns = helper(root.right);

        // case 1 root only 
        int localMaxSum = root.val;
        
        // case 2  left + root
        if(lAns != MIN)
            localMaxSum = Math.max(localMaxSum + lAns , localMaxSum) ;
        
        // case 3 root + right
        if(rAns != MIN)
            localMaxSum = Math.max(localMaxSum + rAns , localMaxSum) ;

        //check with global max
        maxSum = localMaxSum > maxSum ? localMaxSum : maxSum;
        return Math.max( root.val, Math.max( root.val + lAns, root.val + rAns ));

    }


}
