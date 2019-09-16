package com.xjm.controller;

import com.xjm.pojo.Menu;
import com.xjm.service.MenuService;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class MenuController {
    @Resource
    private MenuService menuServiceImpl;
    @RequestMapping("/show")
    @ResponseBody
    public List<Menu> show(){
        return menuServiceImpl.findMenu(0);
    }

    /**
     * 原生Servlet传递
     * @param request
     * @return
     */
    @RequestMapping("req")
    public String hello(HttpServletRequest request){
        request.setAttribute("req","我是req");
        request.getSession().setAttribute("session","我是session");
        return "index";
    }

    /**
     * map传值
     * @param map
     * @return
     */
    @RequestMapping("map")
    public String map(Map<String,Object> map){
        map.put("map","map的值");
        return "index";
    }

    /**
     * Model传值
     * @param model
     * @return
     */
    @RequestMapping("model")
    public String model(Model model){
        model.addAttribute("model","model的值");
        return "index";
    }

    /**
     * ModelAndView传递值
     * @return
     */
    @RequestMapping("mav")
    public ModelAndView mav(){
        ModelAndView mav=new ModelAndView("index");
        mav.addObject("mav","ModelAndView传递的值");
        return mav;
    }

    @RequestMapping("download")
    public void downLoad(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
//       设置响应头
        response.setHeader("Content-Disposition","attachment;filename=a.txt");
//        传输文件
        ServletOutputStream outputStream=response.getOutputStream();
        String path ="D:\\train_group2\\SsmDemo\\src\\main\\resources\\files";
        File file=new File(path,fileName);
        byte[]bytes= FileUtils.readFileToByteArray(file);
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
        System.out.println(request.getRequestURI());

    }
    @RequestMapping("upload")
    public String upLoad(MultipartFile file) throws IOException {
        String fileName=file.getOriginalFilename();
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        String newFile= UUID.randomUUID().toString()+suffix;
        file.transferTo(new File("E://",newFile));
        return "index";
    }
}
