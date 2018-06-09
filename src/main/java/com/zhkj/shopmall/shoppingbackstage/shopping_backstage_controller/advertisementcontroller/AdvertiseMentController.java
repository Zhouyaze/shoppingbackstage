package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.advertisementcontroller;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AdvertisementEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_advertisement.service.Advertisement_IMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdvertiseMentController {
    @Autowired
    Advertisement_IMPL advertisement_impl;
    @RequestMapping("/addAdvertise")
    public String insertAdvertise(@ModelAttribute AdvertisementEntity advertisementEntity) {
        String msg = null;
        if (advertisement_impl.addAdvertise(advertisementEntity) > 0) {
            msg = "添加广告成功";
        } else {
            msg = "添加广告失败";
        }
        return msg;
    }

    @RequestMapping("/updateStatus")
    public String updateStatusAdvertise(@ModelAttribute AdvertisementEntity advertisementEntity) {
        String msg = null;
        if (advertisement_impl.updateStatus(advertisementEntity) > 0) {
            msg = "成功修改状态";
        } else {
            msg = "修改状态失败";
        }
        return msg;
    }

    @RequestMapping("/updateAll")
    public String updateAllAdvertise(@ModelAttribute AdvertisementEntity advertisementEntity) {
        String msg = null;
        if (advertisement_impl.updateAdvertise(advertisementEntity) > 0) {
            msg = "修改成功";
        } else {
            msg = "修改失败";
        }
        return msg;
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

    @RequestMapping("/selectAll")
    public Object selectAdvertise(@ModelAttribute AdvertisementEntity advertisementEntity, Integer currentPage) {
        return advertisement_impl.selectAll(advertisementEntity, currentPage);
    }
}
