package ch.usi.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyTreeNodeTest {

    @Test
    public void testFindNothing(){
        // cannot find the elemnt
        MyTreeNode<Integer> tree = new MyTreeNode<>(0);
        MyTreeNode expected = null;
        MyTreeNode actual= tree.findNode(10);
        assertEquals(expected,actual);
    }

    @Test
    public void testFindSomenthing(){
        // find the elemnt
        MyTreeNode<Integer> tree = new MyTreeNode<>(0);
        MyTreeNode<Integer> node = new MyTreeNode<>(10);
        tree.addChild(node);
        MyTreeNode expected = node;
        MyTreeNode actual= tree.findNode(10);
        assertEquals(expected,actual);
    }


    @Test
    public void test3(){
        MyTreeNode<Integer> tree = new MyTreeNode<>(0);
        MyTreeNode<Integer> nodeChild = new MyTreeNode<>(10);
        MyTreeNode<Integer> nodeGrandChild = new MyTreeNode<>(5);
        nodeChild.addChild(nodeGrandChild);
        tree.addChild(nodeChild);
        MyTreeNode expected = nodeGrandChild;
        MyTreeNode actual= tree.findNode(5);
        assertEquals(expected,actual);
    }

    @Test
    public void test4(){
        MyTreeNode<Integer> tree = new MyTreeNode<>(0);
        MyTreeNode<Integer> nodeChild = new MyTreeNode<>(10);
        MyTreeNode<Integer> nodeGrandChild = new MyTreeNode<>(3);
        MyTreeNode<Integer> nodeGrandChild2 = new MyTreeNode<>(5);
        nodeChild.addChild(nodeGrandChild);
        nodeChild.addChild(nodeGrandChild2);
        tree.addChild(nodeChild);
        MyTreeNode expected = null;
        MyTreeNode actual= tree.findNode(2);
        assertEquals(expected,actual);
    }


}