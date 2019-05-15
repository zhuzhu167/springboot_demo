package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import cn.ykthink.jewelry.model.pc.index.PcIndexCategoryVO;
import cn.ykthink.jewelry.orm.pc.PcIndexMapper;
import cn.ykthink.jewelry.service.pc.PcIndexService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: YK
 * Title: PcIndexServiceImpl
 * Description: 首页Service
 * Date: 2019/5/13
 * Time: 11:10
 */
@Service
public class PcIndexServiceImpl implements PcIndexService {
    @Resource
    PcIndexMapper pcIndexMapper;

    @Override
    public ResponseEntity<Object> category() {
        List<PcIndexCategoryVO> pcIndexCategoryVO = pcIndexMapper.selectIndexCategory();
        return ResponseEntitySupport.success(pcIndexCategoryVO);
    }
}
