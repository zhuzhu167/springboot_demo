package cn.ykthink.jewelry.orm.pc;

import cn.ykthink.jewelry.model.comm.po.UserInfoPO;
import cn.ykthink.jewelry.model.pc.user.to.PcUserInfoTO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserPersonInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
    PcUserInfoTO queryAccountPwd(@Param("request") Map<String,Object> request);

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
}
