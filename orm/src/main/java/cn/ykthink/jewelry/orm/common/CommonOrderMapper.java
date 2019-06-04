package cn.ykthink.jewelry.orm.common;

import cn.ykthink.jewelry.model.pc.order.vo.PcUserOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: YK
 * Title: CommonOrderMapper
 * Description: 公用订单Mapper
 * Date: 2019/6/4
 * Time: 16:11
 */
@Mapper
@Repository
public interface CommonOrderMapper {
    /**
     * 获取订单
     * @param userUuid
     * @return
     */
    List<PcUserOrderVO> selectOrder(@Param("userUuid")String userUuid,@Param("orderNo")String orderNo);
}
