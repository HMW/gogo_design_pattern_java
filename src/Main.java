import com.sun.tools.javac.util.Assert;
import model.Component;
import model.MindMapModel;
import model.SimpleNodeFactory;

public class Main {

  public static void main(String[] args) {
    testCreateMultipleRoot();
    testInsertMultipleRoot();
    testInsertDuplicateChild();
    testInsertChild();
    testInsertSiblingAndChild();
  }

  private static void testCreateMultipleRoot() {
    MindMapModel mindMapModel = new MindMapModel();
    mindMapModel.createNode("first root", null);
    mindMapModel.createNode("second root", null);
    mindMapModel.saveMindMap();
    Assert.check(mindMapModel.getComponentListSize() == 1);
  }

  private static void testInsertMultipleRoot() {
    MindMapModel mindMapModel = new MindMapModel();
    mindMapModel.createNode("first root", null);
    mindMapModel.insertNode(
        SimpleNodeFactory.createNode(
            mindMapModel.getComponentListSize(),
            "second root",
            null));
    mindMapModel.saveMindMap();
    Assert.check(mindMapModel.getComponentListSize() == 1);
  }

  private static void testInsertDuplicateChild() {
    MindMapModel mindMapModel = new MindMapModel();

    Component root = SimpleNodeFactory.createNode(
        mindMapModel.getComponentListSize(),
        "root",
        null
    );
    mindMapModel.insertNode(root);

    Component sibling1 = SimpleNodeFactory.createNode(
        mindMapModel.getComponentListSize(),
        "sibling1",
        root
    );
    mindMapModel.insertNode(sibling1);
    mindMapModel.insertNode(sibling1);

    mindMapModel.saveMindMap();
    Assert.check(mindMapModel.getComponentListSize() == 2);
  }

  private static void testInsertChild() {
    MindMapModel mindMapModel = new MindMapModel();

    Component root = SimpleNodeFactory.createNode(
        mindMapModel.getComponentListSize(),
        "root",
        null
    );
    mindMapModel.insertNode(root);

    Component sibling1 = SimpleNodeFactory.createNode(
        mindMapModel.getComponentListSize(),
        "sibling1",
        root
    );
    mindMapModel.insertNode(sibling1);

    Component sibling2 = SimpleNodeFactory.createNode(
        mindMapModel.getComponentListSize(),
        "sibling2",
        root
    );
    mindMapModel.insertNode(sibling2);

    mindMapModel.saveMindMap();
    Assert.check(mindMapModel.getComponentListSize() == 3);
  }

  private static void testInsertSiblingAndChild() {
    MindMapModel mindMapModel = new MindMapModel();

    Component root = SimpleNodeFactory.createNode(
        mindMapModel.getComponentListSize(),
        "root",
        null
    );
    mindMapModel.insertNode(root);

    Component sibling1 = SimpleNodeFactory.createNode(
        mindMapModel.getComponentListSize(),
        "sibling1",
        root
    );
    mindMapModel.insertNode(sibling1);

    Component sibling2 = SimpleNodeFactory.createNode(
        mindMapModel.getComponentListSize(),
        "sibling2",
        root
    );
    mindMapModel.insertNode(sibling2);

    Component sib1child1 = SimpleNodeFactory.createNode(
        mindMapModel.getComponentListSize(),
        "sib1child1",
        sibling1
    );
    mindMapModel.insertNode(sib1child1);

    Component sib1child2 = SimpleNodeFactory.createNode(
        mindMapModel.getComponentListSize(),
        "sib1child2",
        sibling1
    );
    mindMapModel.insertNode(sib1child2);

    Component sib2child1 = SimpleNodeFactory.createNode(
        mindMapModel.getComponentListSize(),
        "sib2child1",
        sibling2
    );
    mindMapModel.insertNode(sib2child1);

    mindMapModel.saveMindMap();
    Assert.check(mindMapModel.getComponentListSize() == 6);
  }

}
