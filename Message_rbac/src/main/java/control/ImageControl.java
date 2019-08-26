package control;

import annotation.Log;
import entity.Image;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import services.ImageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ImageControl {
    @Autowired
    private ImageService imageService;
    @RequestMapping("uploadimage")
    public String uploadImage(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("User");
        int user_id=user.getId();
        if(user_id!=0){
        List<Image> list=imageService.findByUser(user_id);
        if(list!=null){
            request.getSession().setAttribute("images",list);
        }
        }
        return "addPicture";
    }
    @Log(operationName = "上传新头像")
    @RequestMapping("addImage")
    public String addImage(MultipartFile picture,HttpServletRequest request) throws IOException {
        if(picture.isEmpty()){
            return "addPicture";
        }
        User user = (User) request.getSession().getAttribute("User");
        int user_id=user.getId();
        String fileName=picture.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        if(suffixName.equals(".jpg")||suffixName.equals(".jpeg")||suffixName.equals(".bmp")||suffixName.equals(".png")
                ||suffixName.equals(".jfif")) {
            String filePath = "D:\\train_group2\\Message_RBAC\\src\\main\\resources\\static\\";
            fileName = UUID.randomUUID() + suffixName;
            File dest = new File(filePath + fileName);
            if (!dest.exists()) {
                dest.createNewFile();
            }
            try {
                picture.transferTo(dest);
            } catch (Exception e) {
                System.out.println("存入失败");
                e.printStackTrace();
            }
            Image image1=imageService.findOne(user_id,1);
            if(image1!=null){
                int id=image1.getId();
                int uid=image1.getUser_id();
                imageService.updateImage(0,id,uid);
            }
            Image image = new Image();
            image.setFilename(fileName);
            image.setUser_id(user_id);
            image.setIs_used(1);
            imageService.insertImage(image);
            request.getSession().setAttribute("useImage",image);
            return "addUser";
        }else {
            return  "addPicture";
        }
    }
    @Log(operationName = "更改头像")
    @RequestMapping("updateImage")
    public void updateImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id=request.getParameter("imageHistory");
        User user= (User) request.getSession().getAttribute("User");
        int user_id=user.getId();
        Image image1=imageService.findOne(user_id,1);
        if(image1!=null){
            int iid=image1.getId();
            int uid=image1.getUser_id();
            imageService.updateImage(0,iid,uid);
        }
        imageService.updateImage(1,Integer.valueOf(id),user_id);
        Image image=imageService.findOne(user_id,1);
        if(image!=null){
            request.getSession().setAttribute("useImage",image);
        }
        request.getRequestDispatcher("uploadimage").forward(request,response);
    }
    @RequestMapping("deleteImage")
    @Log(operationName = "删除历史头像")
    public void deleteImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id=request.getParameter("image_id");
        System.out.println(id);
        imageService.deleteImage(Integer.valueOf(id));
        User user= (User) request.getSession().getAttribute("User");
        int user_id=user.getId();
        Image image=imageService.findOne(user_id,1);
        request.getSession().setAttribute("useImage",image);
        request.getRequestDispatcher("uploadimage").forward(request,response);
    }
}
