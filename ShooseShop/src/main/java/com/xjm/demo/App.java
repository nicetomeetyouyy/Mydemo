package com.xjm.demo;

import com.xjm.demo.facade.Facade;
import com.xjm.demo.shoses.Shobox;
import com.xjm.demo.shoses.Shoes;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Facade facade=new Facade();
        Scanner in=new Scanner(System.in);
        System.out.println( "欢迎来到球鞋购物" );
        boolean flag=true;
        while (flag){
            System.out.println("1.展示工厂球鞋");
            System.out.println("2.DIY你的球鞋");
            System.out.println("3.DIY鞋盒");
            System.out.println("4.购物车操作");
            System.out.println("5.退出");
            int num =in.nextInt();
            switch (num){
                case 1:
                    facade.showShoes();
                    break;
                case 2:
                    Shoes shoes=facade.diyShoes();
                    break;
                case 3:
                    Shobox shobox=facade.diyShobox();
                    break;
                case  4:
                    facade.showCart();
                    break;
                case 5:
                    flag=false;
                    facade.deleteCart();
                    break;
                    default:break;
            }
        }
    }
}
