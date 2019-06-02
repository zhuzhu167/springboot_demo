package cn.ykthink.jewelry.orm.pc;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Author: YK
 * Title: PcOrderMapper
 * Description: pc端订单Mapper
 * Date: 2019/6/2
 * Time: 16:40
 */
@Mapper
@Repository
public interface PcOrderMapper {
    /**
     * 修改订单状态
     *
     * @param uuid
     * @param status
     * @return
     */
    Integer updateOrderStatus(@Param("uuid") String uuid, @Param("status") Integer status);
}
