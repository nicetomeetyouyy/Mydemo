package com.xjm.demo.diyshoes;

import com.xjm.demo.factory.ShoboxFactoryImpl;
import com.xjm.demo.sharepart.InsolePart;
import com.xjm.demo.sharepart.LacePart;
import com.xjm.demo.sharepart.SolePart;
import com.xjm.demo.sharepart.TonguePart;
import com.xjm.demo.shoses.Shobox;
import com.xjm.demo.shoses.Shoes;

/**
 * 建造者模式
 *具体建造者
 */
public class ShoesDiyBuilder extends Builder{
    public ShoesDiyBuilder() {
        shoes=new Shoes();
        shobox=new Shobox();
        shoboxFactory=new ShoboxFactoryImpl();
    }

    @Override
    public void buildColor(String color) {
        shoes.setColor(color);
    }

    @Override
    public void buildeSole(String color) {
        shoes.setSole((SolePart) partFactory.getSolePart(color));
    }

    @Override
    public void buildeInsole(String color) {
        shoes.setInsole((InsolePart) partFactory.getInsolePart(color));
    }

    @Override
    public void buildeLace(String color) {
         shoes.setLace((LacePart) partFactory.getLacePart(color));
    }

    @Override
    public void buildeTongue(String color) {
        shoes.setTongue((TonguePart) partFactory.getTonguePart(color));
    }

    @Override
    public void buildeShobox(String logo, String size, String corlor) {
        Shobox shobox=shoboxFactory.getShobox(size,corlor);
        shobox.setLogo(logo);
    }
}
