package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backage_ReturnedService;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.ReturnedPurchaseVO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.ReturnedPurchaseEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReturnedPurchaseService {

    /**
     * 添加退货发货商品信息到消息表
     * @param returnedPurchaseVO
     * @return 文杰
     */
    String saveNews(ReturnedPurchaseVO returnedPurchaseVO);


    /**
     * 查询退货 发货商品  发送到进销存 逐条发送
     * @return 国超
     */
    String sendNews(@Param("returned") ReturnedPurchaseEntity returnedPurchaseEntity);


    /**
     * 查询 退货  发货商品 前台展示
     * @param returnedPurchaseEntity
     * @return
     */
    List<ReturnedPurchaseEntity> selectNews(ReturnedPurchaseEntity returnedPurchaseEntity);

//    /**
//     * 测试 国超 返回数据
//     * @param returnedPurchaseVO
//     * @return
//     */
//    String querReturned(ReturnedPurchaseVO returnedPurchaseVO);
}
