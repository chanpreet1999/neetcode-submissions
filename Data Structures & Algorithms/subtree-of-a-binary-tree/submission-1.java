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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        return helper( root, subRoot );
    }

    boolean helper( TreeNode root, TreeNode subRoot ) {
        if( root == null && subRoot == null )
            return true;
        else if( root == null && subRoot != null  )
            return false;
        else if( root != null && subRoot == null  )
            return false;

        boolean ans = false;
        // if nodes are equal then compare the inner trees
        if(root.val == subRoot.val)
            ans = ans || isSameTree( root, subRoot );
        
        ans  = ans || helper( root.left, subRoot );
        ans = ans  || helper( root.right, subRoot );
        
        return ans;
    }

    boolean isSameTree( TreeNode r1, TreeNode r2 ) {
        if( r1 == null && r2 == null)
            return true;
        else if ( (r1 == null && r2 != null) || (r1 != null && r2 == null) )
            return false;
        
        boolean res = (r1.val == r2.val);
        res = res && isSameTree( r1.left, r2.left );
        res = res && isSameTree( r1.right, r2.right );
        
        return res;


    }
}
