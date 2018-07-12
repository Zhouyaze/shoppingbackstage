package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.orderfromController;



import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.*;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_OrderFrom.OrderMapperService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
public class OrderFromController {
    @Autowired
    OrderMapperService orderMapperService;
    /**
     * 根据条件查询订单
     * @param orderfromEntity
     * @return
     */
    @GetMapping("/getOrderFromInfoByCond")
    public PageBean<OrderfromEntity> getOrderFromInfoByCond(OrderfromEntity orderfromEntity, String userName, int currentPage, int pageSize){
        return orderMapperService.getOrderFromSimInfoByCond(orderfromEntity,userName,currentPage,pageSize);
    }
    /**
     * 删除订单信息
     * @param orderfromEntity
     * @return
     */
    @GetMapping("/deleteOrderFrom")
    public int orderFromDelete(OrderfromEntity orderfromEntity) {
        return orderMapperService.orderFromDelete(orderfromEntity);
    }
    /**
     * 修改订单信息
     * @param orderfromEntity
     * @return
     */
    @GetMapping("/updateOrderFrom")
    public String orderFromUpdate(OrderfromEntity orderfromEntity){
        return orderMapperService.orderFromUpdate(orderfromEntity);
    }
    /*
     * 生成报表
     * */
    @RequestMapping("/generateOrder")
    public String generateOrder(HttpServletResponse response){
        boolean bl=orderMapperService.exportExcel(response);
        if(bl){
            return "报表生成成功";
        }else {
            return "报表生成失败";
        }
    }
}
