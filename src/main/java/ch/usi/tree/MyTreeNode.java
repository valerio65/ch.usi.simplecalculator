package ch.usi.tree;

import java.util.ArrayList;
import java.util.List;

public class MyTreeNode<T>{
    private T data;
    private List<MyTreeNode> children;
    private MyTreeNode parent;

    public MyTreeNode(T data) {
        children = new ArrayList<>();
        parent = null;
        this.data = data;
    }

    public void clear() {
        children.clear();
        parent = null;
        this.data = null;
    }

    public void addChild(MyTreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        MyTreeNode<T> newChild = new MyTreeNode<>(data);
        this.addChild(newChild);
    }

    public void addChildren(List<MyTreeNode> children) {
        for(MyTreeNode t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }


    public MyTreeNode findNode(T data) {
        for(MyTreeNode node : this.getChildren()) {
            if(node.getData().equals(data)){
                return node;
            }
        }
        for(MyTreeNode node : this.getChildren()) {
            MyTreeNode result = node.findNode(data);
            if(result!=null){
                return result;
            }
        }

        return null;
    }


    public List<MyTreeNode> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(MyTreeNode parent) {
        this.parent = parent;
    }

    public MyTreeNode getParent() {
        return parent;
    }

    public void print(){
        for(MyTreeNode node : this.getChildren()) {
            System.out.println(node.getData());
        }
    }
}

