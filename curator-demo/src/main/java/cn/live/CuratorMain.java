package cn.live;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class CuratorMain {

  private static CuratorFramework getZkClient() {
    RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 5);
    CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
        .connectString("127.0.0.1:2181").retryPolicy(retryPolicy).build();
    curatorFramework.start();
    return curatorFramework;
  }

  

  public static void createPersistentNode(String path) {
    try {
      if (registeredPathSet.contains(path) || getZkClient().checkExists().forPath(path) != null) {
        System.out.println(String.format("节点已经存在，节点为:[{}]", path));
      } else {
        getZkClient().create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
            .forPath(path);
        System.out.println(String.format("节点创建成功，节点为:[{}]", path));
      }
      registeredPathSet.add(path);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static List<String> getChildrenNodes(String path) {
    List<String> result = null;
    try {
      result = getZkClient().getChildren().forPath(path);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  private static Set<String> registeredPathSet = ConcurrentHashMap.newKeySet();

  public static void removeChildrenNodes(String path) {
    try {
      getZkClient()
        .delete()
        .deletingChildrenIfNeeded()
        .forPath(path);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws InterruptedException {

    System.out.println(getChildrenNodes("/my-rpc"));
    removeChildrenNodes("/my-rpc");
    System.out.println(getChildrenNodes("/my-rpc"));

  }

}
