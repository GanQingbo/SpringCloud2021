package cloud.controller;

import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author G
 * @version 1.0
 * @date 2021/2/14 19:38
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    //模拟数据库读取数据
    public static HashMap<Long, Payment> hashMap=new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"serial001"));
        hashMap.put(2L,new Payment(2L,"serial002"));
        hashMap.put(3L,new Payment(3L,"serial003"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment=hashMap.get(id);
        CommonResult<Payment> result=new CommonResult(200,"from mysql ,serverPort:"+serverPort,payment);
        return  result;
    }
}
