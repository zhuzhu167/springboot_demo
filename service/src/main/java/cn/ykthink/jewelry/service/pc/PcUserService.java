package cn.ykthink.jewelry.service.pc;

import cn.ykthink.jewelry.model.pc.user.bo.*;
import org.springframework.http.ResponseEntity;

/**
 * Author: YK
 * Title: PcUserService
 * Description: 客户端用户Service
 * Date: 2019/4/28
 * Time: 14:43
 */
public interface PcUserService {

    /**
     * 用户登录
     *
     * @param body
     * @return
     */
    ResponseEntity<Object> login(PcUserLoginBO body);

    /**
     * 用户注册
     *
     * @param body
     * @return
     */
    ResponseEntity<Object> register(PcUserRegisterBO body);

    /**
     * 获取个人信息
     *
     * @return
     */
    ResponseEntity<Object> person();

    /**
     * 编辑个人信息
     *
     * @param body
     * @return
     */
    ResponseEntity<Object> editPerson(PcUserEditPerson body);

    /**
     * 修改密码
     *
     * @param body
     * @return
     */
    ResponseEntity<Object> editPwd(PcUserEditPwd body);

    /**
     * 收货点信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseEntity<Object> consignee(Integer pageNum, Integer pageSize);

    /**
     * 删除收货信息
     *
     * @param consigneeUuid
     * @return
     */
    ResponseEntity<Object> removeConsignee(String consigneeUuid);

    /**
     * 编辑收货信息
     *
     * @param consigneeUuid
     * @param body
     * @return
     */
    ResponseEntity<Object> editConsignee(String consigneeUuid, PcUerReceiverInfoBO body);
}
