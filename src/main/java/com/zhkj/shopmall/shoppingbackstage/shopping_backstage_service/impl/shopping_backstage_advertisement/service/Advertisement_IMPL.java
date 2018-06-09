package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_advertisement.service;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.api.advertisement_api.Advertisement_API;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AdvertisementEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_advertisement.Advertisement_DAO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.Page;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Advertisement_IMPL implements Advertisement_API {
    @Autowired
    Advertisement_DAO advertisement_dao;

    /**
     * 添加一条广告
     */
    @Override
    public int addAdvertise(AdvertisementEntity advertisementEntity) {
        return advertisement_dao.addAdvertise(advertisementEntity);
    }

    /**
     * 修改广告的状态
     */
    @Override
    public int updateStatus(AdvertisementEntity advertisementEntity) {
        return advertisement_dao.updateStatus(advertisementEntity);
    }

    /**
     * 修改广告的全部信息
     */
    @Override
    public int updateAdvertise(AdvertisementEntity advertisementEntity) {
        return advertisement_dao.updateAdvertise(advertisementEntity);
    }

    /**
     * 查询广告并分页，支持模糊查询
     * result：存储信息和Map
     * map:存储page类
     * page:存储分页的信息和数据的集合
     */
    @Override
    public Object selectAll(AdvertisementEntity advertisementEntity, Integer currentPage) {
        Result result = new Result();
        Map map = new HashMap();
        com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.Page page=new Page();
        if (currentPage == null) {
            currentPage = 1;
        }
        page.setPerPage(2);//修改每页显示条数
        page.setTotalCount(advertisement_dao.selectCount(advertisementEntity).size());//总条数
        Integer current = (currentPage - 1) * page.getPerPage();//分页起始位置
        page.setCurrentPage(currentPage);//当前页数
        List<AdvertisementEntity> info = advertisement_dao.selectAll(advertisementEntity, current, page.getPerPage());
        page.setRecords(info);//分页后的数据
        if (info.size()>0) {
            map.put("page", page);
            result.setMsg("成功读取Info");
            result.setCode(1);
            result.setT(map);

        } else {
            result.setT(map);
            result.setMsg("读取Info失败");
            result.setCode(0);
        }
        return result;
    }

    /**
     * 删除一条广告
     */
    @Override
    public int delete(AdvertisementEntity advertisementEntity) {
        return advertisement_dao.delete(advertisementEntity);
    }
}
