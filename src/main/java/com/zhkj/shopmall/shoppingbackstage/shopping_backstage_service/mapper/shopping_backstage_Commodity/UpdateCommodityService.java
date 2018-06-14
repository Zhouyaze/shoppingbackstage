package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommoditySpecificationInventoryPriceEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityintroducepictureEntity;
import org.springframework.web.multipart.MultipartFile;

public interface UpdateCommodityService {

    int UpdateCommodity(CommodityEntity commodityName, MultipartFile picture);

    int UpdateCommodityPrice(CommoditySpecificationInventoryPriceEntity priceEntity,MultipartFile img);

    int UpdateCommodityPicture(CommodityintroducepictureEntity pictureEntity, MultipartFile picture);

}
