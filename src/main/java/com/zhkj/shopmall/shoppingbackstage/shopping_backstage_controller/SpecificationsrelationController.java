package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller;


import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.SpecificationsrelationEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Specificationsrelation.SpecificationsrelationMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecificationsrelationController {
    @Autowired
    SpecificationsrelationMapperService specificationsrelationMapperService;
    @GetMapping("/getCommRelation")
    public List<SpecificationsrelationEntity> getspectificRelationById(SpecificationsrelationEntity specificationsrelationEntity){
        return specificationsrelationMapperService.getspectificRelationById(specificationsrelationEntity);
    }
}
