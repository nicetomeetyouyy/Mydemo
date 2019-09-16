package com.xjm.java.servlet;


import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class XmlHandeler extends DefaultHandler {
    private List<ServletInfo> servletInfos;
    private List<Mapping> mappings;
    private ServletInfo servletInfo;
    private Mapping mapping;
    boolean isMapping =false;
    String tag;
    /**
     * 开始解析时调用此方法
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("开始解析xml");
        servletInfos=new ArrayList<>();
        mappings =new ArrayList<>();

    }

    @Override
    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
        super.startElement(s, s1, s2, attributes);
        if("servlet".equals(s2)){
            servletInfo=new ServletInfo();
            isMapping=false;
        }else if("servlet-mapping".equals(s2)){
            mapping=new Mapping();
            isMapping=true;
        }
        tag=s2;
    }

    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        if(null!=s2){
            if(s2.equals("servlet")) {
                servletInfos.add(servletInfo);
            }else if(s2.equals("servlet-mapping")) {
                mappings.add(mapping);
            }
        }
        tag = null;
        }



    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        super.characters(chars, i, i1);
        String contents=new String(chars,i,i1).trim();
        if(null!=tag){
           if(!isMapping){
               if(tag.equals("servlet-name")){
                   servletInfo.setName(contents);
               }else if (tag.equals("servlet-class")){
                   servletInfo.setClassName(contents);
               }
           }else {
               if(tag.equals("servlet-name")){
                   mapping.setName(contents);
               }else if (tag.equals("url-pattern")){
                   mapping.setUrlPattern(contents);
               }
           }
        }

    }

    public List<ServletInfo> getServletInfos() {
        return servletInfos;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }
}
