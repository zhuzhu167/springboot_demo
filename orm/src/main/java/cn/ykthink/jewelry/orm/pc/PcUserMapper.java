package cn.ykthink.jewelry.orm.pc;

import cn.ykthink.jewelry.model.common.po.ConsigneePO;
import cn.ykthink.jewelry.model.common.po.UserInfoPO;
import cn.ykthink.jewelry.model.pc.user.to.PcUserInfoTO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserPersonInfoVO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserReceiverInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Author: YK
 * Title: PcUserMapper
 * Description: 客户端用户Mapper
 * Date: 2019/4/28
 * Time: 15:13
 */
@Repository
@Mapper
public interface PcUserMapper {
    /**
     * 核对用户信息
     *
     * @param request
     * @return
     */
    PcUserInfoTO queryAccountPwd(@Param("request") Map<String, Object> request);

    /**
     * 用户注册
     *
     * @param userInfoPO
     * @return
     */
    Integer insertAccount(UserInfoPO userInfoPO);

    /**
     * 用户个人信息
     *
     * @param userUuid
     * @return
     */
    PcUserPersonInfoVO selectPersonMessage(@Param("userUuid") String userUuid);

    /**
     * 更新用户信息
     *
     * @param userInfoPO
     * @return
     */
    Integer updatePersonMessage(UserInfoPO userInfoPO);

    /**
     * 更新用户密码
     *
     * @param userInfoPO
     * @return
     */
    Integer updateUserPwd(UserInfoPO userInfoPO);

    /**
     * 收货人信息
     *
     * @param userUuid
     * @return
     */
    List<PcUserReceiverInfoVO> selectConsigneeMessage(@Param("userUuid") String userUuid);

    /**
     * 新增收货地址
     *
     * @param consigneePO
     * @return
     */
    Integer insertConsignee(ConsigneePO consigneePO);

    /**
     * 逻辑删除
     *
     * @param tableName
     * @param uuid
     * @return
     */
    Integer removeIsDeleted(@Param("tableName") String tableName, @Param("uuid") String uuid);

    /**
     * 修改收货人信息
     *
     * @param consigneePO
     * @return
     */
    Integer updateConsignee(ConsigneePO consigneePO);
}
