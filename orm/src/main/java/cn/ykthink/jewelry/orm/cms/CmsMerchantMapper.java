package cn.ykthink.jewelry.orm.cms;

import cn.ykthink.jewelry.model.cms.merchant.to.CmsMerchantInfoTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Author: YK
 * Title: CmsMerchantMapper
 * Description: 商家Mapper
 * Date: 2019/6/3
 * Time: 23:07
 */
@Mapper
@Repository
public interface CmsMerchantMapper {
    /**
     * 核对信息
     *
     * @param request
     * @return
     */
    CmsMerchantInfoTO queryAccountPwd(@Param("request") Map<String, Object> request);
}
