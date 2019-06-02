package cn.ykthink.jewelry.core.support.tx;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Author: YK
 * Title: TXSmsSupport
 * Description: 腾讯短信接口支持类
 * Date: 2019/6/2
 * Time: 22:50
 */
@Component
@Log4j2
public class TXSmsSupport {

    @Value("${jewelry.tx.appId}")
    private int apPid;

    @Value("${jewelry.tx.appKey}")
    private String appKey;

    @Value("${jewelry.tx.countryCode}")
    private String countryCode;


    public void TXSendSms(Integer templateId, String smsSign, String phoneNumbers, String... message) {
        try {
            SmsSingleSender mSender  = new SmsSingleSender(apPid, appKey);
            SmsSingleSenderResult result = mSender.sendWithParam(countryCode, phoneNumbers,
                    templateId, message, smsSign, "", "");
            log.info(result);
        } catch (HTTPException e) {
            // HTTP 响应码错误
            log.error("HTTP 响应码错误",e);
        } catch (JSONException e) {
            // JSON 解析错误
            log.error("JSON 解析错误",e);
        } catch (IOException e) {
            // 网络 IO 错误
            log.error("网络 IO 错误",e);
        }
    }
}
