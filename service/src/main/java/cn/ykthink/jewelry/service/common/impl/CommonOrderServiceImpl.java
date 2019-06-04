package cn.ykthink.jewelry.service.common.impl;

import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import cn.ykthink.jewelry.orm.common.CommonOrderMapper;
import cn.ykthink.jewelry.service.common.CommonOrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: YK
 * Title: CommonOrderServiceImpl
 * Description: 公用订单impl
 * Date: 2019/6/4
 * Time: 16:07
 */
@Service
public class CommonOrderServiceImpl implements CommonOrderService {
    @Resource
    CommonOrderMapper commonOrderMapper;

    @Override
    public JSONObject order(String userUuid, String orderNo, Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        JSONObject response = new JSONObject();
        commonOrderMapper.selectOrder(userUuid,orderNo);
        response.put("total", page.getTotal());
        response.put("response", page.getResult());
        return response;
    }
}
