package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.advertisementcontroller;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AdvertisementEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AdvertisementplaceEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_advertisement.service.Advertisement_IMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class AdvertiseMentController {
    @Autowired
    private MainTest mainTest;

    @ResponseBody
    @RequestMapping("/send")
    public String send(){
        mainTest.send();
        return "success";
    }
    @Autowired
    Advertisement_IMPL advertisement_impl;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/addAdvertise")
    public String insertAdvertise(@ModelAttribute AdvertisementEntity advertisementEntity, MultipartFile file, HttpSession session) throws IOException {
        String msg = null;
        if (upload(file, session) > 0) {
            String url = (String) session.getAttribute("FileUrl");
            advertisementEntity.setPictureUrl(url);
            if (advertisement_impl.addAdvertise(advertisementEntity) > 0) {
                msg = "添加广告成功";
            } else {
                msg = "添加广告失败";
            }
        } else {
            msg = "上传失败";
        }
        return msg;
    }

    @RequestMapping("/updateAll")
    public int updateAllAdvertise(@ModelAttribute AdvertisementEntity advertisementEntity, MultipartFile file){
        return advertisement_impl.updateAdvertise(advertisementEntity,file);
    }

    @RequestMapping("/deleteAdvertise")
    public String deleteAdvertise(@ModelAttribute AdvertisementEntity advertisementEntity) {
        String msg = null;
        if (advertisement_impl.delete(advertisementEntity) > 0) {
            msg = "删除成功";
        } else {
            msg = "删除失败";
        }
        return msg;
    }

    //@RequestMapping("/upload")
    public int upload(@RequestParam(name = "file") MultipartFile file, HttpSession session) throws IOException {
        if (!file.isEmpty()) {
            String saveFileName = file.getOriginalFilename();//文件名
            Random random = new Random(999999999);
            int num = random.nextInt();
            Date date = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
            String xiangmuPath = ClassLoader.getSystemClassLoader().getResource("").getPath();
            String bigXiangmuPath = xiangmuPath.substring(0, xiangmuPath.indexOf("out")) + "img/bigImgPath";
            // 创建File对象 为存储图片做准备
            File fi = new File(bigXiangmuPath);
            if (!fi.exists()) {
                fi.mkdirs();
            }
            String fileName = fi + "/" + sf.format(date) + num + saveFileName;
            file.transferTo(new File(fileName));
            session.setAttribute("FileUrl", fileName);
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping("/select")
    public List<AdvertisementEntity> select() {
        return advertisement_impl.select();
    }

    @RequestMapping("/getPlace")
    public List<AdvertisementplaceEntity> getPlace() {
        return advertisement_impl.getPlace();
    }
}
