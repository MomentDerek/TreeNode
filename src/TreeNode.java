/**
 * @author Moment, Blankj(打印函数作者), 细水长流(图片显示作者）
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    private StringBuilder stringBuilder = new StringBuilder();

    public String toString() {
        createString();
        return stringBuilder.toString();
    }

    private final String SPACE = "        ";

    /**
     * 创建TreeNode的打印字符串
     */
    public void createString() {
        stringBuilder = new StringBuilder();
        createNodeString(this,0);
    }

    /**
     * 递归打印节点到stringBuilder
     * @param node 节点
     * @param deep 当前的层数
     */
    private void createNodeString(TreeNode node, int deep) {
        if (node == null) {
            insertSpace(deep);
            stringBuilder.append("#").append("\n");
            return;
        }
        createNodeString(node.right, deep + 1);
        insertSpace(deep);
        insertNodeString(node.val);
        createNodeString(node.left, deep + 1);
    }

    /**
     * 将一定数量的空格加入stringBuilder
     * @param count 空格数
     */
    private void insertSpace(int count) {
        for (int i = 0; i < count; i++) {
            stringBuilder.append(SPACE);
        }
    }

    /**
     * 将一个节点打印到stringBuilder
     * @param val 节点值
     */
    private void insertNodeString(int val) {
        StringBuilder res = new StringBuilder(val + " <");
        int spaceNum = SPACE.length() - res.length();
        res.append(" ".repeat(Math.max(0, spaceNum)));
        stringBuilder.append(res).append("\n");
    }


}
