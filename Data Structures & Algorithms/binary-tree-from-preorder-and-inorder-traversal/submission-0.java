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
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1);
    }

    TreeNode helper( int[] preorder, int[] inorder, int si, int ei ) {
        if( idx == preorder.length || si > ei ) 
            return null;
        
        TreeNode root = new TreeNode( preorder[idx++] );
        int i = 0;
        for(  i = si; i <= ei; i++  ) {
            if( inorder[i] == root.val ) {
                break;
            }

        }

        root.left = helper( preorder, inorder, si, i-1 );
        root.right = helper( preorder, inorder, i+1, ei );

        return root;
    }

}
