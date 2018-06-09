package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.DeleteCommodityMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Commodity.DeleteCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCommodityServiceImpl implements DeleteCommodityService {

    @Autowired
    DeleteCommodityMapper delete;

    @Override
    public int DeleteCommodity(Integer id) {
        int number;
        number=delete.DeleteCommodity(id);
        if (number>0){
            number=delete.DeleteCommodityPrice(id);
            if (number>0){
                number= delete.DeleteCommodityPicture(id);
            }
        }
        return  number;
    }

    /**
     * 删除商品规格表某列
     * @param id 参数 【规格表主键id】
     * @return
     */
    @Override
    public int DeleteCommoditySpecification(Integer id) {
        int number=delete.DeleteCommoditySpecification(id);
        return number;
    }

}
