package model;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MindMapModel {

  private List<Component> mComponentList = new ArrayList<>();

  public void createMindMap() {
    // TODO TBD
  }

  /**
   * Insert a new node to current map.
   */
  public void insertNode(@Nullable Component node) {
    if (null == node) {
      return;
    }

    if (mComponentList.size() == 0) {
      createNode(node.getParent());
    } else {
      if (Component.Type.Root != node.getType()) {
        node.getParent().addChild(node);
      }
    }
  }

  public void saveMindMap() {
    // TODO output current map to a text file
  }

  /**
   * Create the root node on map.
   */
  public void createNode(@Nullable Component parent) {
    if (null == parent && mComponentList.size() != 0) {
      return;
    }

    mComponentList.add(SimpleNodeFactory.createNode(mComponentList.size(), parent));
  }

  public List<Component> getComponentList() {
    return mComponentList;
  }

  public int getComponentListSize() {
    return mComponentList.size();
  }

}
