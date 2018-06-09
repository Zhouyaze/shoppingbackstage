package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.commoditycontroller;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.Commodity_Vo;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.*;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity.DeleteCommodityServiceImpl;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity.SaveCommodityServiceImpl;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity.SelectCommodidyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class CommodityController {


    @Autowired
    SaveCommodityServiceImpl saveCommodityService;
    @Autowired
    SelectCommodidyServiceImpl selectCommodidyService;

    @Autowired
    DeleteCommodityServiceImpl deleteCommodityService;

    /**
     * 添加商品主表  更图片表
     * @param bigPicture
     * @param File
     * @param commodity_vo
     * @return
     */
    @RequestMapping(value = "saveCommodity",method = RequestMethod.POST)
    public int saveCommodity(@RequestBody MultipartFile bigPicture, MultipartFile[] File, Commodity_Vo commodity_vo){
        int saveNumber;
        saveNumber=saveCommodityService.saveCommodityAll(bigPicture,File,commodity_vo);
        return saveNumber;
    }

    /**
     * 添加商品规格表
     * @param simmallFile
     * @param commodity_vo
     * @return
     */
    @RequestMapping(value = "saveCommodityPrice",method = RequestMethod.POST)
    public int saveCommodityPrice(@RequestBody MultipartFile simmallFile, Commodity_Vo commodity_vo){
        int saveNumber;
        saveNumber=saveCommodityService.saveCommodityPrice(simmallFile,commodity_vo);
        return saveNumber;
    }
    /**
     * 下拉框查询
     * @return
     */
    @RequestMapping(value = "SelectLevels" ,method = RequestMethod.GET)
    public List<TypeEntity> selectlevels(){
        List<TypeEntity> list;
        list= selectCommodidyService.selecttypeleves();
        return list;
    }
    /**
     * 查询商品规格
     * @return
     */
    @RequestMapping(value = "selecttopic",method = RequestMethod.GET)
    public List<SpecificationstopicEntity> selecttopic(){
        return selectCommodidyService.selecttopic();
    }
    /**
     * 查询商品规格
     * @return
     */
    @RequestMapping(value = "selectspecifition",method = RequestMethod.GET)
    public List<CommoditySpecificationRelationEntity> selectspecifition(){
        return selectCommodidyService.selsctspecificationlevels();
    }


    /**
     * 查询商品详细规格
     * @return
     */
    @RequestMapping(value = "selectsdetaile",method = RequestMethod.GET)
    public  List<SpecificationsdetailedEntity> selectsdetailed(){
        return selectCommodidyService.selectsdetailed();
    }


    /**
     * 添加商品标题名称
     * @param typeEntity
     * @return
     */
    @RequestMapping(value = "savetype",method = RequestMethod.GET)
    public int savetype(TypeEntity typeEntity){
        int savetypenumber=  saveCommodityService.savetype(typeEntity);
        return savetypenumber;
    }

    /**
     * 添加商品标题名称
     * @param relationEntity
     * @return
     */
    @RequestMapping(value = "savespecification",method = RequestMethod.GET)
    public int savespecifition(CommoditySpecificationRelationEntity relationEntity){
        int savetypenumber=  saveCommodityService.SavecommoditySpecification(relationEntity);
        return savetypenumber;
    }

    /**
     * 添加商品规格
     * @param topic
     * @return
     */
    @RequestMapping(value = "saveTopic",method = RequestMethod.GET)
    public int savetopic(SpecificationstopicEntity topic){
        int topicText;
        topicText= saveCommodityService.savetopic(topic);
        return topicText;
    }

    /**
     * 添加商品详细
     * @param sedtailed
     * @return
     */
    @RequestMapping(value = "savesdetaild",method = RequestMethod.GET)
    public  int savesdetailed(SpecificationsdetailedEntity sedtailed){
        return saveCommodityService.savesedtailed(sedtailed);
    }

    /**
     * 条件查询
     * @param
     * @return
     */
    @RequestMapping(value = "selectCommodity",method = RequestMethod.GET)
    public List<CommodityEntity> list(CommodityEntity commodityEntity){
        return selectCommodidyService.selectCommodity(commodityEntity);
    }

    /**
     * 删除商品全部
     * @param id
     * @return
     */
    @RequestMapping(value = "deleteCommodity",method = RequestMethod.GET)
    public int delete(Integer id){
        return deleteCommodityService.DeleteCommodity(id);
    }

    /**
     * 删除某个 商品规格
     * @param id
     * @return
     */
    @RequestMapping(value = "deleteCommoditySpecification",method = RequestMethod.GET)
    public int deletespecification(Integer id){

        return deleteCommodityService.DeleteCommoditySpecification(id);
    }

    /**
     * 根据 商品主键id 查询商品规格表
     * @param id
     * @return
     */
    @RequestMapping(value = "selectAllspecification",method = RequestMethod.GET)
    public   List<CommoditySpecificationInventoryPriceEntity> selectAllspecification(Integer id){
        List<CommoditySpecificationInventoryPriceEntity>list;
        list=selectCommodidyService.selectAllspecification(id);
        return list;
    }

}