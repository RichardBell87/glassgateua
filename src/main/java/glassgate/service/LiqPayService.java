//package glassgate.service;
//
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//
//import static javax.crypto.Cipher.PRIVATE_KEY;
//import static javax.crypto.Cipher.PUBLIC_KEY;
//
//@Service
//public class LiqPayService {
//
//    HashMap<String, String> params = new HashMap<String, String>();
//
//    PUBLIC_KEY  = "sandbox_i57877193154";
//    PRIVATE_KEY  = "\n"+
//            "sandbox_38L2LyCjKVFy2X9i6RwlDXs1E83JWTGbY2U9AUNg";
//
//    params.put("action", "agent_shop_create");
//    params.put("version", "3");
//    params.put("phone", "380950000001");
//    params.put("site", "agent1.site.com");
//    params.put("description", "site description");
//    params.put("email", "email@gmail.com");
//    params.put("name", "Site name");
//    params.put("card", "4731195301524634");
//    params.put("card_exp_month", "03");
//    params.put("card_exp_year", "22");
//    params.put("card_cvv", "111");
//
//    LiqPayService liqpay = new LiqPayService(PUBLIC_KEY, PRIVATE_KEY);
//
//    HashMap<String, Object> res = liqpay.api("request", params);
//
//    System.out.println(res.get("result"));
//}
