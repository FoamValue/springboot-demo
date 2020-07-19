package cn.live.tree;

import java.util.concurrent.ConcurrentLinkedQueue;

public class MyBinaryTree<T> {

  public MyBinaryNode<T> root;

  // 默认构造器
  public MyBinaryTree() {
    root = null;
  }

  /**
   * 是否为空二叉树
   * 
   * @return
   */
  public boolean isEmpty() {
    return root == null;
  }
  
  /**
   * 二叉树的结点个数
   * 
   * @return
   */
  public int size() {
    return size(this.root);
  }
  
  private int size(MyBinaryNode<T> p) {
    if (p == null)
      return 0;
    // 后根遍历
    int l = size(p.left);
    int r = size(p.right);
    return l + r + 1;
  }
  
  /**
   * 二叉树的高度
   * 
   * @return
   */
  public int height() {
    return height(this.root);
  }

  private int height(MyBinaryNode<T> p) {
    if (p == null)
      return 0;
    int l = height(p.left);
    int r = height(p.right);
    if (l == 0 && r == 0)
      return 1;
    if (l > r)
      return ++l;
    else
      return ++r;
  }
  
  /**
   * 输出先根次序遍历序列
   */
  public void preorder() {
    preorder(this.root);
    System.out.println();
  }
  
  private void preorder(MyBinaryNode<T> p) {
    if (p != null) {
      System.out.print(p.data.toString() + " ");
      // 按先根次序遍历 p 的左子树
      preorder(p.left);
      // 按先根次序遍历 p 的右子树
      preorder(p.right);
    }
  }
  
  /**
   * 输出中根次序遍历序列
   */
  public void inorder() {
    inorder(this.root);
    System.out.println();
  }
  
  private void inorder(MyBinaryNode<T> p) {
    if (p != null) {
      inorder(p.left);
      System.out.print(p.data.toString() + " ");
      inorder(p.right);
    }
  }
  
  /**
   * 输出后根次序遍历序列
   */
  public void postorder() {
    postorder(this.root);
    System.out.println();
  }
  
  private void postorder(MyBinaryNode<T> p) {
    if (p != null) {
      postorder(p.left);
      postorder(p.right);
      System.out.print(p.data.toString() + " ");
    }
  }
  
  
  /**
   * 输出层次遍历序列
   */
  public void levelorder() {
    System.out.println("层次遍历：   ");
    ConcurrentLinkedQueue<MyBinaryNode<T>> que = new ConcurrentLinkedQueue<MyBinaryNode<T>>();
    MyBinaryNode<T> p = this.root;
    while(p != null) {
      System.out.print(p.data + " ");
      if (p.left != null)
          que.add(p.left);
      if(p.right != null)
          que.add(p.right);
      p = que.poll();
    }
    System.out.println();
  }

  /**
   * 插入元素x作为根结点并返回
   * 
   * @param x
   * @return
   */
  public MyBinaryNode<T> insert(T x) {
    return this.root = new MyBinaryNode<T>(x, this.root, null);
  }

  /**
   * 插入x作为p的左/右孩子
   * 
   * @param p
   * @param x
   * @param leftChild
   * @return
   */
  public MyBinaryNode<T> insert(MyBinaryNode<T> parent, T x, boolean leftChild) {
    /**
     * 创建X结点作为 parent 的左孩子，parent 的原左孩子作为X结点的左孩子。 
     * 创建Y结点作为 parent 的右孩子，parent 的原右孩子作为Y结点的右孩子。
     */
    if (x == null)
      return null;
    if (leftChild)
      return parent.left = new MyBinaryNode<T>(x, parent.left, null);
    else
      return parent.right = new MyBinaryNode<T>(x, null, parent.right);
  }

  /**
   * 删除 parent 结点的左/右孩子
   * 
   * @param parent
   * @param leftChild
   */
  public void remove(MyBinaryNode<T> parent, boolean leftChild) {
    if (parent == null)
      throw new NullPointerException();
    if (leftChild)
      parent.left = null;
    else
      parent.right = null;
  }

  /**
   * 删除二叉树的所有结点
   */
  public void clear() {
    this.root = null;
  }
  
  /**
   * 查找并返回关键字为 Key 的结点
   * @param key
   * @return
   */
  public MyBinaryNode<T> search(T key) {
    return search(this.root, key);
  }
  
  private MyBinaryNode<T> search(MyBinaryNode<T> p, T key) {
    if (p == null)
      return null;
    if (p.data.equals(key))
      return p;
    MyBinaryNode<T> l = search(p.left, key);
    if (l != null)
      return l;
    MyBinaryNode<T> r = search(p.right, key);
    if (r != null)
      return r;
    return null;
  }
  
  /**
   * 判断是否包含关键字为 key 的元素
   * 
   * @param key
   * @return
   */
  public boolean contains(T key) {
    return search(this.root, key) != null;
  }
  
  /**
   * 返回关键字为 key 结点所在的层次
   * 
   * @param key
   * @return
   */
  public int level(T key) {
    return level(this.root, key);
  }
  
  private int level(MyBinaryNode<T> p, T key) {
    if (p == null)
      return 0;
    if (p.data.equals(key)) return 1;
    int l = level(p.left, key);
    int r = level(p.right, key);
    if (l == 0 && r == 0)
      return 0;
    if (l > r)
      return ++l;
    else
      return ++r;
  }

}
