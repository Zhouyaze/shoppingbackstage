package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_user;


import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.UserEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public interface UserService {

    /*
    获得所有用户信息
    分页
     */
    PageBean<UserEntity> getUserCount(UserEntity userEntity);

    /**
     * 查询用户所有信息
     * 带分页
     * @return
     */
    PageBean<UserEntity> getAllUserInfo(UserEntity userEntity,String userPhoneNumber,String userName,Integer currentPage,Integer pageSize);

    /**
     * 增加用户信息
     * @return
     */
    int userInfoAdd(UserEntity userEntity,MultipartFile File);

    /**
     * 根据用户id修改用户信息
     * @param userEntity
     * @return
     */
    int updateUserInfo(UserEntity userEntity);

    /**
     * 删除用户信息
     * @param userEntity
     * @return
     */
    int userInfoDelete(UserEntity userEntity);
}
