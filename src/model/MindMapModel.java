package model;

import com.sun.istack.internal.NotNull;
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

    // can have only one root
    if (mComponentList.size() > 0 && Component.Type.Root == node.getType()) {
      return;
    }

    // node duplicate
    if (node.mId < mComponentList.size()) {
      return;
    }

    mComponentList.add(node);

    if (Component.Type.Node == node.getType()) {
      node.getParent().addChild(node);
    }
  }

  /**
   * Save mind map as following format.
   * id "description" child(s)
   * 0 ”Computer” 2 7
   * 1 ”windows” 5 6
   * 2 ”OS” 1 3 4
   * 3 ”IOS”
   * 4 ”Linux”
   * 5 ”DirectX”
   * 6 ”Microsoft Office”
   * 7 ” Network” 8 9
   * 8 ” Wireless”
   * 9 ”Cable”
   */
  public void saveMindMap() {
    // TODO output current map to a text file
    StringBuilder result = new StringBuilder();
    for (Component component : mComponentList) {
      result.append(component.mId);
      result.append(" \"");
      result.append(component.mDescription);
      result.append("\"");
      for (Component child : component.getChildList()) {
        result.append(" ");
        result.append(child.mId);
      }
      result.append("\n");
    }
    System.out.println(result.toString());
  }

  /**
   * Create the root node on map.
   */
  public void createNode(@NotNull String description, @Nullable Component parent) {
    if (null == parent && mComponentList.size() != 0) {
      return;
    }

    mComponentList.add(SimpleNodeFactory.createNode(mComponentList.size(), description, parent));
  }

  public List<Component> getComponentList() {
    return mComponentList;
  }

  public int getComponentListSize() {
    return mComponentList.size();
  }

}
