package Jzoffer;

import java.util.LinkedList;

public class FindKthNodeInBinarySearchTree {
    /*在二叉搜索树中寻找排名为K的节点*/
    public TreeNode findKthNodeInBinaryTree(TreeNode root,int k)/*采取中序遍历的方法*/
    {
        if (root == null || k < 0)
        {
            return null;
        }
        LinkedList<TreeNode> li = new LinkedList<>();
        TreeNode p = root;
        int kth = 0;

        while (p != null || !li.isEmpty())
        {
            while (p!=null)
            {
                li.push(p);
                p = p.left;
            }
            if (!li.isEmpty())
            {
                kth++;
                p = li.pop();/*出栈*/
                if (kth == k)
                {
                    return p;
                }
                p = p.right;
            }
        }
        return null;
    }
}
