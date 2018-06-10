package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class Upload {
    /**
     * 帮助上传
     * @param multipartFile
     * @return
     */
    public String toupload(MultipartFile multipartFile){
        // 数据库存放的数据
        String imgFileName = "";
        try {
           //生成文件名称
            String imgName=multipartFile.getOriginalFilename();
            // 获取文件后缀类型
            String suffix = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            // 得到项目路径
            String xiangmuPath = ClassLoader.getSystemClassLoader().getResource("").getPath();
            String bigXiangmuPath = xiangmuPath.substring(0,xiangmuPath.indexOf("out")) + "img/bigImgPath";

            // 创建File对象 为存储图片做准备
            File file = new File(bigXiangmuPath);
            if(!file.exists()){
                file.mkdirs();
            }
            imgFileName = xiangmuPath+imgName;
            // 项目中文件存在的路径
            String xiangmuImgPath = bigXiangmuPath + "/" + imgName;

            // 向项目中存放文件
            multipartFile.transferTo(new File(xiangmuImgPath));
        }catch (IOException e){
            e.getStackTrace();
        }
        return imgFileName;
    }
}
//把图片 名  生成 为日期格式名成
//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//String imgName = simpleDateFormat.format(new Date());