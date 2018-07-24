package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.FloorEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_floor.FloorService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FloorController {

    @Autowired
    private FloorService floorService;

    @RequestMapping("/getFloorMsg")
    public PageBean<FloorEntity> getMsg(Integer currentPage, Integer pageSize) {
        return floorService.getMsg(currentPage,pageSize);
    }

    @RequestMapping("/delFloorMsg")
    public int delFloor(FloorEntity floorEntity) {
        int result=floorService.delFloor(floorEntity);
        return result;
    }

    @RequestMapping("/addFloorMsg")
    public int addFloor(FloorEntity floorEntity) {
        int result=floorService.addFloor(floorEntity);
        return result;
    }

    @RequestMapping("/updateFloorMsg")
    public int updateFloor(FloorEntity floorEntity) {
        int result=floorService.updateFloor(floorEntity);
        return result;
    }

}
