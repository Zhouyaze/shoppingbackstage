package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.api.advertisement_api;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AdvertisementEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AdvertisementplaceEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface Advertisement_API {
  int addAdvertise(AdvertisementEntity advertisementEntity);

  int updateAdvertise(AdvertisementEntity advertisementEntity, MultipartFile file);

  Object selectAll(AdvertisementEntity advertisementEntity, Integer currentPage);

  int delete(AdvertisementEntity advertisementEntity);

  List<AdvertisementEntity> select();

  List<AdvertisementplaceEntity> getPlace();
}