package com.xjm.demo.abstractfactory;


public class LifeFactoryImp implements LifeFactory{
    /**
     * 使用反射根据传入类名创建具体动物对象
     * @param name
     * @return Animal
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public Object newAnimal(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String animalName="com.xjm.demo.abstractfactory."+name;
        Class animal=Class.forName(animalName);
        return  animal.newInstance();
    }

    /**
     * 使用反射根据传入类名创建具体植物对象
     * @param name
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public Object newPlant(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String plantName="com.xjm.demo.abstractfactory."+name;
        Class plant=Class.forName(plantName);
        return  plant.newInstance();
    }
}
