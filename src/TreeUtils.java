import tools.DrawBinaryTree;

import java.util.LinkedList;

public class TreeUtils {

    //测试输入：String str = "[3,9,20,null,null,15,7]";
    public static TreeNode mkTreeFull(String str) {
        int[] arr = StrToIntArray(str);
        //先将输入的Integer数组转化为TreeNode数组
        TreeNode[] nodes = new TreeNode[arr.length + 1];
        for (int i = 1; i < nodes.length; i++) {
            if (arr[i - 1] != Integer.MAX_VALUE) {
                nodes[i] = new TreeNode(arr[i - 1]);
            } else {
                nodes[i] = null;
            }
        }
        //临时root
        TreeNode node;
        //注意，这里如果是小于等于，则表示要遍历非完美树的最后一层，需要对node数组进行下标判断的操作
        for (int i = 1; i <= nodes.length / 2; i++) {
            node = nodes[i];
            if (node == null) continue;
            node.left = 2 * i < nodes.length ? nodes[2 * i] : null;
            node.right = 2 * i + 1 < nodes.length ? nodes[2 * i + 1] : null;
        }
        return nodes[1];
    }

    //测试输入：String str = "[3,9,20,null,null,15,7]";
    public static TreeNode mkTree(String str) {
        Integer[] arr = StrToIntegerArray(str);
        //先将输入的Integer数组转化为TreeNode数组
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < nodes.length; i++) {
            if (arr[i] != null) {
                nodes[i] = new TreeNode(arr[i]);
            } else {
                nodes[i] = null;
            }
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(nodes[0]);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode root = queue.poll();
            assert root != null;
            //处理左子节点
            TreeNode leftNode = nodes[i];
            if (leftNode != null) queue.offer(leftNode);
            root.left = leftNode;
            i++;
            //处理右子节点
            TreeNode rightNode = nodes[i];
            if (rightNode != null) queue.offer(rightNode);
            root.right = rightNode;
        }
        return nodes[0];
    }

    //测试代码：String str = "[3,9,20,null,null,15,7]";
    //输出：int []arr = {3, 9, 20, Integer.MAX_VALUE, Integer.MAX_VALUE, 15, 7};
    private static int[] StrToIntArray(String str) {
        str = str.substring(1, str.length() - 1);
        String[] valueChars = str.split(",");
        int[] arr = new int[valueChars.length];
        try {
            for (int i = 0; i < arr.length; i++) {
                if (valueChars[i].equals("null")) {
                    arr[i] = Integer.MAX_VALUE;
                } else {
                    arr[i] = Integer.parseInt(valueChars[i]);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("StrToIntArray Fail：字符转换为Integer失败，请检查输入字符");
        }
        return arr;
    }

    //测试代码：String str = "[3,9,20,null,null,15,7]";
    //输出：int []arr = {3, 9, 20, Integer.MAX_VALUE, Integer.MAX_VALUE, 15, 7};
    private static Integer[] StrToIntegerArray(String str) {
        str = str.substring(1, str.length() - 1);
        String[] valueChars = str.split(",");
        Integer[] arr = new Integer[valueChars.length];
        try {
            for (int i = 0; i < arr.length; i++) {
                if (valueChars[i].equals("null")) {
                    arr[i] = null;
                } else {
                    arr[i] = Integer.parseInt(valueChars[i]);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("StrToIntArray Fail：字符转换为Integer失败，请检查输入字符");
        }
        return arr;
    }

    private static void drawWalk(TreeNode node) {
        if (node.left != null) {
            DrawBinaryTree.getInstance().addEdge(node.val, node.left.val);
            drawWalk(node.left);
        }
        if (node.right != null) {
            DrawBinaryTree.getInstance().addEdge(node.val, node.right.val);
            drawWalk(node.right);
        }
    }

    public static void saveImage(TreeNode root, String fileName) {
        DrawBinaryTree.empty();
        drawWalk(root);
        DrawBinaryTree.saveImage(fileName);
    }

    public static void saveImage(String rootStr, String fileName) {
        DrawBinaryTree.empty();
        TreeNode root = mkTree(rootStr);
        drawWalk(root);
        DrawBinaryTree.saveImage(fileName);
    }

    public static void showImage(TreeNode root) {
        DrawBinaryTree.empty();
        drawWalk(root);
        DrawBinaryTree.showImage();
    }

    public static void showImage(String rootStr) {
        DrawBinaryTree.empty();
        TreeNode root = mkTree(rootStr);
        drawWalk(root);
        DrawBinaryTree.showImage();
    }
}
