package com.xjm.demo.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介实现者
 */
public class ConcreteMediator implements Mediator {
    private List<Collcague> list=new ArrayList<Collcague>();
    public void register(Collcague collcague) {
       if(!list.contains(collcague)) {
           list.add(collcague);
       }
    }

    public void relay(String message,Collcague collcague) {
      for(Collcague c:list){
          if(!c.equals(collcague)){
              c.receive(message);
          }
      }
    }
}
