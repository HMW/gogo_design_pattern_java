package model;

import java.util.List;

public abstract class Component {

  public enum Type {
    Root,
    Node
  }

  public int mId;
  public String mDescription;

  public abstract Type getType();

  public abstract void addChild(Component child);

  public abstract boolean removeChild(Component child);

  public abstract void addSibling(Component sibling);

  public abstract boolean removeSibling(Component sibling);

  public abstract Component getParent();

  public abstract List<Component> getChildList();

}
