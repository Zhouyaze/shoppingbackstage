package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.*;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.SelectCommodidyMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Commodity.SelectCommodidyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectCommodidyServiceImpl implements SelectCommodidyService {


    @Autowired
    SelectCommodidyMapper selectCommodidyMapper;

    /**
     * 查询商品规格
     * @return
     */
    @Override
    public List<SpecificationstopicEntity> selecttopic() {
        List<SpecificationstopicEntity>list;
        list=selectCommodidyMapper.selectspecificationstopic();
        return list;
    }

    /**
     * 查询商品详细规格
     * @return
     */
    @Override
    public List<SpecificationsdetailedEntity> selectsdetailed() {
        List<SpecificationsdetailedEntity> list;
        list=selectCommodidyMapper.selectspecificationsdetailed();
        return list;
    }

    /**
     * 帮助添加商品详细规格    查询层级id
     * @param
     * @return
     */
    @Override
    public List<TypeEntity> selecttypeleves() {
        List<TypeEntity> list= selectCommodidyMapper.selectleves();
        return list;
    }

    @Override
    public List<CommoditySpecificationRelationEntity> selsctspecificationlevels() {
        List<CommoditySpecificationRelationEntity> list=selectCommodidyMapper.selsctspecification();
        return list;
    }

    /**
     * 帮助擦寻  商品主键id
     * @param name
     * @return
     */
    @Override
    public int seletCommodityId(String name) {
        int commodityId=  selectCommodidyMapper.seletCommodityId(name);
        return commodityId;
    }

    /**
     * 查询所有商品信息
     * @param commodityEntity
     * @return
     */
    @Override
    public List<CommodityEntity> selectCommodity(CommodityEntity commodityEntity) {
        List<CommodityEntity> list=  selectCommodidyMapper.selectCommodity(commodityEntity);
        return list;
    }

    /**
     * 根据商品id 查询规格表
     * @param id
     * @return
     */
    @Override
    public List<CommoditySpecificationInventoryPriceEntity> selectAllspecification(Integer id) {
        List<CommoditySpecificationInventoryPriceEntity> list=selectCommodidyMapper.selectAllspecification(id);

        return list;
    }





}
