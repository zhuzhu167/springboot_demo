package cn.ykthink.jewelry.service.common.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.model.common.vo.CommonQnyTokenConfigVO;
import cn.ykthink.jewelry.service.common.JewelryService;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Author: YK
 * Title: JewelryServiceImpl
 * Description: 珠宝impl
 * Date: 2019/6/4
 * Time: 17:49
 */
@Service
public class JewelryServiceImpl implements JewelryService {
    @Value("${jewelry.qny.accessKey}")
    private String accessKey;
    @Value("${jewelry.qny.secretKey}")
    private String secretKey;
    @Value("${jewelry.qny.bucket}")
    private String bucket;
    @Value("${jewelry.qny.cdnUrl}")
    private String cdnUrl;

    @Override
    public ResponseEntity<Object> qnyToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        CommonQnyTokenConfigVO commonQnyTokenConfigVO = new CommonQnyTokenConfigVO();
        commonQnyTokenConfigVO.setCdnUrl(cdnUrl);
        commonQnyTokenConfigVO.setToken(upToken);
        return ResponseEntitySupport.success(commonQnyTokenConfigVO);
    }
}
