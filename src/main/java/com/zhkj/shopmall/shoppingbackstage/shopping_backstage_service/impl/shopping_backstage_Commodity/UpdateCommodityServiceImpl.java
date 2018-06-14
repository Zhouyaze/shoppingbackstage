package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommoditySpecificationInventoryPriceEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityintroducepictureEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.UpdateCommodityMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Commodity.UpdateCommodityService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UpdateCommodityServiceImpl implements UpdateCommodityService {

    @Autowired
    UpdateCommodityMapper updateCommodityMapper;
    static  int number;
    @Override
    public int UpdateCommodity(CommodityEntity commodityEntity, MultipartFile picture) {
        if (picture!=null){
            Upload upload=new Upload();
            String file= upload.toupload(picture);
           commodityEntity.setBigPictureUrl(file);
        }
        return updateCommodityMapper.UpdateCommodity(commodityEntity);
    }

    @Override
    public int UpdateCommodityPrice(CommoditySpecificationInventoryPriceEntity priceEntity, MultipartFile img) {
        if (img!=null){
            Upload upload=new Upload();
            String file= upload.toupload(img);
            priceEntity.setPicture(file);

        }
        number=updateCommodityMapper.UpdateCommodityPrice(priceEntity);
        return number;
    }

    @Override
    public int UpdateCommodityPicture(CommodityintroducepictureEntity pictureEntity, MultipartFile picture) {
        if (picture!=null){
            Upload upload=new Upload();
            String file= upload.toupload(picture);
            pictureEntity.setPictureUrl(file);
        }
        number=updateCommodityMapper.UpdateCommodityPicture(pictureEntity);
        return number;
    }
}
