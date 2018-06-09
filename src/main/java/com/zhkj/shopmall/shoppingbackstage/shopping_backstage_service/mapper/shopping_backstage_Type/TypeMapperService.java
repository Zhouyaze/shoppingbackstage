package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Type;



import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.TypeEntity;

import java.util.List;

public interface TypeMapperService {
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
