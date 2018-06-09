package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_OrderFrom;



import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.*;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_OrderFrom.OrderFromMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_OrderFrom.OrderMapperService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderMapperServiceImpl implements OrderMapperService {
    Result result=new Result();
    @Autowired
    private OrderFromMapper orderFromMapper;

    private PageBean<OrderfromEntity> pageBean=new PageBean<>();

    @Override
    public int getOrderFromCount(OrderfromEntity orderfromEntity) {
        return orderFromMapper.getOrderFromCount(orderfromEntity);
    }

    @Override
    public PageBean<OrderfromEntity> getOrderFromSimInfoByCond(OrderfromEntity orderfromEntity, String userName,int currentPage, int pageSize) {
        pageBean.setTotalNum(orderFromMapper.getOrderFromCount(orderfromEntity));
        pageBean.countPage(pageBean.getTotalNum(),currentPage,pageSize);
        pageBean.setItems(orderFromMapper.getOrderFromSimInfoByCond(orderfromEntity,userName,pageBean.getStartIndex(),pageBean.getPageSize()));
        return pageBean;
    }
    @Override
    public int orderFromDelete( OrderfromEntity orderfromEntity) {
       if (Integer.parseInt(orderfromEntity.getOrderNumber())%2==0){
           return orderFromMapper.orderFromDelete0(orderfromEntity);
       }else{
           return orderFromMapper.orderFromDelete1(orderfromEntity);
       }
    }

    @Override
    public String orderFromUpdate( OrderfromEntity orderfromEntity) {
        result.setCode(orderFromMapper.orderFromUpdate(orderfromEntity));
        if (result.getCode()>0)
            result.setMsg("修改成功");
        else
            result.setMsg("修改失败");
        return result.getMsg();
    }
}
