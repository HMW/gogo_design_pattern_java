import Utils.UtilsFile;
import com.sun.tools.javac.util.Assert;
import model.Component;
import model.MindMapModel;
import model.SimpleNodeFactory;

import java.io.IOException;

public class Main {

  public static void main(String[] args) {

    // test node create & insert
    testCreateMultipleRoot();
    testInsertMultipleRoot();
    testInsertDuplicateChild();
    testInsertChild();
    testInsertSiblingAndChild();

    // test file IO
    testFileIo();
    testFileIoWithNewLine();
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

  private static void testFileIo() {
    String text = "whoscall number one";

    try {
      UtilsFile.write(text);
      Assert.check(text.equals(UtilsFile.read()));
    } catch (IOException e) {
      System.err.print("e: " + e.getMessage());
    }
  }

  private static void testFileIoWithNewLine() {
    String text = "whoscall\nnumber\none";

    try {
      UtilsFile.write(text);
      String readText = UtilsFile.read();
      System.out.print(readText);
      Assert.check(text.equals(UtilsFile.read()));
    } catch (IOException e) {
      System.err.print("e: " + e.getMessage());
    }
  }

}
