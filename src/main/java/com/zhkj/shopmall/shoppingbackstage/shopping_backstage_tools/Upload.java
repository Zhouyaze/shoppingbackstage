package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class Upload {
    /**
     * 帮助商品添加图片
     * @param request
     * @param
     * @return
     */
    public String saveupload(@RequestParam(name = "file")MultipartFile file, HttpServletRequest request, String upload) throws Exception {
        String name=file.getOriginalFilename();
        String suffix= FilenameUtils.getExtension(name);//获取文件后缀
        String path=request.getServletContext().getRealPath("/u1pload");//要上传到 真实路径
        File file1=new File(path);
        if(!file1.exists()){
            file1.mkdir();
        }
        String newpath=path+"/"+name+"."+suffix;
        file.transferTo(new File(newpath));
        return name;
    }
}
