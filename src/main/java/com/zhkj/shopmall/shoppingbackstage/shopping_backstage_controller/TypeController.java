package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller;



import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.TypeEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Type.TypeMapperService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class TypeController {
    Result result=new Result();
    @Autowired
    TypeMapperService typeMapperService;
    @GetMapping("/getTypeInfo")
    public List<TypeEntity> getTypeInfo(){
        return typeMapperService.getTypeInfo();
    }
    /**
     * 根据类型id类型名称
     * @return
     */
    @GetMapping("/getTypeName")
    public List<TypeEntity> getTypeNameById(TypeEntity typeEntity){
        return typeMapperService.getTypeNameById(typeEntity);
    }

    /**
     * 根据类型id删除类型
     * @return
     */
    @GetMapping("/deleteType")
    public String typeNameDelete(TypeEntity typeEntity){
        result.setCode(typeMapperService.typeNameDelete(typeEntity));
        if (result.getCode()>0){
            result.setMsg("删除成功");
        }else{
            result.setMsg("删除失败");
        }
        return result.getMsg();
    }

    /**
     * 根据类型id修改类型
     * @return
     */
    @GetMapping("/updateType")
    public String typeNameUpdate(TypeEntity typeEntity){
        result.setCode(typeMapperService.typeNameUpdate(typeEntity));
        if (result.getCode()>0){
            result.setMsg("修改成功");
        }else{
            result.setMsg("修改失败");
        }
        return result.getMsg();
    }
    /**
     * 增加类型
     * @param typeEntity
     * @return
     */
    @GetMapping("/addType")
    public String typeNameAdd(TypeEntity typeEntity){
        System.out.println(typeEntity.getTypeName());
        result.setCode(typeMapperService.typeNameAdd(typeEntity));
        System.out.println(typeEntity.getTypeName());
        if (result.getCode()>0){
            result.setMsg("增加成功");
        }else{
            result.setMsg("增加失败");
        }
        return result.getMsg();
    }
}
