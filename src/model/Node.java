package model;

import com.sun.istack.internal.NotNull;

public class Node extends Composite {

  public Node(int id, @NotNull String description, @NotNull Component parent) {
    mId = id;
    mDescription = description;
    mParent = parent;
    mType = Type.Node;
  }

}
