package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.userLogin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.UserEntity;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class LoginController {


    @Autowired
    private LoginJWT loginJWT;

    @Autowired
    private ObjectMapper objectMapper;

    @ResponseBody
    @PostMapping("/test")
    public String test(String loginUser, String password) {
        return "success   " + loginUser + "    " + password;
    }

    public String login(UserEntity userEntity, HttpServletRequest request) {
        String result = "";
        String loginUser = userEntity.getLoginName();
        String password = userEntity.getLogingPassword();
//        Map<String, String> map = new HashMap<>();
//        map.put("loginUser", loginUser);
//        map.put("password", password);
//        UserDTO userDTO=new UserDTO();
//        userDTO.setLoginUser(loginUser);
//        userDTO.setPassword(password);
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
//            PostMethod postMethod = new PostMethod(commandURL);
            HttpPost httpPost = new HttpPost("http://192.168.5.23:8080/commonAuthentication?loginUser=\"+userEntity.getLoginName()+\"&password=\"+userEntity.getLogingPassword()");
            List<NameValuePair> params = new ArrayList<NameValuePair>(); //建立一个NameValuePair数组，用于存储欲传送的参数
//            params.add(new BasicNameValuePair("userDTO", objectMapper.writeValueAsString(userDTO)));//添加参数
//            params.add(new BasicNameValuePair("password", password));
            System.out.println(params.toString());
            httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            System.out.println("httpPost" + httpPost.getURI());
            HttpResponse response = httpclient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, HTTP.UTF_8);
                }
            }
            System.out.println(result);
            return response.getEntity().toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/login")
    public String method(HttpClient client, UserEntity userEntity, HttpServletRequest request) {
        String loginUser = userEntity.getLoginName();
        String password = userEntity.getLogingPassword();
//        PostMethod method = new PostMethod("http://192.168.5.23:8080/commonAuthentication?loginUser="+userEntity.getLoginName()+"&password="+userEntity.getLogingPassword());
//        try {
//            // Execute the method.
//            int statusCode = client.executeMethod(method);
//            if (statusCode != HttpStatus.SC_OK) {
//                System.err.println("Method failed: " + method.getStatusLine());
//            }
//
//            // Read the response body.
//            byte[] responseBody = method.getResponseBody();
//            // Deal with the response.
//            // Use caution: ensure correct character encoding and is not binary data
//            System.out.println(new String(responseBody, "utf-8"));
//            System.out.println(verifyToken(responseBody.toString()));
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", loginUser);
//            request.getSession().setAttribute("reponseBody",verifyToken(responseBody.toString()));
////            return verifyToken(responseBody.toString());
//        }
//        catch (IOException e) {
//            System.err.println("Fatal transport error: " + e.getMessage());
//            e.printStackTrace();
////            return null;
//        }
        return "/index.jsp";
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
            HttpClient httpClient = new HttpClient();

            HttpPost post = new HttpPost(postUrl);
            StringEntity postingString = new StringEntity(requestBodyParam);// Raw等里面的数据
            post.setEntity(postingString);

            if (requestHeader != null) {
                for (Map.Entry<Object, Object> entry : requestHeader.entrySet()) {
                    post.setHeader(entry.getKey().toString(), entry.getValue().toString());
                }
            }
//            HttpResponse response = httpClient.execute(post);
//            String responseMess = EntityUtils.toString(response.getEntity());
//            return responseMess;
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/getMsgTest")
//    @ResponseBody
    public String getMsg(UserEntity userEntity, HttpServletRequest request) {
        String loginUser = userEntity.getLoginName();
        String password = userEntity.getLogingPassword();
        try {
//            HttpClient httpClient = new DefaultHttpClient();
//            HttpPost post = new HttpPost("http://192.168.43.111:8080/commonAuthentication?loginUser=" + loginUser + "password=" + password);
//            HttpResponse response = httpClient.execute(post);
//            String responseMess = EntityUtils.toString(response.getEntity());
//            System.out.println(responseMess);
//            return responseMess;
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String verifyToken(String token) {
        try {
            return loginJWT.unsign(token);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
