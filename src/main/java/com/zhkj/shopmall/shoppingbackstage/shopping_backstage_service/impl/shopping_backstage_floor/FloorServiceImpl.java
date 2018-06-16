package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_floor;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.FloorEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_floor.FloorMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_floor.FloorService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorMapper floorMapper;

//    @Autowired
//    private PageBean<FloorEntity> pageBean;

    @Override
    public PageBean<FloorEntity> getMsg(Integer currentPage, Integer pageSize) {
        PageBean<FloorEntity> pageBean=new PageBean<>();
        int total=floorMapper.getCount();
        pageBean.countPage(total,currentPage,pageSize);
        pageBean.setItems(floorMapper.getMsg(pageBean.getStartIndex(),pageBean.getPageSize()));
        return pageBean;
    }

    @Override
    public int delFloor(FloorEntity floorEntity) {
        int result=floorMapper.delFloor(floorEntity);
        return result;
    }

    @Override
    public int addFloor(FloorEntity floorEntity) {
        int result=floorMapper.addFloor(floorEntity);
        return result;
    }

    @Override
    public int updateFloor(FloorEntity floorEntity) {
        int result=floorMapper.updateFloor(floorEntity);
        return result;
    }
}
