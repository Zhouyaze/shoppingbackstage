package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Specificationsrelation;



import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.SpecificationsrelationEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Specificationsrelation.SpecificationsrelationMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Specificationsrelation.SpecificationsrelationMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationsrelationMapperServiceImpl implements SpecificationsrelationMapperService {
    @Autowired
    private SpecificationsrelationMapper specificationsrelationMapper;
    @Override
    public List<SpecificationsrelationEntity> getspectificRelationById(SpecificationsrelationEntity specificationsrelationEntity) {
        return specificationsrelationMapper.getspectificRelationById(specificationsrelationEntity);
    }
}
