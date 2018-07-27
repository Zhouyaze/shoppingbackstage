package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.userLogin;

import com.auth0.jwt.JWTVerifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoginJWT {

    private static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";

    private static final String EXP = "exp";

    private static final String PAYLOAD = "payload";


    public static String unsign(String jwt) {
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        try {
            final Map<String,Object> claims= verifier.verify(jwt);
            if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
                long exp = (Long)claims.get(EXP);
                long currentTimeMillis = System.currentTimeMillis();
                if (exp > currentTimeMillis) {
                    String json = (String)claims.get(PAYLOAD);
                    return json;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
