package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shoping_backstage_WarningcommodityImpl;

import com.alibaba.fastjson.JSONObject;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.WarnigcommodityVO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.WarningcommodityEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shoping_backstage_Warningcommodity.WarningcommodityMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shoping_backstage_WarningcommodityService.WarningcommodityService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.Constants;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class WarningcommodityServiceImpl implements WarningcommodityService {


    @Autowired
    WarningcommodityMapper mapper;

    @KafkaListener(topics = "stock")
    public String ReceiveMessages(String json){
        //接收进货数据
        WarnigcommodityVO warnigcommodityVO= JSONObject.parseObject(json,WarnigcommodityVO.class);

        WarningcommodityEntity warningcommodityEntity=getWarningcommodityEntity(warnigcommodityVO);
        int no= mapper.saveWarning(warningcommodityEntity);
        if (no>0){
            return "成功";
        }
        return "失败";
    }





    @Override
    public List<WarningcommodityEntity> selectWarning() {
        return mapper.selectWarning();
    }


    @Override
    public boolean exportExcel(HttpServletResponse response) {
        List<WarningcommodityEntity>ls=mapper.selectWarning();
        List<String[]>strings=  convertList(ls);
        try {
            ExportExcel.exportData(response, Constants.WARNING_NAME,Constants.WARNING_TABLE, strings);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 转换类型
     * @param studentEntityList 要转换的类型
     * @return 转换后的类型
     */
    private List<String[]> convertList(List<WarningcommodityEntity> studentEntityList){
        List<String[]> list = null;
        if(null != studentEntityList && studentEntityList.size() > 0){
            list = new ArrayList<>();
            for(WarningcommodityEntity studentEntity : studentEntityList){
                String[] strings = new String[]
                        {studentEntity.getId().toString(),studentEntity.getCommodityName(),studentEntity.getCommoditySpecification(),
                                studentEntity.getCommodityCount().toString(),studentEntity.getCommoditySupplier(),
                                studentEntity.getCommodityWaitCount().toString(),studentEntity.getCreateTime().toString()};
                list.add(strings);
            }
        }
        return list;
    }







   private WarningcommodityEntity getWarningcommodityEntity(WarnigcommodityVO warnigcommodityVO){
        WarningcommodityEntity warningcommodityEntity=new WarningcommodityEntity();
        warningcommodityEntity.setCommodityName(warnigcommodityVO.getCommodityName());
        warningcommodityEntity.setCommoditySpecification(warnigcommodityVO.getCommoditySpecification());
        warningcommodityEntity.setCommodityCount(warnigcommodityVO.getCommodityCount());
        warningcommodityEntity.setCommoditySupplier(warnigcommodityVO.getCommoditySupplier());
        warningcommodityEntity.setCommodityWaitCount(warnigcommodityVO.getCommodityWaitCount());

       warningcommodityEntity.setCreateTime(warnigcommodityVO.getCreateTime());
        return warningcommodityEntity;
   }

}
