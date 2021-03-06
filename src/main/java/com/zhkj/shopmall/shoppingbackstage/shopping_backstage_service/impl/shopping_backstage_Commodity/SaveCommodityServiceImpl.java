package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.Commodity_Vo;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.*;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.SaveCommodityMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.SelectCommodidyMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backage_Kafka.KafkaServiceImpl;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Commodity.SaveCommodityService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

//import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backage_Kafka.KafkaServiceImpl;

@Service
public class SaveCommodityServiceImpl implements SaveCommodityService {

    @Autowired
    SaveCommodityMapper saveCommodityMapper;

    @Autowired
    SelectCommodidyMapper selectCommodidyMapper;

    @Autowired
    KafkaServiceImpl kafkaService;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 添加商品全部详细信息
     *
     * @param commodity_vo
     * @return
     */
    @Override
    public int saveCommodityAll(MultipartFile imgFile, MultipartFile[] File , Commodity_Vo commodity_vo) {


        if (commodity_vo != null) {
            CommodityEntity commodityEntity = getCommodityEntity(commodity_vo);//获取添加的商品
            String imgPathUrl = "";
            if(null != imgFile){
                imgPathUrl = toupload(imgFile);
                String patch=imgPathUrl;
                commodity_vo.setBigPictureUrl(patch);
            }
            commodityEntity.setBigPictureUrl(commodity_vo.getBigPictureUrl());
            saveCommodityMapper.SaveCommodity(commodityEntity);
            try {
                kafkaService.kafka_save(objectMapper.writeValueAsString(commodityEntity)
                        ,String.valueOf(commodityEntity.getId())
                        ,CommodityEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //获取商品名称
            String name = commodity_vo.getCommodityName();
            //根据商品名查询商品 主id
            int commodityId = selectCommodidyMapper.seletCommodityId(name);
            commodity_vo.setCommodityId(commodityId);
            CommodityintroducepictureEntity pictureEntity=getCommodityintroducepictureEntity(commodity_vo);
            String PathUrl = "";
            int no=2;
            int levels=0;
            PathUrl = toupload(File[0]);
            String patch=PathUrl;
            //根据最后“/”截取字符
            //  String url = patch.substring(patch.lastIndexOf("/")+1,patch.length());
//            commodity_vo.setPictureUrl(patch);
            pictureEntity.setPictureUrl(patch);
            pictureEntity.setLevels(levels);
            int num=saveCommodityMapper.Savecommodityintroducepicture(pictureEntity);
            if (num>0) {
                try {
                    kafkaService.kafka_save(objectMapper.writeValueAsString(pictureEntity)
                            , String.valueOf(pictureEntity.getId())
                            , CommodityintroducepictureEntity.class);
//                    int id = pictureEntity.getId();
//                    pictureEntity.setId(id + 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //第二张图片
            CommodityintroducepictureEntity pictureEntity2=getCommodityintroducepictureEntity(commodity_vo);

            String PathUrl2 = "";
            int no2=2;
            int levels2=1;
            PathUrl2 = toupload(File[1]);
            String patch2=PathUrl2;
            //根据最后“/”截取字符
            //  String url = patch.substring(patch.lastIndexOf("/")+1,patch.length());
//            commodity_vo.setPictureUrl(patch);
            pictureEntity2.setPictureUrl(patch2);
            pictureEntity2.setLevels(levels2);

            int num2=saveCommodityMapper.Savecommodityintroducepicture(pictureEntity2);
            if (num2>0) {
                try {
                    kafkaService.kafka_save(objectMapper.writeValueAsString(pictureEntity2)
                            , String.valueOf(pictureEntity2.getId())
                            , CommodityintroducepictureEntity.class);
//                    int id = pictureEntity.getId();
//                    pictureEntity.setId(id + 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }












//
//            CommodityintroducepictureEntity pic=new CommodityintroducepictureEntity();
//            PathUrl = toupload(File[1]);
//            patch=PathUrl;
//            //根据最后“/”截取字符
//            //  String url = patch.substring(patch.lastIndexOf("/")+1,patch.length());
////            commodity_vo.setPictureUrl(patch);
//            pic.setPictureUrl(patch);
//            pic.setLevels(1);
//            int id=pictureEntity.getId()+1;
//            pic.setId(id);
//            pic.setCommodityId(pictureEntity.getCommodityId());
//            num=saveCommodityMapper.Savecommodityintroducepicture(pic);
//            if (num>0) {
//                try {
//                    kafkaService.kafka_save(objectMapper.writeValueAsString(pic)
//                            , String.valueOf(pic.getId())
//                            , CommodityintroducepictureEntity.class);
////                    int id = pictureEntity.getId();
////                    pictureEntity.setId(id + 1);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }



//            if(null != File){
//                for (int i=0;i< File.length;i++){
////                    PathUrl = toupload(File[i]);
////                    String patch=PathUrl;
////                    //根据最后“/”截取字符
////                    //  String url = patch.substring(patch.lastIndexOf("/")+1,patch.length());
////                    commodity_vo.setPictureUrl(patch);
////                    for ( int number=levels;number<no;number++){
////                        pictureEntity.setLevels(levels);
////                    }
////                    levels++;
////                    pictureEntity.setPictureUrl(commodity_vo.getPictureUrl());
//                    int num=saveCommodityMapper.Savecommodityintroducepicture(pictureEntity);
//                    try {
//                        kafkaService.kafka_save(objectMapper.writeValueAsString(pictureEntity)
//                                ,String.valueOf(pictureEntity.getId())
//                                ,CommodityintroducepictureEntity.class);
//                        int id=pictureEntity.getId();
//                        pictureEntity.setId(id+1);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
        }
        return 1;
    }

    /**
     * 添加商品规格表
     * @param simmallFile
     * @param commodity_vo
     * @return
     */
    @Override
    public int saveCommodityPrice(MultipartFile simmallFile, Commodity_Vo commodity_vo) {
        if (commodity_vo!=null) {

            String imgPathUrl = "";
            if(null != simmallFile){
                imgPathUrl = toupload(simmallFile);
                String patch=imgPathUrl;
                // 根据最后“/”截取字符
                // String url = patch.substring(patch.lastIndexOf("/")+1,patch.length());
                commodity_vo.setPicture(patch);
                // 获取商品名称
                // String name = commodity_vo.getCommodityName();
                // 根据商品名查询商品 主id
                // int commodityId = selectCommodidyMapper.seletCommodityId(name);

                if(commodity_vo.getCommodityId()!=0){
                    commodity_vo.setCommodityId(commodity_vo.getCommodityId());
                }else {
                    int commodityId=selectCommodidyMapper.SelectCommodityId();
                    commodity_vo.setCommodityId(commodityId);
                }
                CommoditySpecificationInventoryPriceEntity priceEntity=getCommoditySpecificationInventoryPriceEntity(commodity_vo);

                saveCommodityMapper.Savecommodity_specification_inventory_price(priceEntity);
                try {
                    kafkaService.kafka_save(objectMapper.writeValueAsString(priceEntity),String.valueOf(priceEntity.getId()),CommoditySpecificationInventoryPriceEntity.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return 1;
    }

    /**
     * 帮助上传
     * @param multipartFile
     * @return
     */
    private String toupload(MultipartFile multipartFile){
        // 数据库存放的数据
        String imgFileName = "";
        try {
//            // 生成文件名称
            String imgName=multipartFile.getOriginalFilename();
//           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//           String imgName = simpleDateFormat.format(new Date());
            // 获取文件后缀类型
            String suffix = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            // 得到项目路径
            String xiangmuPath = ClassLoader.getSystemClassLoader().getResource("").getPath();
            String bigXiangmuPath = xiangmuPath.substring(0,xiangmuPath.indexOf("classes")) + "img/bigImgPath";
            // 创建File对象 为存储图片做准备
            File file = new File(bigXiangmuPath);
            if(!file.exists()){
                file.mkdirs();
            }
            imgFileName = xiangmuPath+imgName;
            // 项目中文件存在的路径
            String xiangmuImgPath = bigXiangmuPath + "/" + imgName;
            // 向项目中存放文件
            multipartFile.transferTo(new File(xiangmuImgPath));
        }catch (IOException e){
            e.getStackTrace();
        }
        return imgFileName;
    }



    /**
     * 添加商品标题
     *
     * @param typeEntity
     * @return
     */
    @Override
    public int savetype(TypeEntity typeEntity) {
        if (typeEntity.getId() != 0) {
            typeEntity.setParentId(typeEntity.getId());
            typeEntity.setLevels(2);
            return saveCommodityMapper.savecommoditytype(typeEntity);
        } else {
            typeEntity.setParentId(0);
            typeEntity.setLevels(1);
            return saveCommodityMapper.savecommoditytype(typeEntity);
        }
    }

    /**
     * 添加商品规格类类型
     * @param relationEntity
     * @return
     */
    @Override
    public int SavecommoditySpecification(CommoditySpecificationRelationEntity relationEntity) {
        if (relationEntity.getId() != 0) {
            relationEntity.setParentId(relationEntity.getId());
            relationEntity.setLevels(2);
        } else {
            relationEntity.setParentId(0);
            relationEntity.setLevels(1);
        }
        int result=saveCommodityMapper.Savecommodity_specification_relation(relationEntity);
        if (result>0){
            try {
                kafkaService.kafka_save(objectMapper.writeValueAsString(relationEntity)
                        ,String.valueOf(relationEntity.getId())
                        ,CommoditySpecificationRelationEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 添加商品规格
     *
     * @param topic
     * @return
     */
    @Override
    public int savetopic(SpecificationstopicEntity topic) {
        int result=saveCommodityMapper.savespecifications(topic);
        if (result>0){
            try {
                kafkaService.kafka_save(objectMapper.writeValueAsString(topic)
                        ,String.valueOf(topic.getId())
                        ,SpecificationstopicEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 商品详细规格添加
     * 比如 xl  41  S  M  L
     *
     * @param sedtailed
     * @return
     */
    @Override
    public int savesedtailed(SpecificationsdetailedEntity sedtailed) {
        int result=saveCommodityMapper.savespecificationsdetailed(sedtailed);
        if (result>0){
            try {
                kafkaService.kafka_save(objectMapper.writeValueAsString(sedtailed)
                        ,String.valueOf(sedtailed.getId())
                        ,SpecificationsdetailedEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Entity接收Vo数据
     * 商品主表
     * @param commodity_vo
     * @return
     */
    private CommodityEntity getCommodityEntity(Commodity_Vo commodity_vo) {
        CommodityEntity commodityEntity = new CommodityEntity();
        commodityEntity.setCommodityName(commodity_vo.getCommodityName());
        commodityEntity.setTypeName(commodity_vo.getTypeName());
        // 待补充
        commodityEntity.setBigPictureUrl(commodity_vo.getBigPictureUrl());
        return commodityEntity;
    }

    /**
     * Entity接收Vo数据
     * 商品详细规格表
     * @param commodity_vo
     * @return
     */
    private CommoditySpecificationInventoryPriceEntity getCommoditySpecificationInventoryPriceEntity(Commodity_Vo commodity_vo) {
        CommoditySpecificationInventoryPriceEntity priceEntity = new CommoditySpecificationInventoryPriceEntity();
        priceEntity.setCommodityId(commodity_vo.getCommodityId());
        priceEntity.setSpecification1(commodity_vo.getSpecification1());
        priceEntity.setSpecification2(commodity_vo.getSpecification2());
        priceEntity.setSpecification3(commodity_vo.getSpecification3());
        priceEntity.setSpecification4(commodity_vo.getSpecification4());
        priceEntity.setPicture(commodity_vo.getPicture());
        priceEntity.setPrice(commodity_vo.getPrice());
        priceEntity.setInventory(commodity_vo.getInventory());
        return priceEntity;
    }

    /**
     * Entity接收Vo数据
     * 添加商品图片
     * @param commodity_vo
     * @return
     */
    private CommodityintroducepictureEntity getCommodityintroducepictureEntity(Commodity_Vo commodity_vo){
        CommodityintroducepictureEntity pictureEntity =new CommodityintroducepictureEntity();
        pictureEntity.setCommodityId(commodity_vo.getCommodityId());
        pictureEntity.setLevels(commodity_vo.getLevels());
        pictureEntity.setPictureUrl(commodity_vo.getPictureUrl());
        return pictureEntity;
    }


    /**
     * 发送json进货数据到进销存
     */





}
