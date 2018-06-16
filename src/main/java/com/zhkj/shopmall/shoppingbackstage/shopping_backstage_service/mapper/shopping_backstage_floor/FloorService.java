package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_floor;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.FloorEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;

public interface FloorService {
    /**获取信息*/
    PageBean<FloorEntity> getMsg(Integer currentPage, Integer pageSize);
    /**删除*/
    int delFloor(FloorEntity floorEntity);
    /**添加*/
    int addFloor(FloorEntity floorEntity);
    /**修改楼层信息*/
    int updateFloor(FloorEntity floorEntity);
}
