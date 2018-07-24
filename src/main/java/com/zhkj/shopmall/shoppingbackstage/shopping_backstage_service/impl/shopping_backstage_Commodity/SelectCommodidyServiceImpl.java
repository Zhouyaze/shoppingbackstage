package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.*;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.SelectCommodidyMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.SendKafkaMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Commodity.SelectCommodidyService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.Constants;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.ExportExcel;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class SelectCommodidyServiceImpl implements SelectCommodidyService {


    @Autowired
    SelectCommodidyMapper selectCommodidyMapper;

    @Autowired
    SendKafkaMapper sendKafkaMapper;

    PageBean<CommodityEntity> pageBean=new PageBean();

//<<<<<<< Updated upstream
//=======


    /**
     * 查询商品  颜色{子类}尺码{子类}
     * @param commodityEntity
     * @return
     */
    @Override
    public List<CommodityEntity> selectspecifications(CommodityEntity commodityEntity) {
      List<CommodityEntity> list=selectCommodidyMapper.selectspecifications(commodityEntity);
        return list;
    }


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

    @Override
    public boolean exportExcel(HttpServletResponse response) {
        List<CommodityEntity>ls=selectCommodidyMapper.selectShop();
        List<String[]>list=convertList(ls);
        try {
            ExportExcel.exportData(response,Constants.SHOP_NAME,Constants.SHOP_TABLE,list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<CommodityEntity> selectShop() {
        return null;
    }

    /**
     * 转换类型
     * @param studentEntityList 要转换的类型
     * @return 转换后的类型
     */
    private List<String[]> convertList(List<CommodityEntity> studentEntityList){
        List<String[]> list =null;
        if(null != studentEntityList && studentEntityList.size() > 0){
            list = new ArrayList<>();
            for(CommodityEntity studentEntity : studentEntityList){
                String[] strings = new String[]
                        {studentEntity.getId().toString(),studentEntity.getCommodityName(),studentEntity.getTypeName(),
                        studentEntity.getPriceEntity().getPrice().toString(),studentEntity.getPriceEntity().getSpecification1()+","+studentEntity.getPriceEntity().getSpecification2()+","+studentEntity.getPriceEntity().getSpecification3()+","+studentEntity.getPriceEntity().getSpecification4(),
                        studentEntity.getPriceEntity().getInventory().toString()};
                list.add(strings);
            }
        }
        return list;
    }

}
