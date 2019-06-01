package cn.ykthink.jewelry.service.pc;

import cn.ykthink.jewelry.model.pc.cart.bo.PcUserPayCartBO;
import org.springframework.http.ResponseEntity;

/**
 * program: jewelry
 * description:PC购物车Service
 * author: mi
 * create: 2019-05-09 16:59
 **/
public interface PcCartService {
    /**
     * 获取购物车信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseEntity<Object> cart(Integer pageNum, Integer pageSize);

    /**
     * 删除购物车商品
     * @param cartCommodityUuid
     * @return
     */
    ResponseEntity<Object> removeCart(String cartCommodityUuid);

    /**
     * 购买
     */
    ResponseEntity<Object> payCart(PcUserPayCartBO body);
}
