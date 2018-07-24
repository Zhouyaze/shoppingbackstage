package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.CommoditySpecifications_VO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 后台补货  kafka
 */
@Repository
public interface SendKafkaMapper {

    /**
     * 发送补货信息到进销存
     * @param commoditySpecifications_vo
     * @return
     */
    String sendKafka(@Param("commodity") CommoditySpecifications_VO commoditySpecifications_vo);



}
