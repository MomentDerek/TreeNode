public class test {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.mkTree("[8,0,31,null,6,28,45,1,7,25,30,32,49,null,4,null,null,9,26,29,null,null,42,47,null,2,5,null,12,null,27,null,null,41,43,46,48,null,3,null,null,10,19]");
        //命令行打印
        System.out.println(root);
        //打印图像
        TreeUtils.showImage(root);
        //保存图像
        TreeUtils.saveImage(root,"input");
    }
}
