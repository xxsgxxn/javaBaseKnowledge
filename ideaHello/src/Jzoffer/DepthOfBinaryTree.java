package Jzoffer;

import java.util.LinkedList;
import java.util.Queue;

public class DepthOfBinaryTree {
    /*求一个二叉树的深度，取左右子树中深度最大的为二叉树的深度*/
    public int depthOfBinaryTree(TreeNode root)
    {
        if (root == null )
        {
            return 0;
        }
        int left = depthOfBinaryTree(root.left);
        int right = depthOfBinaryTree(root.right);
        return left > right ? 1+left : 1+right;
    }
    /*非递归版本，利用队列进行层序遍历，每次将队列中每一层的节点进行记录，等一层遍历完了就将深度+1*/
    public int depthOfBinaryTree2(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty())
        {
            int m = queue.size();
            for (int i = 0;i < m;i++)
            {
                TreeNode p = queue.poll();
                if (p.left != null){
                    queue.offer(p.left);
                }
                if (p.right != null)
                {
                    queue.offer(p.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /*求的是平衡二叉树，假定输入的已经是二叉搜索树了*/
    public boolean isBalancedBinaryTree(TreeNode root)
    {
        if (root == null)
        {
            return false;
        }
        int left = depthOfBinaryTree(root.left);
        int right = depthOfBinaryTree(root.right);
        if (Math.abs(left - right) > 1)
        {
            return false;
        }
        return isBalancedBinaryTree(root.left)&&isBalancedBinaryTree(root.right);
    }
    /*不重复访问节点，当某个子树左右子树深度相差超过1后，就直接返回-1指导根，
    最后直接判断根树的深度是不是>=1就可知道是否平衡二叉树*/

    public int depth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return left>=0 && right>=0 && Math.abs(left-right) <= 1 ? Math.max(left,right)+1 : -1;
    }
    public boolean isBalanceBinaryTree2(TreeNode root)
    {
        return depth(root) >= 0 ? true:false;
    }

    /*利用后续遍历来判断，后续遍历当左右子节点深度超过1时就返回false，depth[]用来记录当前节点的深度，节点为NULL时深度就是0*/
    /*后续遍历先左子树，再右子树，再当前节点，就能先求出左右子树的深度来判断*/
    /*若左右子树中有一个不是平衡二叉树，则就返回当前二叉树也不是平衡二叉树*/
    public boolean isBalance(TreeNode root,int[]depth)
    {
        if (root == null)
        {
            depth[0] = 0;
            return true;
        }
        boolean leftflag = isBalance(root.left,depth);
        int leftdepth = depth[0];
        boolean rightflag = isBalance(root.right,depth);
        int rightdepth = depth[0];
        /*当前节点的深度*/
        depth[0] = Math.max(leftdepth,rightdepth)+1;

        if (leftflag && rightflag && Math.abs(leftdepth-rightdepth)<=1) return true;
        return false;
    }

    public boolean isBalance_solution(TreeNode root)
    {
        int[] depth = new int[1];
        return isBalance(root,depth);
    }






}
