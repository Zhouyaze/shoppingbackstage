package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.userController;


import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.UserEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_user.UserService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getUserCount")
    public PageBean<UserEntity> getUserCount(UserEntity userEntity){
        return userService.getUserCount(userEntity);
    }
    @GetMapping(value = "/getUser")
    public PageBean<UserEntity> getUserInfo(UserEntity userEntity,String userPhoneNumber,String userName,Integer currentPage,Integer pageSize) {
        return userService.getAllUserInfo(userEntity,userPhoneNumber,userName,currentPage,pageSize);
    }

    @RequestMapping(value = "/userAdd",method = RequestMethod.POST)
    public String userInfoAdd(UserEntity userEntity,MultipartFile File) {
        Result result = new Result();
        result.setCode(userService.userInfoAdd(userEntity,File));
        if (result.getCode() > 0) {
            result.setMsg("添加成功");
        } else {
            result.setMsg("添加失败");
        }
        return result.getMsg();
    }
    @RequestMapping(value = "/userUpdate",method = RequestMethod.POST)
    public String userInfoUpdate(UserEntity userEntity,MultipartFile file) {
        Result result = new Result();
        result.setCode(userService.updateUserInfo(userEntity,file));
        if (result.getCode() > 0) {
            result.setMsg("修改成功");
        } else {
            result.setMsg("修改失败");
        }
        return result.getMsg();
    }

    @GetMapping("/userDelete")
    public int userInfoDelete(UserEntity userEntity) {
        return userService.userInfoDelete(userEntity);
    }
}
