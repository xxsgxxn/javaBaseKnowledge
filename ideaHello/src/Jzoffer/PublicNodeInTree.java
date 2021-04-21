package Jzoffer;

import java.util.LinkedList;

public class PublicNodeInTree {
    public TreeNode publicNodeInTree(TreeNode root,TreeNode node1,TreeNode node2)
    {
        if (root == null || node1 == null || node2 == null)
        {
            return null;
        }
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        /*寻找节点到根节点的路径，存储在list中*/
        collectNode(root,node1,list1);
        collectNode(root,node2,list2);
        return getLastSameNode(list1,list2);
    }
    public boolean collectNode(TreeNode root,TreeNode node,LinkedList<TreeNode> list)
    {
        list.add(root);
        if (root == node) return true;
        if (root.left != null)
        {
            if (collectNode(root.left,node,list)) return true;
        }
        if (root.right != null)
        {
            if (collectNode(root.right,node,list)) return true;
        }
        list.removeLast();
        return false;
    }
    public TreeNode getLastSameNode(LinkedList<TreeNode> list1,LinkedList<TreeNode> list2)
    {
        TreeNode lastsame = null;
        while (!list1.isEmpty()&&!list2.isEmpty())
        {
            if (list1.removeFirst()==list2.peekFirst())
            {
                lastsame = list2.removeFirst();
            }else{
                return lastsame;
            }
        }
        return lastsame;

    }
}
