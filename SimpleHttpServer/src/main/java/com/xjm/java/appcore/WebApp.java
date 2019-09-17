package com.xjm.java.appcore;

import org.dom4j.DocumentException;

public class WebApp  {
    private static XmlHandeler xmlHandeler;
    static {
        try {
            xmlHandeler=new XmlHandeler();
        } catch (DocumentException e) {
            System.out.println("文件解析异常");
        }
    }

    public static Object getServlet(String pattern) throws Exception {
        String name =xmlHandeler.getMappings().get(pattern);
        String scl=xmlHandeler.getServletInfos().get(name);
        Class cla=Class.forName(scl);
        return cla.newInstance();
    }
}
