package com.xjm.java;

import static org.junit.Assert.assertTrue;


import com.xjm.java.appcore.XmlHandeler;
import org.dom4j.DocumentException;
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
    public void shouldAnswerWithTrue() throws  DocumentException {
        XmlHandeler xmlHandeler=new XmlHandeler();
        xmlHandeler.addServlets();
    }
}
