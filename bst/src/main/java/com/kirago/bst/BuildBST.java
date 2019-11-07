package com.kirago.bst;

import com.google.gson.Gson;

/**
* @Description:    二叉查找树的创建
* @Author:         kirago
* @CreateDate:     2019/11/6 6:13 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class BuildBST {

    private Node rootNode = null;

    public Node buildNode(int[] vals) {
        for(int val: vals) {
            this.assemable(rootNode ,val);
        }
        return rootNode;
    }

    public void assemable(Node node,int val) {
        if(node == null) {
            rootNode = new Node(val);
        }else {
            if (val < node.getValue()) {
                Node leftNode = node.getLeftChildren();
                if (leftNode == null) {
                    node.setLeftChildren(new Node(val));
                } else {
                    this.assemable(node.getLeftChildren(), val);
                }
            } else {
                Node rightNode = node.getRightChildren();
                if (rightNode == null) {
                    node.setRightChildren(new Node(val));
                } else {
                    this.assemable(node.getRightChildren(), val);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] vals = {7,5,9,2,11,6};
        Node node = new BuildBST().buildNode(vals);
        System.out.println(new Gson().toJson(node));
    }
}
