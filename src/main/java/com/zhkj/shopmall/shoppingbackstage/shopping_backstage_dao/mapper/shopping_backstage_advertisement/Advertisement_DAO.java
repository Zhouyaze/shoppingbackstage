package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_advertisement;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AdvertisementEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AdvertisementplaceEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Advertisement_DAO {
    int addAdvertise(AdvertisementEntity advertisementEntity);
    int updateAdvertise(AdvertisementEntity advertisementEntity);
    List<AdvertisementEntity> selectAll(@Param(value = "advertisementEntity") AdvertisementEntity advertisementEntity, @Param(value = "currentPage") Integer currentPage, @Param("perPage") Integer perPage);
    List<AdvertisementEntity>select();
    int delete(AdvertisementEntity advertisementEntity);
    List<AdvertisementEntity> selectCount(@Param(value = "advertisementEntity") AdvertisementEntity advertisementEntity);
    List<AdvertisementplaceEntity> getPlace();
}
