
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.Claim;
//import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Component
public class MainTest {
//
//    public static String SECRET="TEST";
//
//    public static void main(String[] args) {
//        String token=getToken();
//        System.out.println(token);
//        Map<String,Claim> map=verifyToken(token);
//        for (Map.Entry<String,Claim> entry : map.entrySet()){
//            System.out.println(entry.getKey()+":"+entry.getValue().asString());
//        }
//    }
//    public static String getToken(){
//        //签发时间
//        Date iatDate=new Date();
//        //过期时间（1分钟）
//        Calendar nowTime=Calendar.getInstance();
//        nowTime.add(Calendar.MINUTE,1);
//        Date expiresDate = nowTime.getTime();
//
//        Map<String,Object> map=new HashMap<>();
//        map.put("alg","HS256");
//        map.put("typ","JWT");
//        try {
//            String token= JWT.create()
//                    .withHeader(map)                              //header
//                    .withClaim("name","大壮")       //payload
//                    .withClaim("age","18")
//                    .withClaim("sex","男")
//                    .withIssuedAt(iatDate)                       //设置签发时间
//                    .withExpiresAt(expiresDate)                  //设置过期时间
//                    .sign(Algorithm.HMAC256(SECRET));
//            return token;
//        } catch (UnsupportedEncodingException e) {
//            return null;
//        }
//    }
//    public static Map<String,Claim> verifyToken(String token) {
//        JWTVerifier verifier= null;
//        try {
//            verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        DecodedJWT jwt=verifier.verify(token);
//        return jwt.getClaims();
//    }

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;
    public void send(){
        kafkaTemplate.send("zhuohua","dazhubg");
    }
    @KafkaListener(topics = "zhuohua")
    public void get(String msg){
        System.out.println(msg);
    }
}
