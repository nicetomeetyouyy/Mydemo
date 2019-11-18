package com.xjm.demo.hash;

public class LinkHash {
    private Object [] table;
    private int size;
    private int num;

    public LinkHash(int size){
        this.size=size;
        table=new Object[size];
        num=0;
    }
    public int hash(int key){
        return key%size;
    }
    public boolean isFull(){
        return num==size;
    }
    public boolean isEmpty(){
        return num==0;
    }
    public void insert(Object data){
        if(isFull()){
            System.out.println("扩展");
            extendTable();
        }
//        System.out.println((int)data);
        int index=hash((int)data);
        while (table[index]!=null){

              index++;
            if(index==size){
                extendTable();
                break;
            }
        }
        table[index]=data;
        num++;
    }
    void extendTable(){
        int n=size<<1;
        Object []old=table;
        table=new   Object[n];
        size=n;
        int len=old.length;
        for(int i=0;i<len;i++){
            if(old[i]!=null){
            insert(old[i]);
        }}
    }
    public int delete(Object data){
        if(isEmpty()){
            return -1;
        }
        int index=hash((int)data);
        while (table[index]!=null){
            if(data.equals(table[index])){
                break;
            }
            index++;
            if(index==size){
                return -1;
            }
        }
        table[index]=null;
        num--;
        return 1;
    }
    public void disPlay(){
        for(int i=0;i<size;i++){
            if(table[i]!=null){
                System.out.println((int)table[i]+"index:"+i);
            }
            else{
                System.out.println(i+"没有元素");
            }

        }
    }
/*    public Object find(Object object){
        int index=hash((int)object);
        Object o=null;
        if (object.equals(table[index])){
            o=table[index];
        }

        return o;
    }*/
}
