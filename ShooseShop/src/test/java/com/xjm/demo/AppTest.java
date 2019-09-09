package com.xjm.demo;

import static org.junit.Assert.assertTrue;

import com.xjm.demo.diyshoes.Builder;
import com.xjm.demo.diyshoes.ShoesDiyBuilder;
import com.xjm.demo.factory.ShoboxFactory;
import com.xjm.demo.factory.ShoboxFactoryImpl;
import com.xjm.demo.shoses.Shobox;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test1(){
        ShoboxFactory shoboxFactory=new ShoboxFactoryImpl();
        Shobox shobox=shoboxFactory.getShobox("20","红色");
        System.out.println(shobox.toString());
        Builder builder=new ShoesDiyBuilder();
        builder.buildeShobox("dad","d a","dada");
        shobox=builder.getShobox();
        System.out.println(shobox.toString());

    }
}
