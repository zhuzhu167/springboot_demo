package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import cn.ykthink.jewelry.model.common.po.CartCommodityPO;
import cn.ykthink.jewelry.model.common.po.CartJewelryPO;
import cn.ykthink.jewelry.model.pc.commodity.bo.PcCommodityJewelryBO;
import cn.ykthink.jewelry.model.common.vo.CommonCommodityInfoVO;
import cn.ykthink.jewelry.model.common.vo.CommonJewelryInfoVO;
import cn.ykthink.jewelry.orm.common.CommonCommodityMapper;
import cn.ykthink.jewelry.orm.pc.PcCommodityMapper;
import cn.ykthink.jewelry.service.common.CommonCommodityService;
import cn.ykthink.jewelry.service.pc.PcCommodityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    CommonCommodityService commonCommodityService;
    @Resource
    PcCommodityMapper pcCommodityMapper;
    @Resource
    CommonCommodityMapper commonCommodityMapper;


    @Override
    public ResponseEntity<Object> commodityList(String categoryUuid, Integer pageNum, Integer pageSize) {
        return ResponseEntitySupport.success(commonCommodityService.commodityList(categoryUuid, pageNum, pageSize));
    }

    @Override
    public ResponseEntity<Object> commodity(String commodityUuid) {
        return ResponseEntitySupport.success(commonCommodityService.commodity(commodityUuid));
    }

    @Override
    public ResponseEntity<Object> jewelryList(Integer pageNum, Integer pageSize) {
        return ResponseEntitySupport.success(commonCommodityService.jewelryList(pageNum, pageSize));
    }

    @Override
    public ResponseEntity<Object> jewelryInfo(String jewelryUuid) {
        return ResponseEntitySupport.success(commonCommodityService.jewelryInfo(jewelryUuid));
    }

    @Override
    @Transactional
    public ResponseEntity<Object> commodityJewelry(PcCommodityJewelryBO body) {
        String userUuid = JWTokenUtil.getJWTokenUuid();
        CartJewelryPO cartJewelryPO = new CartJewelryPO();
        CartCommodityPO cartCommodityPO = new CartCommodityPO();

        CommonJewelryInfoVO commonJewelryInfoVO = commonCommodityMapper.selectJewelry(body.getJewelryUuid());
        CommonCommodityInfoVO commonCommodityInfoVO = commonCommodityMapper.selectCommodity(body.getCommodityUuid());

        cartJewelryPO.setJewelryUuid(body.getJewelryUuid());
        cartJewelryPO.setJewelryNo(commonJewelryInfoVO.getJewelryNo());
        cartJewelryPO.setClarity(commonJewelryInfoVO.getClarity());
        cartJewelryPO.setColor(commonJewelryInfoVO.getColor());
        cartJewelryPO.setCut(commonJewelryInfoVO.getCut());
        cartJewelryPO.setLight(commonJewelryInfoVO.getLight());
        cartJewelryPO.setPolishing(commonJewelryInfoVO.getPolishing());
        cartJewelryPO.setShape(commonJewelryInfoVO.getShape());
        cartJewelryPO.setUserUuid(userUuid);


        Integer insertJewelryFlag = pcCommodityMapper.insertJewelry(cartJewelryPO);
        cartCommodityPO.setCommodityNo(commonCommodityInfoVO.getCommodityNo());
        cartCommodityPO.setDetail(commonCommodityInfoVO.getDetail());
        cartCommodityPO.setTitle(commonCommodityInfoVO.getTitle());
        cartCommodityPO.setSubhead(commonCommodityInfoVO.getSubhead());
        cartCommodityPO.setTextureName(commonCommodityInfoVO.getTextureName());
        cartCommodityPO.setSize(body.getSize());
        cartCommodityPO.setCommodityUuid(body.getCommodityUuid());
        cartCommodityPO.setUserUuid(userUuid);
        cartCommodityPO.setCartJewelryUuid(cartJewelryPO.getUuid());

        Integer insertCommodityFlag = pcCommodityMapper.insertCommodity(cartCommodityPO);

        if (insertCommodityFlag > 0 && insertJewelryFlag > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "数据异常", "Abnormal data");
        }

    }


}
