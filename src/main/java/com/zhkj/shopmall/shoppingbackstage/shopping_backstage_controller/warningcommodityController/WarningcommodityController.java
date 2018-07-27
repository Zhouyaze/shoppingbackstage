package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.warningcommodityController;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.WarningcommodityEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shoping_backstage_WarningcommodityService.WarningcommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
    @RestController
    public class WarningcommodityController {
        @Autowired
        WarningcommodityService warningcommodityService;
        @RequestMapping("lectWarning")
        public List<WarningcommodityEntity> select(){
            return warningcommodityService.selectWarning();
        }
        /*
         * 生成报表
         * */
        @RequestMapping("/Warning")
        public String generateOrder(HttpServletResponse response){
            boolean bl=warningcommodityService.exportExcel(response);
            if(bl){
                return "报表生成成功";
            }else {
                return "报表生成失败";
            }
        }
    }

