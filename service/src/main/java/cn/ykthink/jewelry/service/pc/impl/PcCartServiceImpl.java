package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserCartVO;
import cn.ykthink.jewelry.orm.pc.PcCartMapper;
import cn.ykthink.jewelry.service.pc.PcCartService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * program: jewelry
 * description:PC购物车Service实现类
 * author: mi
 * create: 2019-05-09 17:00
 **/
@Service
public class PcCartServiceImpl implements PcCartService {
    @Resource
    PcCartMapper pcCartMapper;

    @Override
    public ResponseEntity<Object> cart(Integer pageNum, Integer pageSize) {
        String userUuid = JWTokenUtil.validateJWToken(JWTokenUtil.getRequestHeader("X-Access-Token"), "uuid");
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        JSONObject response = new JSONObject();
        pcCartMapper.selectCart(userUuid);
        response.put("total", page.getTotal());
        response.put("response", page.getResult());
        return ResponseEntitySupport.success(response);
    }
}
