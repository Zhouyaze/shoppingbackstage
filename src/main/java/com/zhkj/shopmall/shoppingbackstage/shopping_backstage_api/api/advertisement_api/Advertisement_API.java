package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.api.advertisement_api;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AdvertisementEntity;

public interface Advertisement_API {
  int addAdvertise(AdvertisementEntity advertisementEntity);
  int updateStatus(AdvertisementEntity advertisementEntity);
  int updateAdvertise(AdvertisementEntity advertisementEntity);
  Object selectAll(AdvertisementEntity advertisementEntity, Integer currentPage);
  int delete(AdvertisementEntity advertisementEntity);

}
