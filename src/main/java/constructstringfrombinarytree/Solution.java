package constructstringfrombinarytree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public String tree2str(TreeNode t) {
        return preOrder(t);
    }

    private String preOrder(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if (t == null) {
            sb.append(")");
            return sb.toString();
        }
        sb.append(t.val).append("(");
        preOrder(t.left);
        preOrder(t.right);
        return null;
    }
}
