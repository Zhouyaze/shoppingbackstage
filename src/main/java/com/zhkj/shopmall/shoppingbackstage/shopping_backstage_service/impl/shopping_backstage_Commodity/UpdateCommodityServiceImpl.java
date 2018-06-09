package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.UpdateCommodityMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Commodity.UpdateCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCommodityServiceImpl implements UpdateCommodityService {

    @Autowired
    UpdateCommodityMapper updateCommodityMapper;
    static  int number;
    @Override
    public int UpdateCommodity(Integer id) {
        number=updateCommodityMapper.UpdateCommodity(id);
        return number;
    }

    @Override
    public int UpdateCommodityPice(Integer id) {
        number=updateCommodityMapper.UpdateCommodityPicture(id);
        return number;
    }

    @Override
    public int UpdateCommodityPicture(Integer id) {
        number=updateCommodityMapper.UpdateCommodityPrice(id);
        return number;
    }
}
