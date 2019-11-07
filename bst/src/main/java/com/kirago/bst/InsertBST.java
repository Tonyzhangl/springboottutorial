package com.kirago.bst;

/**
* @Description:    二叉查找树的插入
* @Author:         kirago
* @CreateDate:     2019/11/7 9:19 AM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class InsertBST {

    public void insertNode(Node node, int val) {
        if(node == null) {
            node = new Node(val);
        }

        if (val < node.getValue()) {
            Node leftNode = node.getLeftChildren();
            if(leftNode == null) {
                node.setLeftChildren(new Node(val));
            }else {
                this.insertNode(leftNode, val);
            }
        }else if(val > node.getValue()){
            Node rightNode = node.getRightChildren();
            if(rightNode == null) {
                node.setRightChildren(new Node(val));
            }else {
                this.insertNode(rightNode, val);
            }
        }else{
            // 如果val相等时则根据业务做处理
            System.out.println("节点值相等时做业务逻辑处理");
        }
    }
}
