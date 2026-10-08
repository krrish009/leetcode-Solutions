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
    int minDifference = Integer.MAX_VALUE;
    TreeNode prevNode = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDifference;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        // 1. Traverse Left Subtree
        inorder(root.left);
        // 2. Process Current Root Node
        if (prevNode != null) {
            minDifference = Math.min(minDifference, root.val - prevNode.val);
        }
        prevNode = root; // Update previous node to current
        // 3. Traverse Right Subtree
        inorder(root.right);
    }
}
