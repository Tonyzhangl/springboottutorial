package com.kirago.bst;

import com.google.gson.Gson;

/**
* @Description:    二叉查找树的查找
* @Author:         kirago
* @CreateDate:     2019/11/6 10:31 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SearchBST {

    public Node searchNode(Node node, int val) {
        if(node == null) {
            return null;
        }
        int nodeVal = node.getValue();
        if(val == nodeVal) {
            return node;

        }else if (val < nodeVal){
              return   this.searchNode(node.getLeftChildren(), val);
        }else {
              return   this.searchNode(node.getRightChildren(), val);
        }
    }

    public static void main(String[] args) {
        int[] vals = {7,5,9,2,11,6};
        Node node = new BuildBST().buildNode(vals);
        Node node1= new SearchBST().searchNode(node, 6);
        System.out.println(new Gson().toJson(node1));
    }
}
