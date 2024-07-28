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
    TreeNode construct(int[] pre, int[] ino, 
                       int preLeft, int preRight, 
                       int inoLeft, int inoRight) {
        if (preRight - preLeft + 1 <= 0 || inoRight - inoLeft + 1<= 0)
            return null;
        TreeNode root = new TreeNode(pre[preLeft]);
        int rootIdx = -1, low = inoLeft, high = inoRight;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ino[mid] == root.val) {
                rootIdx = mid;
                break;
            }
            else if (ino[mid] < root.val)
                low = mid + 1;
            else
                high = mid - 1;
        }
        int leftSubTreeSize = rootIdx-inoLeft, rightSubTreeSize = inoRight-(rootIdx);
        //System.out.println(inoLeft + " " + inoRight);
        root.left = construct(pre, ino, preLeft+1, preLeft+leftSubTreeSize, inoLeft, rootIdx-1);
        root.right = construct(pre, ino, preLeft+leftSubTreeSize+1, preRight, rootIdx+1, inoRight);
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] pre) {
        int[] ino = new int[pre.length];
        for (int i = 0; i < pre.length; i++)
            ino[i] = pre[i];
        Arrays.sort(ino);
        return construct(pre, ino, 0, pre.length-1, 0, ino.length-1);
    }
}