package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_ReturnedPurchase;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.ReturnedPurchaseVO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.ReturnedPurchaseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnedPurchaseMapper {

    /**
     * 退货 发货商品信息 添加消息表
     * @param returnedPurchaseEntity
     * @return 文杰
     */
    int saveNews(@Param("returned") ReturnedPurchaseEntity returnedPurchaseEntity);


    /**
     * 测试 国超 返回数据
     * @param returnedPurchaseVO
     * @return
     */
    String querReturned(ReturnedPurchaseVO returnedPurchaseVO);


    /**
     * 查询退货 发货商品   发送到进销存 逐条发送
     * @return 国超
     */
    ReturnedPurchaseEntity sendNews(@Param("returned") ReturnedPurchaseEntity returnedPurchaseEntity);


    /**
     * 修改状态
     * @param
     * @return
     */
    int updateNews(@Param("operatingStatus")int operatingStatus,@Param("manifest") String manifest);

    /**
     * 根据 条件查询（发货  退货）展示前台
     * @param returnedPurchaseEntity
     * @return
     */
    List<ReturnedPurchaseEntity> selectNews(@Param("type") ReturnedPurchaseEntity returnedPurchaseEntity);


    /**
     * 根据订单号 查询
     * @param manifest
     * @return
     */
    int slecctspecificationsId(@Param("manifest") String  manifest);

    int sslectInventory (@Param("manifest") String  manifest);




}
