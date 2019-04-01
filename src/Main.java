import com.sun.tools.javac.util.Assert;
import model.MindMapModel;
import model.SimpleNodeFactory;

public class Main {

  public static void main(String[] args) {
    testCreateMultipleRoot();
    testInsertMultipleRoot();
  }

  private static void testCreateMultipleRoot() {
    MindMapModel mindMapModel = new MindMapModel();
    mindMapModel.createNode(null);
    mindMapModel.createNode(null);
    mindMapModel.saveMindMap();
    Assert.check(mindMapModel.getComponentListSize() == 1);
  }

  private static void testInsertMultipleRoot() {
    MindMapModel mindMapModel = new MindMapModel();
    mindMapModel.createNode(null);
    mindMapModel.insertNode(
        SimpleNodeFactory.createNode(
            mindMapModel.getComponentListSize(),
            null));
    mindMapModel.saveMindMap();
    Assert.check(mindMapModel.getComponentListSize() == 1);
  }



}
