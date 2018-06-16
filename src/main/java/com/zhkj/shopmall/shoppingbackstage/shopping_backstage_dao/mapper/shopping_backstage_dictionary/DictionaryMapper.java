package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_dictionary;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.DictionaryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryMapper {

    /**获取所有字典数据信息*/
    List<DictionaryEntity> getAllMsg();
    /**根据类型获取字典数据信息*/
    List<DictionaryEntity> getMsgByType(DictionaryEntity dictionaryEntity);
    /**新增*/
    int saveMsg(DictionaryEntity dictionaryEntity);
    /**删除*/
    int delMsgById(DictionaryEntity dictionaryEntity);
    /**修改*/
    int updateMsg(DictionaryEntity dictionaryEntity);

}
