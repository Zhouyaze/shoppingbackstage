package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.userLogin;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginJWT {

    private static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";

    public static String getToken(String json){
        //签发时间
        Date iatDate=new Date();
        //过期时间（1分钟）
        Calendar nowTime=Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,1);
        Date expiresDate = nowTime.getTime();

        Map<String,Object> map=new HashMap<>();
        map.put("alg","HS256");
        map.put("typ","JWT");
        try {
            String token= JWT.create()
                    .withHeader(map)                              //header
                    .withClaim("name","大壮")       //payload
                    .withClaim("age","18")
                    .withClaim("sex","男")
                    .withIssuedAt(iatDate)                       //设置签发时间
                    .withExpiresAt(expiresDate)                  //设置过期时间
                    .sign(Algorithm.HMAC256(SECRET));
            return token;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
    public Map<String,Claim> verifyToken(String token) throws Exception {
        JWTVerifier verifier= null;
        try {
            verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        DecodedJWT jwt= verifier.verify(token);
        return jwt.getClaims();
    }
}
