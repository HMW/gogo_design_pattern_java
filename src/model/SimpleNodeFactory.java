package model;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public class SimpleNodeFactory {

  @Nullable
  public static Component createNode(int id, @NotNull String description, @Nullable Component parent) {
    return null == parent
        ? new Root(description)
        : new Node(id, description, parent);
  }

}
