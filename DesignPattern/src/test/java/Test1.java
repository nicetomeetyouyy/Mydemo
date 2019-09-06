

import com.xjm.demo.abstractfactory.LifeFactory;
import com.xjm.demo.abstractfactory.LifeFactoryImp;
import com.xjm.demo.abstractfactory.LifeInJimei;
import com.xjm.demo.abstractfactory.LifeInXiamen;

import com.xjm.demo.adapter.Adaptee;
import com.xjm.demo.adapter.ObejectAdapter;
import com.xjm.demo.adapter.RequstAdapter;
import com.xjm.demo.adapter.Target;
import com.xjm.demo.bridge.*;
import com.xjm.demo.builder.*;
import com.xjm.demo.factory.ConcreteFactory1;
import com.xjm.demo.factory.ConcreteFactory2;
import com.xjm.demo.proxy.Proxy;
import com.xjm.demo.simplefactory.Factory;
import com.xjm.demo.simplefactory.Product;
import org.junit.Test;
public class Test1 {

    @Test
    public void proxyTest(){
        Proxy proxy=new Proxy();
        proxy.Requset();
    }
    @Test
    /*
     * 测试简单工厂生产类
     */
    public void simpleFactory(){
        Factory factory=new Factory();
        Product product=factory.creteProduct("A");
        product.used();
        Product product2=factory.creteProduct("B");
        product2.used();
    }

    @Test
    /**
     *
     * 测试工厂方法
     */
    public void FactoryTest(){
        com.xjm.demo.factory.Factory factory1=new ConcreteFactory1();
        com.xjm.demo.factory.Factory factory2=new ConcreteFactory2();
        com.xjm.demo.factory.Product p1=factory1.newProduct();
        p1.show();
        com.xjm.demo.factory.Product p2=factory2.newProduct();
        p2.show();
    }
    @Test

    public void abstracFactory() throws Exception{
        LifeFactory lifeFactory=new LifeFactoryImp();

        LifeInXiamen horse= (LifeInXiamen) lifeFactory.newAnimal("Horse");
        LifeInJimei cat= (LifeInJimei) lifeFactory.newAnimal("Cat");
        LifeInJimei  tree= (LifeInJimei) lifeFactory.newPlant("Tree");
        LifeInXiamen flower= (LifeInXiamen) lifeFactory.newPlant("Flowers");
        horse.show();
        cat.show();
        tree.show();
        flower.show();

    }
    @Test
    /**
     * 测试建造者模式
     */
    public void buildTest(){
        LivingRoom livingRoom=new LivingRoom();
        Builder b1= new ConcreteBuilder1();
        Builder b2=new ConcreteBuilder2();
        Manager manager=new Manager();
        manager.serBuilder(b1);
        livingRoom=manager.getLivingRoom();
        System.out.println(livingRoom.getTV()+livingRoom.getWall());
        manager.serBuilder(b2);
        livingRoom=manager.getLivingRoom();
        System.out.println(livingRoom.getTV()+livingRoom.getWall());
    }
    @Test
    /**
     * 类对象适配器测试
     */
    public void classTest(){
        Target t=new RequstAdapter();
        t.request();
    }
    @Test
    /**
     * 对象适配器测试
     */
    public void objectAdapterTest(){
        Adaptee a=new Adaptee();
        Target t=new ObejectAdapter(a);
        t.request();
    }
    @Test
    /**
     * 桥接模式测试
     */
    public void bridgeTest(){
        Color white =new White();
        Color red=new Red();
        Shape circle=new Circle(white);
        circle.draw();
        Shape shape=new Square(red);
        shape.draw();

    }

}
