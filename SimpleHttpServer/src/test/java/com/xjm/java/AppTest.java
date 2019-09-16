package com.xjm.java;

import static org.junit.Assert.assertTrue;


import com.xjm.java.servlet.XmlHandeler;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws ParserConfigurationException, SAXException {
       /* XmlReader xmlReader=new XmlReader();
        Document document=xmlReader.reder("src/main/resources/test.xml");
        Element root= document.getRootElement();
        System.out.println(root.getName());
        Element element=root.element("person");
        System.out.println(element.elementText("name"));*/
        SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
        SAXParser saxParse=saxParserFactory.newSAXParser();
        XmlHandeler xmlHandeler=new XmlHandeler();
        saxParse.parse(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("src/main/resources/web.xml"),xmlHandeler)

    }
}
