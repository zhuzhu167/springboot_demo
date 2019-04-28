package cn.ykthink.jewelry.orm.pc;

import cn.ykthink.jewelry.model.comm.po.UserInfoPO;
import cn.ykthink.jewelry.model.pc.user.to.PcUserInfoTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
     * @param account
     * @return
     */
    PcUserInfoTO queryAccountPwd(@Param("account") String account);

    Integer insertAccount(UserInfoPO userInfoPO);
}
