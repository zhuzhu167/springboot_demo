package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserCommodityIntroductionVO;
import cn.ykthink.jewelry.orm.pc.PcCommodityMapper;
import cn.ykthink.jewelry.service.pc.PcCommodityService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public ResponseEntity<Object> commodityIntroduction() {
        PcUserCommodityIntroductionVO pcUserCommodityIntroductionVO = pcCommodityMapper.selectCommodityIntroduction();
        return ResponseEntitySupport.success(pcUserCommodityIntroductionVO);
    }
}
