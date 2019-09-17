package com.xjm.java.appcore;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlHandeler{
    private Map<String,String> servletInfos;
    private Map<String,String> mappings;

    private Document document;
    public XmlHandeler() throws DocumentException {
        this.document=new SAXReader().read(new File("D:\\train_group2\\SimpleHttpServer\\src\\main\\resources\\web.xml"));
         servletInfos=new HashMap<>();
         mappings=new HashMap<>();
    }


    public Map<String, String> getServletInfos() {
        return servletInfos;
    }

    public Map<String, String> getMappings() {
        return mappings;
    }

    public void addServlets(){
        Element root=document.getRootElement();
        List<Element> list=root.elements();
        for (Element e:list
             ) {
//            System.out.println(e.getQualifiedName());

            if (e.getQualifiedName().equals("appcore")) {
                String name,sclass;
                name=e.elementText("appcore-name");
                sclass=e.elementText("appcore-class");
                servletInfos.put(name,sclass);

            } else if (e.getQualifiedName().equals("appcore-mapping")) {
                String name,pattern;
                name=e.elementText("appcore-name");
                pattern=e.elementText("url-pattern");
                mappings.put(pattern,name);
            }
        }
    }
}
