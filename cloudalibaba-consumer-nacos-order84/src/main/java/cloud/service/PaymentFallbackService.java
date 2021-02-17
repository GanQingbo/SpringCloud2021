package cloud.service;

import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author G
 * @version 1.0
 * @date 2021/2/15 9:33
 */
//不能忘了这个注解,fallback兜底的方法
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(446,"服务降级返回---PaymentFallbackService",new Payment(id,"noSerial"));
    }
}
