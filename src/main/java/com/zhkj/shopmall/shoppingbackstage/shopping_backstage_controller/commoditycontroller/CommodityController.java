package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.commoditycontroller;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.Commodity_Vo;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.*;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity.DeleteCommodityServiceImpl;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity.SaveCommodityServiceImpl;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity.SelectCommodidyServiceImpl;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity.UpdateCommodityServiceImpl;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class CommodityController {


    @Autowired
    SaveCommodityServiceImpl saveCommodityService;
    @Autowired
    SelectCommodidyServiceImpl selectCommodidyService;

    @Autowired
    DeleteCommodityServiceImpl deleteCommodityService;

    @Autowired
    UpdateCommodityServiceImpl updateCommodityService;

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
     *  Type 下拉框查询
     * @return
     */
    @RequestMapping(value = "SelectTypeLevels" ,method = RequestMethod.GET)
    public List<TypeEntity> selectlevels(){
        List<TypeEntity> list;
        list= selectCommodidyService.selecttypeleves();
        return list;
    }
    /**
     * 查询商品规格 废物
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
     * 新增方法
     * 查询根据 颜色 id   或者  尺码id
     * @param commodityEntity
     * @return
     */
    @RequestMapping(value = "selectspecifications")
    public List<CommodityEntity> select(CommodityEntity commodityEntity) {

        return selectCommodidyService.selectspecifications(commodityEntity);
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
     * 查询全部 以及 商品的条件查询
     * @param
     * @return
     */
    @RequestMapping(value = "selectCommodity",method = RequestMethod.GET)
    public PageBean<CommodityEntity> list(CommodityEntity commodityEntity, Integer currentPage){
        return selectCommodidyService.selectCommodity(commodityEntity,currentPage);
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

    /**
     * 修改商品主表
     * @param
     * @return
     */
    @RequestMapping(value = "updateCommodity",method = RequestMethod.POST)
    public int update(@ModelAttribute CommodityEntity commodityEntity, MultipartFile picture){
        int number=0;
        number=updateCommodityService.UpdateCommodity(commodityEntity,picture);
        return number;
    }

    /**
     * 修改商品规格表
     * @param
     * @return
     */
    @RequestMapping(value = "UpdateCommodityPrice",method = RequestMethod.POST)
    public int updateCommodityPrice(@ModelAttribute CommoditySpecificationInventoryPriceEntity priceEntity, MultipartFile img){
        int number=0;
        number=updateCommodityService.UpdateCommodityPrice(priceEntity,img);
        return number;
    }

    /**
     * 修改商品标题图片 详情图片
     * @param
     * @return
     */
    @RequestMapping(value = "UpdateCommodityPicture",method = RequestMethod.POST)
    public int updateCommodityPicture(CommodityintroducepictureEntity pictureEntity,MultipartFile picture){
        int number=0;
        number=updateCommodityService.UpdateCommodityPicture(pictureEntity,picture);
        return number;
    }
    /*
     * 生成报表
     * */
    @RequestMapping("/generateCommodity")
    public String generateOrder(HttpServletResponse response){
        boolean bl=selectCommodidyService.exportExcel(response);
        if(bl){
            return "报表生成成功";
        }else {
            return "报表生成失败";
        }
    }
}
