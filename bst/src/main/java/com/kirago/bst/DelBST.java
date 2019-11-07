package com.kirago.bst;

/**
* @Description:    二叉查找树删除节点
* @Author:         kirago
* @CreateDate:     2019/11/7 2:13 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class DelBST {

    public Node delNode(Node node,int val) {
        if( node == null) {
            return node;
        }

        int nodeVal = node.getValue();

        Node leftNode = node.getLeftChildren();
        Node rightNode = node.getRightChildren();

        if( val < nodeVal) {
            Node temptNode = delNode(leftNode, val);
            node.setLeftChildren(temptNode);
        }else if(val > nodeVal) {
            Node temtNode = delNode(rightNode, val);
            node.setRightChildren(temtNode);
        }else {
            if(leftNode == null) {
                return rightNode;
            }else if (rightNode == null) {
                return leftNode;
            }

            Node minNode = minNode(rightNode);
            int minNodeVal = minNode.getValue();
            node.setValue(minNodeVal);
            Node tempNode = delNode(rightNode, minNodeVal);
            node.setRightChildren(tempNode);
        }
        return node;

    }

    public Node minNode(Node node) {
        Node leftNode = node.getLeftChildren();
        if(leftNode != null) {
            return minNode(leftNode);
        }
        return node;
    }
}
