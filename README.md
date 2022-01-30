# TreeNode
> 用于leetcode刷题的二叉树工具类

tools目录下放的是一些依赖类

test.java是测试程序，可以参考其中的用法

## TreeNode

TreeNode就是二叉树的节点类，内置命令行打印输出（使用重写toString，直接打印节点即可，参见测试程序）

## TreeUtils

TreeUtils是二叉树的工具类

mkTree: 可将leetcode测试用例的字符串直接转化为二叉树

mkTreeFull: 是mkTree的旧版本，只能转化完全二叉树的字符串（也就是说null需要全部打出，哪怕是null的子节点也需要打印出null）

saveImage：将二叉树保存成png图片，存放于项目的根目录（懒得写了），传入的二叉树可以是字符串形式, 也可以是TreeNode形式，同时需要传入文件名（不带扩展名）

showImage: 将二叉树通过java原生打印输出，传入参数参考saveImage