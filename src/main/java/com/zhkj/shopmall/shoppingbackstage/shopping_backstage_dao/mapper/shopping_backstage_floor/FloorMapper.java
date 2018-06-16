package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_floor;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.FloorEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorMapper {
    /**获取信息*/
    List<FloorEntity> getMsg(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);
    /**获取总条数*/
    int getCount();
    /**删除*/
    int delFloor(FloorEntity floorEntity);
    /**添加*/
    int addFloor(FloorEntity floorEntity);
    /**修改楼层信息*/
    int updateFloor(FloorEntity floorEntity);

}
