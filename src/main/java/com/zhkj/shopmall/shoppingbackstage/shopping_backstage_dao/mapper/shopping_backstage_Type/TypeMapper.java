package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Type;


import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.TypeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeMapper {
    /**
     * 查询所有类型
     * @return
     */
    List<TypeEntity> getTypeInfo();
    /**
     * 根据类型id类型名称
     * @return
     */
    List<TypeEntity> getTypeNameById(TypeEntity typeEntity);

    /**
     * 根据类型id删除类型
     * @return
     */
    int typeNameDelete(TypeEntity typeEntity);

    /**
     * 根据类型id修改类型
     * @return
     */
    int typeNameUpdate(TypeEntity typeEntity);

    /**
     * 增加类型
     * @param typeEntity
     * @return
     */
    int typeNameAdd(TypeEntity typeEntity);
}
