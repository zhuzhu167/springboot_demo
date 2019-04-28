package cn.ykthink.jewelry.orm.pc;

import cn.ykthink.jewelry.model.pc.user.to.UserInfoTO;
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
     * 核对用户密码
     * @param account
     * @return
     */
    UserInfoTO queryAccountPwd(@Param("account") String account);
}
