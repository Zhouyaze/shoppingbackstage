package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AuthenticationEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.UserEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_User.UserMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_authentication.AuthenticationMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backage_Kafka.KafkaServiceImpl;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_user.UserService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private KafkaServiceImpl kafkaService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AuthenticationMapper authenticationMapper;
    @Autowired
    private AuthenticationEntity authenticationEntity;
    private PageBean<UserEntity> pageBean=new PageBean<>();

    Upload upload=new Upload();
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
    /**
     * 增加用户
     * @param userEntity
     * @return
     */
    @Override
    public int userInfoAdd( UserEntity userEntity,MultipartFile File) {
        String imgPathUrl="";
        if (null!=File){
            Upload upload=new Upload();
            imgPathUrl= upload.toupload(File);
            String path=imgPathUrl;
            userEntity.setHeadPortraitUrl(path);
        }
        int result=userMapper.userAdd(userEntity);
        if (result>0){
            try {
                kafkaService.kafka_save(objectMapper.writeValueAsString(userEntity),userEntity.getId().toString(),UserEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return userMapper.userAdd(userEntity);
    }



    /**
     * 根据用户id修改用户信息
     * @param userEntity
     * @return
     */
    @Override
    public int updateUserInfo( UserEntity userEntity,MultipartFile File) {
        String imgPathUrl="";
        if (null!=File){
            Upload upload=new Upload();
            imgPathUrl= upload.toupload(File);
            String path=imgPathUrl;
            userEntity.setHeadPortraitUrl(path);
        }
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
