package Jzoffer;

import java.util.ArrayList;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode father;
    TreeNode(int val)
    {
        this.val = val;
    }
}
public class rebuild_tree {
    public TreeNode createTreeByPreIn(int[] pre,int[]in)
    {

        TreeNode root = createTreeByPreInDetail(pre,in,0,pre.length-1,0,in.length-1);
        root.father = null;
        return root;
    }
    public TreeNode createTreeByPreInDetail(int[] pre,int[] in,int pl,int pr,int il,int ir)
    {
        if (pl > pr || il > ir)/*数组不能怎分了，证明应该是空节点*/
        {
            return null;
        }
        TreeNode preRoot = new TreeNode(pre[pl]);
        for (int i=il;i<=ir;i++)
        {
            if(in[i]==pre[pl])/*找到in中的根节点*/
            {
                preRoot.left = createTreeByPreInDetail(pre,in,pl+1,pl+i-il,il,i-1);
                preRoot.right = createTreeByPreInDetail(pre,in,pl+i-il+1,pr,i+1,ir);
                if(preRoot.left != null)
                {
                    preRoot.left.father = preRoot;
                }
                if(preRoot.right != null)
                {
                    preRoot.right.father = preRoot;
                }
            }
        }
        return preRoot;
    }

    public void preOrder(TreeNode tree,ArrayList<Integer> preArr)
    {
        if(tree == null)
        {
            return;
        }
        preArr.add(tree.val);
        preOrder(tree.left,preArr);
        preOrder(tree.right,preArr);

    }
    /*剑指offer的第8题，找出中序遍历的下一个节点*/
    public TreeNode getNext(TreeNode pnode)/*给定了其中一个节点*/
    {
        if (pnode == null)
        {
            return null;
        }
        if (pnode.right != null)
        {
            pnode = pnode.right;
            while (pnode.left != null)
            {
                pnode = pnode.left;
            }
            return pnode;
        }
        /*右子树为空父节点未被访问过*/
        if (pnode.right == null && pnode.father.left == pnode)
        {
            return pnode.father;
        }

        if(pnode.right == null)
        {
            pnode = pnode.father;
            while(pnode.father.left != pnode && pnode.father != null)
            {
                pnode = pnode.father;
            }
            if(pnode.father == null)
            {
                return null;
            }

        }
        return pnode.father;
    }
    public static void main(String[] args)
    {
        rebuild_tree re = new rebuild_tree();
        int pre[] = {1,2,4,7,3,5,6,8};
        int in[] = {4,7,2,1,5,3,8,6};
        TreeNode tree = re.createTreeByPreIn(pre,in);

        System.out.println(re.getNext(tree).val);
        ArrayList<Integer> preArr = new ArrayList<>();
        re.preOrder(tree,preArr);
        System.out.println(preArr.toString());
    }
}
