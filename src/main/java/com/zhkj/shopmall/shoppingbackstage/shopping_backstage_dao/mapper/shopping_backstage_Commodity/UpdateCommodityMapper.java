package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity;

import org.springframework.stereotype.Repository;

@Repository
public interface UpdateCommodityMapper {

    int UpdateCommodity(Integer id);
    int UpdateCommodityPrice(Integer id);
    int UpdateCommodityPicture( Integer id);

}
