package com.xjm.demo;

import static org.junit.Assert.assertTrue;

import com.xjm.demo.thread.Addsome;
import com.xjm.demo.thread.MyThead;
import com.xjm.demo.thread.MyThead4;
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
    public void shouldAnswerWithTrue()
    {
        Addsome addsome=new Addsome();
        Thread t1=new MyThead(addsome);
        Thread t2=new MyThead4(addsome);
        t1.start();
        t2.start();

    }
}
