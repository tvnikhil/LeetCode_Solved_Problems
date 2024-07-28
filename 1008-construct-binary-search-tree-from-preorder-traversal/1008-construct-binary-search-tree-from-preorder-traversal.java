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
    // TreeNode construct(int[] pre, int[] ino, 
    //                    int preLeft, int preRight, 
    //                    int inoLeft, int inoRight) {
    //     if (preRight - preLeft + 1 <= 0 || inoRight - inoLeft + 1<= 0)
    //         return null;
    //     TreeNode root = new TreeNode(pre[preLeft]);
    //     int rootIdx = -1, low = inoLeft, high = inoRight;
    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         if (ino[mid] == root.val) {
    //             rootIdx = mid;
    //             break;
    //         }
    //         else if (ino[mid] < root.val)
    //             low = mid + 1;
    //         else
    //             high = mid - 1;
    //     }
    //     int leftSubTreeSize = rootIdx-inoLeft, rightSubTreeSize = inoRight-(rootIdx);
    //     //System.out.println(inoLeft + " " + inoRight);
    //     root.left = construct(pre, ino, preLeft+1, preLeft+leftSubTreeSize, inoLeft, rootIdx-1);
    //     root.right = construct(pre, ino, preLeft+leftSubTreeSize+1, preRight, rootIdx+1, inoRight);
    //     return root;
    // }
    
    TreeNode construct(int[] pre, int l, int r) {
        TreeNode root = new TreeNode(pre[l]);
        // find left root and right root
        int leftRootIdx = -1, rightRootIdx = -1;
        for (int i = l+1; i <= r; i++) {
            if (pre[i] < root.val) {
                leftRootIdx = i;
                break;
            }
        }
        for (int i = l+1; i <= r; i++) {
            if (pre[i] > root.val) {
                rightRootIdx = i;
                break;
            }
        }
        if (leftRootIdx == -1 || rightRootIdx == -1) {
            if (leftRootIdx == -1 && rightRootIdx == -1) {
                root.right = null;
                root.left = null;
            }
            else if (leftRootIdx == -1) {
                root.left = null;
                root.right = construct(pre, rightRootIdx, r);
            }
            else {
                root.right = null;
                root.left = construct(pre, leftRootIdx, r);
            }
        }
        else {
            root.left = construct(pre, leftRootIdx, rightRootIdx-1);
            root.right = construct(pre, rightRootIdx, r);
        }
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] pre) {
        // int[] ino = new int[pre.length];
        // for (int i = 0; i < pre.length; i++)
        //     ino[i] = pre[i];
        // Arrays.sort(ino);
        return construct(pre, 0, pre.length-1);
    }
}