package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.CommoditySpecifications_VO;

/**
 * 后台补货  kafka
 */
public interface sendKafka {

    /**
     * 发送补货信息到进销存
     * @param commoditySpecifications_vo
     * @return
     */
    String sendKafka(CommoditySpecifications_VO commoditySpecifications_vo);

}
