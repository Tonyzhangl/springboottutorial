package com.kirago.bst;
/**
* @Description:    二叉查找树节点
* @Author:         kirago
* @CreateDate:     2019/11/6 6:08 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Node {

    private Integer value;

    private Node leftChildren;

    private Node rightChildren;

    public Node(Integer value) {
        this.value = value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }

    public void setLeftChildren(Node leftChildren) {
        this.leftChildren = leftChildren;
    }

    public void setRightChildren(Node rightChildren) {
        this.rightChildren = rightChildren;
    }

    public Integer getValue() {
        return value;
    }

    public Node getLeftChildren() {
        return leftChildren;
    }

    public Node getRightChildren() {
        return rightChildren;
    }


}
