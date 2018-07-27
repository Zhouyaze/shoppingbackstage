package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shoping_backstage_Warningcommodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.WarningcommodityEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Repository
public interface WarningcommodityMapper {

    /**
     * 添加商品 补货信息
     * @param warningcommodityEntity
     * @return
     */
    int saveWarning(@Param("warning") WarningcommodityEntity warningcommodityEntity);

    boolean exportExcel(HttpServletResponse response);


    List<WarningcommodityEntity> selectWarning();


}
