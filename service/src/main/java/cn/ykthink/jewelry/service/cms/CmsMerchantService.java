package cn.ykthink.jewelry.service.cms;

import cn.ykthink.jewelry.model.cms.merchant.bo.CmsMerchantLoginBO;
import org.springframework.http.ResponseEntity;

/**
 * Author: YK
 * Title: CmsMerchantService
 * Description: 商家端service
 * Date: 2019/6/3
 * Time: 23:03
 */
public interface CmsMerchantService {
    /**
     * 商家端登录
     *
     * @param body
     * @return
     */
    ResponseEntity<Object> login(CmsMerchantLoginBO body);
}
