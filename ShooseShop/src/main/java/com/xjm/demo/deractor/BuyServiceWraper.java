package com.xjm.demo.deractor;

import com.xjm.demo.diyshoes.Builder;
import com.xjm.demo.diyshoes.ShoesDiyBuilder;
import com.xjm.demo.service.BuyService;
import com.xjm.demo.service.impl.BuyServiceImpl;
import com.xjm.demo.shoses.Shobox;
import com.xjm.demo.shoses.Shoes;

import java.util.Scanner;

/**
 * 装饰类，装饰buyservice，实现配色选择
 */
public class BuyServiceWraper {
    private BuyService buyService =new BuyServiceImpl(new ShoesDiyBuilder());
    Scanner in=new Scanner(System.in);


    public void showShoes(){
        System.out.println("来自抽象工厂生产的鞋子：");
        buyService.showShoes();
    }

    /**
     * 用户Diy球鞋
     * @return
     */
    public Shoes diyShoes(){
        String [] color=new String[5];
        System.out.println("输入球鞋颜色：");
        color[0]=in.nextLine();
        System.out.println("输入鞋底颜色：");
        color[1]=in.nextLine();
        System.out.println("输入鞋舌颜色：");
        color[2]=in.nextLine();
        System.out.println("输入鞋带颜色：");
        color[3]=in.nextLine();
        System.out.println("输入鞋垫颜色：");
        color[4]=in.nextLine();

        return buyService.diyShoes(color);
    }

    /**
     * 用户diy鞋盒
     * @return
     */
    public Shobox diyShobox(){
        System.out.println("输入鞋盒logo：");
        String logo=in.nextLine();
        System.out.println("输入鞋盒大小：");
        String size=in.nextLine();
        System.out.println("输入鞋盒颜色：");
        String color=in.nextLine();
        return buyService.diyShobox(logo,size,color);
    }

}
