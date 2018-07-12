package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_OrderFrom;


import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.OrderfromEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.OrderfromshopEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_OrderFrom.OrderFromMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_OrderFromShop.OrderFromShopMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_OrderFrom.OrderMapperService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.Constants;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.ExportExcel;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderMapperServiceImpl implements OrderMapperService {
    @Autowired
    OrderFromShopMapper orderFromShopMapper;
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

    @Override
    public List<OrderfromEntity> selectAll() {

        return orderFromMapper.selectOrder();
    }

    @Override
    public boolean exportExcel(HttpServletResponse response) {
        List<OrderfromEntity>ls=orderFromMapper.selectOrder();
        List<String[]>strings=  convertList(ls);
        try {
            ExportExcel.exportData(response,Constants.EXCEL_FILE_NAME,Constants.STUDENT_TITLE_NAME, strings);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 转换类型
     * @param studentEntityList 要转换的类型
     * @return 转换后的类型
     */
    private List<String[]> convertList(List<OrderfromEntity> studentEntityList){
        List<String[]> list = null;
        List<OrderfromshopEntity>shop=orderFromShopMapper.select0();
        List<OrderfromshopEntity>shop1=orderFromShopMapper.select1();
        String shopName=null;
        String order=null;
        if(null != studentEntityList && studentEntityList.size() > 0){
            list = new ArrayList<>();
            for(OrderfromEntity studentEntity : studentEntityList){
                order=studentEntity.getOrderNumber();
                for (OrderfromshopEntity sp:shop
                     ) {
                     String sh=sp.getOrderFromId().toString();
                     if (order.equals(sh)){
                         shopName=sp.getCommodityEntity().getCommodityName();
                    }
                }
                for (OrderfromshopEntity sp1:shop1
                        ) {
                     String sh1=sp1.getOrderFromId().toString();
                    if (order.equals(sh1)){
                        shopName=sp1.getCommodityEntity().getCommodityName();
                    }
                }
                String[] strings = new String[]
                        {studentEntity.getOrderNumber(),studentEntity.getOrderCreationTime().toString(),
                        studentEntity.getHarvestAddressEntity().getUserName(),studentEntity.getHarvestAddressEntity().getUserPhone(),
                        studentEntity.getHarvestAddressEntity().getHarvestAddressName(),studentEntity.getOrderfromPrice().toString()
                        ,studentEntity.getPaymentTypeId().toString(),shopName};
                list.add(strings);
            }
        }
        return list;
    }
}
