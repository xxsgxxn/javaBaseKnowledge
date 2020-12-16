package Jzoffer;

import java.util.LinkedList;
import java.util.Queue;

public class subStructTree {
    public boolean isSubTree(TreeNode root,TreeNode b)
    {
        /*b要为root的子结构，则对于root中的某一个节点a,a的左右子树分别与b的相等*/
        boolean res = false;
        if (root == null || b == null)/*空树不是任何树的子结构*/
        {
            return false;
        }
        if (root.val == b.val)/*比较子树是否相等*/
        {
            res = isSubTreeab(root,b);

        }
        if (!res)
        {
            res = isSubTree(root.left,b);
        }
        if (!res)
        {
            res = isSubTree(root.right,b);
        }
        return res;

    }
    public boolean isSubTreeab(TreeNode a,TreeNode b)
    {
        if (b == null)
        {
            return true;
        }
        if (a == null)
        {
            return false;
        }
        if (a.val != b.val)
        {
            return false;
        }
        return isSubTreeab(a.left,b.right)&&isSubTreeab(a.right,b.right);
    }

    /*对称二叉树的递归版本*/
    public boolean isSymmetricalTreeRecur(TreeNode root)
    {
        if (root == null || (root.left== null && root.right == null))
        {
            return true;
        }
        return isSymmetricalTreeSub(root.left,root.right);
    }
    private boolean isSymmetricalTreeSub(TreeNode root1,TreeNode root2)
    {
        if (root1 == null && root2 == null)
        {
            return true;
        }
        if (root1 == null || root2 == null)
        {
            return false;
        }
        if (root1.val != root2.val)
        {
            return false;
        }
        return isSymmetricalTreeSub(root1.left,root2.right)&&isSymmetricalTreeSub(root1.right,root2.left);
    }

    public boolean isSymmetricalTree(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root.left);
        q2.offer(root.right);
        while (q1 != null && q2 != null)
        {
            TreeNode p1 = q1.poll();
            TreeNode p2 = q2.poll();
            if (p1 == null && p2 == null) continue;
            if (p1 == null || p2 == null) return false;
            if (p1.val != p2.val) return false;

            q1.offer(p1.left);
            q2.offer(p2.right);

            q1.offer(p2.left);
            q2.offer(p1.right);
        }
        return true;
    }

    public void MirrorTreeRecur(TreeNode root)
    {
        if (root == null || (root.left == null && root.right == null))
        {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        MirrorTreeRecur(root.left);
        MirrorTreeRecur(root.right);
    }
    public void MirrorTreePre(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        LinkedList<TreeNode> s = new LinkedList<>();
        while (root != null || !s.isEmpty())
        {
            while (root != null)
            {
                s.push(root);
                if (root.left != null || root.right != null)
                {
                    TreeNode temp = root.left;
                    root.left = root.right;
                    root.right = temp;
                }
                root = root.left;
            }
            if (!s.isEmpty())
            {
                root = s.pop();
                root = root.right;
            }
        }

    }
    public void MirrorTreeLevel(TreeNode root)
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
            if (root.left != null || root.right != null)
            {
                TreeNode temp = p.left;
                p.left = p.right;
                p.right = temp;
            }
            if (p.left != null) q.offer(p.left);
            if (p.right != null) q.offer(p.right);
        }
    }
}
