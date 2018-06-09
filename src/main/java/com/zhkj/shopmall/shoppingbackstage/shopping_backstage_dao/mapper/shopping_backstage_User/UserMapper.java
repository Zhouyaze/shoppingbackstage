package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_User;


import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    /**
     * 获取用户所有信息
     * @return
     */
    int getUserCount(UserEntity userEntity);
    /**
     * 查询所有用户信息
     * @return
     */
    List<UserEntity> getAllUserInfo(@Param("userEntity") UserEntity userEntity,@Param("userPhoneNumber")String userPhoneNumber,@Param("userName")String userName,@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    /**
     * 根据条件查询所有用户不带分页
     * @param userEntity
     * @return
     */
    List<UserEntity> getUserInfoByInfoNoPage(UserEntity userEntity);
    /**
     * 增加用户
     * @return
     */
    int userAdd(UserEntity userEntity);

    /**
     * 修改用户信息
     * @param userEntity
     * @return
     */
    int userInfoUpdate(UserEntity userEntity);

    /**
     * 删除用户信息
     * @param userEntity
     * @return
     */
    int userInfoDelete(UserEntity userEntity);
}
