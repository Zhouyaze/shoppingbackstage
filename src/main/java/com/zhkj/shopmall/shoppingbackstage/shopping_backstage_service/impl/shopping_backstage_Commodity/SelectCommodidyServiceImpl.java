package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.*;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.SelectCommodidyMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Commodity.SelectCommodidyService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectCommodidyServiceImpl implements SelectCommodidyService {


    @Autowired
    SelectCommodidyMapper selectCommodidyMapper;

    PageBean<CommodityEntity> pageBean=new PageBean();

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
     * 帮助添加商品type详细规格    查询层级id 为1 的
     * @param
     * @return
     */
    @Override
    public List<TypeEntity> selecttypeleves() {
        List<TypeEntity> list= selectCommodidyMapper.selectleves();
        return list;
    }

    /**
     * 根据typeName查询typeName id
     * @param typeNamelevels
     * @return
     */
    @Override
    public int selectTypeName(String typeNamelevels) {
        return selectCommodidyMapper.selectTypeId(typeNamelevels);
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
    public PageBean<CommodityEntity> selectCommodity(CommodityEntity commodityEntity, Integer currentPage) {
        pageBean.setPageSize(5);
        pageBean.setTotalNum(selectCommodidyMapper.getCount(commodityEntity));
        pageBean.countPage(pageBean.getTotalNum(),currentPage,pageBean.getPageSize());
        pageBean.setItems(selectCommodidyMapper.selectCommodity(commodityEntity,pageBean.getStartIndex(),pageBean.getPageSize()));
        return pageBean;
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

    /**
     * 查询商品最后  一个id
     * @return
     */

    @Override
    public  int SelectCommodityId() {
        int commodityId=selectCommodidyMapper.SelectCommodityId();
        return commodityId;
    }


}
