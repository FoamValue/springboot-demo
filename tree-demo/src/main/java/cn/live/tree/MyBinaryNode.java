package cn.live.tree;

public class MyBinaryNode<T> {

  public T data; // 数据
  public MyBinaryNode<T> left, right; // 左孩子、右孩子结点

  // 构造结点
  public MyBinaryNode(T data, MyBinaryNode<T> left, MyBinaryNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public MyBinaryNode(T data) {
    this.data = data;
  }

  public String toString() {
    return data.toString();
  }

}
