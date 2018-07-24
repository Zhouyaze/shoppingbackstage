package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.userLogin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.UserEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.*;

@Controller
public class LoginController {


    @Autowired
    private LoginJWT loginJWT;

    @Autowired
    private ObjectMapper objectMapper;

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return "success";
    }
    @ResponseBody
    @RequestMapping("/login")
    public String login(UserEntity userEntity, HttpServletRequest request) throws IOException {
//        response.sendRedirect("http://localhost:8080/test");
//        response.sendRedirect("http://192.168.43.111:8080/commonAuthentication?loginUser="+loginUser+"password="+password);
        String loginUser=userEntity.getLoginName();
        String password=userEntity.getLogingPassword();
        Map<String,String> map=new HashMap<>();
        map.put("loginUser",loginUser);
        map.put("password",password);

        return objectMapper.writeValueAsString(map);
    }

    /**
     * 获取接口返回的结果(Raw版本).
     *
     * @param postUrl          请求接口的url
     * @param requestBodyParam 请求Body里面Raw的值
     * @param requestHeader    请求头的值
     * @return 接口返回参数
     */
    public static String getResponseMess(String postUrl, String requestBodyParam, Map<Object, Object> requestHeader) {

        try {
            HttpClient httpClient = new DefaultHttpClient();

            HttpPost post = new HttpPost(postUrl);
            StringEntity postingString = new StringEntity(requestBodyParam);// Raw等里面的数据
            post.setEntity(postingString);

//            if (requestHeader != null) {
//                for (Map.Entry<Object, Object> entry : requestHeader.entrySet()) {
//                    post.setHeader(entry.getKey().toString(), entry.getValue().toString());
//                }
//            }
            HttpResponse response = httpClient.execute(post);
            String responseMess = EntityUtils.toString(response.getEntity());
            return responseMess;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/verifyToken")
    public String verifyToken(String token) {
        try {
            loginJWT.verifyToken(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
