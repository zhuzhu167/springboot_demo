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
     * 删除订单
     * @param orderUuid
     * @return
     */
    Integer removeIsDeleted(@Param("orderUuid")String orderUuid);

    /**
     * 检查订单是否已收货
     * @param orderUuid
     * @return
     */
    Integer checkLogisticsStatus(@Param("orderUuid")String orderUuid);

    /**
     * 确认收货
     * @param orderUuid
     * @return
     */
    Integer updateLogisticsStatus(@Param("orderUuid")String orderUuid);
}
