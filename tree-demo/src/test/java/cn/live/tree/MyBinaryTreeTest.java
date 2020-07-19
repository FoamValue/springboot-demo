package cn.live.tree;

public class MyBinaryTreeTest {

  @SuppressWarnings("unused")
  public static void initTree(MyBinaryTree<String> tree) {
    tree.clear();
    MyBinaryNode<String> root = tree.insert("A");

    MyBinaryNode<String> treeB = tree.insert(root, "B", true);
    MyBinaryNode<String> treeC = tree.insert(root, "C", false);
    MyBinaryNode<String> treeD = tree.insert(treeB, "D", true);
    MyBinaryNode<String> treeE = tree.insert(treeC, "E", true);
    MyBinaryNode<String> treeF = tree.insert(treeC, "F", false);
    MyBinaryNode<String> treeG = tree.insert(treeD, "G", false);
    MyBinaryNode<String> treeH = tree.insert(treeF, "H", true);
  }

  public static void main(String[] args) {

    MyBinaryTree<String> tree = new MyBinaryTree<>();
    initTree(tree);

    System.out.print("先根次序遍历：");
    tree.preorder();

    System.out.print("中根次序遍历：");
    tree.inorder();

    System.out.print("后根次序遍历：");
    tree.postorder();

    System.out.println("结点个数：" + tree.size());
    System.out.println("树的高度：" + tree.height());
    tree.levelorder();
    System.out.println(tree.search("G"));
    System.out.println(tree.contains("G"));
    System.out.println(tree.contains("X"));
  }

}
