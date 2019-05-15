package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserCommodityInfoVO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserCommodityIntroductionVO;
import cn.ykthink.jewelry.orm.pc.PcCommodityMapper;
import cn.ykthink.jewelry.service.pc.PcCommodityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * program: jewelry
 * description:商品Service实现类
 * author: mi
 * create: 2019-05-14 17:42
 **/
@Service
public class PcCommodityServiceImpl implements PcCommodityService {
    @Resource
    PcCommodityMapper pcCommodityMapper;

    @Override
    public ResponseEntity<Object> commodityIntroduction(Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        JSONObject response = new JSONObject();
        pcCommodityMapper.selectCommodityIntroduction();
        response.put("total", page.getTotal());
        response.put("response", page.getResult());
        return ResponseEntitySupport.success(response);
    }

    @Override
    public ResponseEntity<Object> commodity(String commodityUuid) {
        PcUserCommodityInfoVO pcUserCommodityInfoVO = pcCommodityMapper.selectCommodity(commodityUuid);
        return ResponseEntitySupport.success(pcUserCommodityInfoVO);
    }
}
