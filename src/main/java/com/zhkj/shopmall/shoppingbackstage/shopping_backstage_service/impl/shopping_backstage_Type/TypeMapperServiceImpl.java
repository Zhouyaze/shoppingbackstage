package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Type;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.TypeEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Type.TypeMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Type.TypeMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeMapperServiceImpl implements TypeMapperService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<TypeEntity> getTypeInfo() {

        return typeMapper.getTypeInfo();
    }

    @Override
    public List<TypeEntity> getTypeNameById(  TypeEntity typeEntity) {
        return typeMapper.getTypeNameById(typeEntity);


    }

    @Override
    public int typeNameDelete(  TypeEntity typeEntity) {
        return typeMapper.typeNameDelete(typeEntity);
    }

    @Override
    public int typeNameUpdate(  TypeEntity typeEntity) {
        return typeMapper.typeNameUpdate(typeEntity);
    }

    @Override
    public int typeNameAdd(  TypeEntity typeEntity) {
        return typeMapper.typeNameAdd(typeEntity);
    }
}
