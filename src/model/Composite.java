package model;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {

  @Nullable
  protected Component mParent;
  protected List<Component> mChildList = new ArrayList<>();
  protected Type mType;

  @Override
  public Type getType() {
    return mType;
  }

  @Override
  public void addChild(Component child) {
    mChildList.add(child);
  }

  @Override
  public boolean removeChild(Component child) {
    return mChildList.remove(child);
  }

  @Override
  public void addSibling(Component sibling) {
    if (Type.Root == mType || null == mParent) {
      return;
    }

    mParent.addChild(sibling);
  }

  @Override
  public boolean removeSibling(Component sibling) {
    if (Type.Root == mType || null == mParent) {
      return false;
    }

    return mParent.removeChild(sibling);
  }

  @Override
  @Nullable
  public Component getParent() {
    return mParent;
  }

  @Override
  public List<Component> getChildList() {
    return mChildList;
  }
}
