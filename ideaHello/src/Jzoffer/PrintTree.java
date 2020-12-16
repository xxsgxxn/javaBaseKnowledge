package Jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintTree {
    /*从上到下打印二叉树不分行*/
    public void printTreeFromTtoBnoRow(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty())
        {
            TreeNode p = q.poll();
            System.out.print(p.val + " ");
            if (p.left != null){
                q.offer(p.left);
            }
            if (p.right != null)
            {
                q.offer(p.right);
            }
        }
    }
    /*从上到下打印二叉树分行*/
    public void printTreeFromTtoBrow(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int curlevel = 1;/*当前层的节点*/
        int nextlevel = 0;/*下一层的节点*/
        while (!q.isEmpty())
        {
            TreeNode p = q.poll();
            System.out.print(p.val + " ");
            curlevel--;
            if (p.left != null){
                q.offer(p.left);
                nextlevel++;
            }
            if (p.right != null)
            {
                q.offer(p.right);
                nextlevel++;
            }
            if (curlevel == 0)
            {
                System.out.println();
                curlevel = nextlevel;
                nextlevel = 0;
            }

        }

        /*第二种，利用queue的size一次性将同一层的节点打印完
        * */
        while (!q.isEmpty())
        {
            int nsize = q.size();
            for (int i = 0;i < nsize;i++)
            {
                TreeNode p1 = q.poll();
                System.out.print(p1.val + " ");
                if (p1.left != null){
                    q.offer(p1.left);
                }
                if (p1.right != null)
                {
                    q.offer(p1.right);
                }
            }
            System.out.println();
        }

    }
    /*从上到下Z字形打印二叉树
    * 奇数层从左至右
    * 偶数层是从右向左*/
    public void printTreeFromTtoBz(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        LinkedList<TreeNode> stackOdd = new LinkedList<>();
        LinkedList<TreeNode> stackEven = new LinkedList<>();
        stackOdd.push(root);
        while (!stackOdd.isEmpty() || !stackEven.isEmpty()) {
            if (!stackOdd.isEmpty()) {
                while (!stackOdd.isEmpty()) {
                    TreeNode p = stackOdd.pop();
                    System.out.print(p.val + " ");
                    if (p.left != null) {
                        stackEven.push(p.left);
                    }
                    if (p.right != null) {
                        stackEven.push(p.right);
                    }
                }
            } else {
                while (!stackEven.isEmpty()) {
                    TreeNode p = stackEven.pop();
                    System.out.print(p.val + " ");
                    if (p.right != null) {
                        stackOdd.push(p.right);
                    }
                    if (p.left != null) {
                        stackOdd.push(p.left);
                    }
                }
            }
            System.out.println();
        }
    }


    /*判断数组是否是二叉搜索树的后序遍历序列*/

    public boolean isTreeHou(int[] arr)
    {
        if (arr == null || arr.length == 0)
        {
            return false;
        }
        return isTreeHoube(arr,0,arr.length-1);

    }
    private boolean isTreeHoube(int[] arr,int begin,int end)
    {
        if (begin >= end) return true;
        int rootval = arr[end];
        int boundary = begin;
        int i = begin;
        while (i < end && arr[i] < rootval){
            i++;
        }
        /*找到分界点*
        /
         */
        boundary = i;
        while (i<end)
        {
            if (arr[i] < rootval)/*右子树中存在比根节点小的，不是二叉搜索树*/
            {
                return false;
            }
        }
        /*左右子树都是二叉搜索树*/
        return isTreeHoube(arr,begin,boundary-1)&&isTreeHoube(arr,boundary,end-1);
    }


    /*在二叉树中寻找和为key的路径，必须从根到叶子*/
    ArrayList<ArrayList<TreeNode>> isSumPathInTree(TreeNode root,int key)
    {
        if (root == null)
        {
            return null;
        }
        ArrayList<ArrayList<TreeNode>> res= new ArrayList<>();
        ArrayList<TreeNode> path = new ArrayList<>();
        findPathOfKey(root,key,res,path);
        return res;
    }
    private void findPathOfKey(TreeNode root,int key,ArrayList<ArrayList<TreeNode>>res,ArrayList<TreeNode> path)
    {
        if (root == null)
        {
            return;
        }
        path.add(root);
        if (root.left == null && root.left == null && root.val == key)
        {
            res.add(path);
        }
        findPathOfKey(root.left,key-root.val,res,path);
        findPathOfKey(root.right,key-root.val,res,path);
        path.remove(path.size()-1);
    }


    /*将二叉搜索树变为有序双向链表，得用中序遍历*/
    public void transTreetoListNrecur(TreeNode root)/*非递归*/
    {
        if (root == null)
        {
            return;
        }
        LinkedList<TreeNode> s = new LinkedList<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null || !s.isEmpty())
        {
            while (cur != null)
            {
                s.push(cur);
                cur = cur.left;
            }
            if (!s.isEmpty())
            {
                cur = s.pop();
                cur.left = pre;
                if (pre != null)
                {
                    pre.right = cur;
                }
                cur = cur.right;
            }
        }
    }

    /*递归实现*/
    public void transTreetoListRecur(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        TreeNode pre = null;
        transTreetoListRecurPre(root,pre);

    }
    private void transTreetoListRecurPre(TreeNode root,TreeNode pre)
    {
        if (root == null) return;
        transTreetoListRecurPre(root.left,pre);
        root.left = pre;
        if (pre != null)
        {
            pre.right = root;
        }
        pre = root;
        transTreetoListRecurPre(root.right,pre);

    }



    /*二叉树的序列化与反序列化，都采用前序的方法来进行，将空指针的序列用#
    * 代替*
    */
    public void transTreetoSeq(TreeNode root)
    {
        StringBuilder seq = new StringBuilder();
        transTreetoSeqPre(root,seq);
    }
    private void transTreetoSeqPre(TreeNode root,StringBuilder seq)
    {
        if (root == null)
        {
            seq.append("#");
            return;
        }
        seq.append(root.val);
        transTreetoSeqPre(root.left,seq);
        transTreetoSeqPre(root.right,seq);
    }

    /*反序列化二叉树*
    也采用前序的顺序进行，当遇到#时证明是空节点，直接返回就可
     */
    int index = -1;
    public TreeNode transSeqtoTree(StringBuilder seq)
    {
        TreeNode root = transSeqtoTreePre(seq);
        return root;
    }
    private TreeNode transSeqtoTreePre(StringBuilder seq1)
    {
        index++;
        if (seq1.charAt(index) == '#'){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(String.valueOf(seq1.charAt(index))));
        root.left = transSeqtoTreePre(seq1);
        root.right = transSeqtoTreePre(seq1);
        return root;
    }


}
