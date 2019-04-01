package model;

import com.sun.istack.internal.Nullable;

public class SimpleNodeFactory {

  @Nullable
  public static Component createNode(int id, @Nullable Component parent) {
    return null == parent
        ? new Root()
        : new Node(id, parent);
  }

}
