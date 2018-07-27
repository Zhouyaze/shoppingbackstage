package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shoping_backstage_WarningcommodityService;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.WarningcommodityEntity;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface WarningcommodityService {

    boolean exportExcel(HttpServletResponse response);


    List<WarningcommodityEntity> selectWarning();

}
