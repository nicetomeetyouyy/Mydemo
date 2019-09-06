package com.xjm.demo.chain;
//具体处理者角色1

public class ConcreteHandler1 extends Handler {
    @Override
    /**
     * 对请求进行处理，符合条件等我处理请求，不符合的转发请求
     * @param request
     */
    public void handleRequest(int request) {
          if(request==1){
              System.out.println("1号进行了处理");
          }
          else {
              if(getNext()!=null){
                  getNext().handleRequest(request);
              }else {
                  System.out.println("没人处理");
              }
          }
    }
}
