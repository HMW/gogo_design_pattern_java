package model;

import com.sun.istack.internal.NotNull;

public class Root extends Composite {

  public Root(@NotNull String description) {
    mId = 0;
    mDescription = description;
    mParent = null;
    mType = Type.Root;
  }

}
