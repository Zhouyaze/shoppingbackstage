package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_user;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AuthenticationEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.UserEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_User.UserMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_authentication.AuthenticationMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_user.UserService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AuthenticationMapper authenticationMapper;
    @Autowired
    private AuthenticationEntity authenticationEntity;
    private PageBean<UserEntity> pageBean=new PageBean<>();

    @Override
    public PageBean getUserCount(UserEntity userEntity) {
        pageBean.setTotalNum(userMapper.getUserCount(userEntity));
        return pageBean;
    }
    /**
     * 查询全部用户
     * @return
     */
    @Override
    public PageBean<UserEntity> getAllUserInfo(UserEntity userEntity,String userPhoneNumber,String userName,Integer currentPage,Integer pageSize) {
        pageBean.setTotalNum(userMapper.getUserCount(userEntity));
        pageBean.countPage(pageBean.getTotalNum(),currentPage,pageSize);
        pageBean.setItems(userMapper.getAllUserInfo(userEntity,userPhoneNumber,userName,pageBean.getStartIndex(),pageBean.getPageSize()));
        return pageBean;
    }

    @Override
    public List<UserEntity> getUserInfoByInfoNoPage(UserEntity userEntity) {
        List<UserEntity> listUserEntity = userMapper.getUserInfoByInfoNoPage(userEntity);
        List<AuthenticationEntity> listAuthenticationEntity=new ArrayList<>();
        for (int i=0;i<listUserEntity.size();i++){
            authenticationEntity.setId(listUserEntity.get(i).getId());
            listAuthenticationEntity.addAll(authenticationMapper.getAuthenicationById(authenticationEntity));
        }
        for (int i=0;i<listAuthenticationEntity.size();i++){
            int j=0;
            while (true){
                if (listUserEntity.get(i).getAuthenticationId()==listAuthenticationEntity.get(j).getId()){
                    listUserEntity.get(i).setAuthenticationEntity(listAuthenticationEntity.get(j));
//                    return listUserEntity;
                    break;
                }
                j++;
            }
        }
        return listUserEntity;
    }

    /**
     * 增加用户
     * @param userEntity
     * @return
     */
    @Override
    public int userInfoAdd( UserEntity userEntity) {
        return userMapper.userAdd(userEntity);
    }

    /**
     * 根据用户id修改用户信息
     * @param userEntity
     * @return
     */
    @Override
    public int updateUserInfo( UserEntity userEntity) {
        return userMapper.userInfoUpdate(userEntity);
    }

    /**
     * 删除用户信息
     * @param userEntity
     * @return
     */
    @Override
    public int userInfoDelete( UserEntity userEntity) {
        return userMapper.userInfoDelete(userEntity);
    }
}
