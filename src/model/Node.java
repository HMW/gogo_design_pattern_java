package model;

public class Node extends Composite {

  public Node(int id, Component parent) {
    mId = id;
    mParent = parent;
    mType = Type.Node;
  }

}
