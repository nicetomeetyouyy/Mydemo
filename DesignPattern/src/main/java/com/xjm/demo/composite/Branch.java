package com.xjm.demo.composite;

import java.util.ArrayList;
import java.util.List;
//树枝构件
public class Branch implements Tree {
    private List<Tree> branchs=new ArrayList<Tree>();

    public void add(Tree tree){
        branchs.add(tree);
    }
    public void remove(Tree tree){
        branchs.remove(tree);
    }
    public Tree getChild(int i){
        return  branchs.get(i);
    }
    public void show() {
     System.out.println("我是一根树枝,我身上还有");
        for (Tree t:branchs
             ) {
            t.show();
        }
    }
}
