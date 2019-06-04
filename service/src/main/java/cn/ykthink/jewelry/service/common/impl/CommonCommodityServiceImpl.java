package cn.ykthink.jewelry.service.common.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.model.common.vo.CommonCommodityInfoVO;
import cn.ykthink.jewelry.model.common.vo.CommonJewelryInfoVO;
import cn.ykthink.jewelry.orm.common.CommonCommodityMapper;
import cn.ykthink.jewelry.service.common.CommonCommodityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: YK
 * Title: CommonCommodityServiceImpl
 * Description: 公用商品service实现类
 * Date: 2019/6/3
 * Time: 23:49
 */
@Service
public class CommonCommodityServiceImpl implements CommonCommodityService {
    @Resource
    CommonCommodityMapper commonCommodityMapper;

    @Override
    public JSONObject commodityList(String categoryUuid, Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        JSONObject response = new JSONObject();
        commonCommodityMapper.selectCommodityIntroduction(categoryUuid);
        response.put("total", page.getTotal());
        response.put("response", page.getResult());
        return response;
    }

    @Override
    public CommonCommodityInfoVO commodity(String commodityUuid) {
        CommonCommodityInfoVO commonCommodityInfoVO = commonCommodityMapper.selectCommodity(commodityUuid);
        return commonCommodityInfoVO;
    }

    @Override
    public JSONObject jewelryList(Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        JSONObject response = new JSONObject();
        commonCommodityMapper.selectJewelryIntroduction();
        response.put("total", page.getTotal());
        response.put("response", page.getResult());
        return response;
    }

    @Override
    public CommonJewelryInfoVO jewelryInfo(String jewelryUuid) {
        CommonJewelryInfoVO commonJewelryInfoVO = commonCommodityMapper.selectJewelry(jewelryUuid);
        return commonJewelryInfoVO;
    }
}
