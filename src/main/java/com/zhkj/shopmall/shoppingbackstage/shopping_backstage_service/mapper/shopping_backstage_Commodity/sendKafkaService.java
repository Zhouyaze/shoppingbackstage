package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.CommoditySpecifications_VO;

public interface SendKafkaService {

    /**
     * 发送补货信息到进销存
     * @param commoditySpecifications_vo
     * @return
     */
    String sendKafka(CommoditySpecifications_VO commoditySpecifications_vo);





}
