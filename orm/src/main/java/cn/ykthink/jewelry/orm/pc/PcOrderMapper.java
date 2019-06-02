package cn.ykthink.jewelry.orm.pc;

import cn.ykthink.jewelry.model.pc.order.vo.PcUserOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 获取订单
     * @param userUuid
     * @return
     */
    List<PcUserOrderVO> selectOrder(@Param("userUuid")String userUuid);
}
