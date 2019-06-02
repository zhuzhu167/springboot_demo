package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import cn.ykthink.jewelry.model.comm.po.CartCommodityPO;
import cn.ykthink.jewelry.model.comm.po.CartJewelryPO;
import cn.ykthink.jewelry.model.pc.commodity.bo.PcCommodityJewelryBO;
import cn.ykthink.jewelry.model.pc.commodity.vo.PcCommodityInfoVO;
import cn.ykthink.jewelry.model.pc.commodity.vo.PcJewelryInfoVO;
import cn.ykthink.jewelry.orm.pc.PcCommodityMapper;
import cn.ykthink.jewelry.service.pc.PcCommodityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
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
        PcCommodityInfoVO pcCommodityInfoVO = pcCommodityMapper.selectCommodity(commodityUuid);
        return ResponseEntitySupport.success(pcCommodityInfoVO);
    }

    @Override
    public ResponseEntity<Object> jewelryIntroduction(Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        JSONObject response = new JSONObject();
        pcCommodityMapper.selectJewelryIntroduction();
        response.put("total", page.getTotal());
        response.put("response", page.getResult());
        return ResponseEntitySupport.success(response);
    }

    @Override
    public ResponseEntity<Object> jewelryInfo(String jewelryUuid) {
        PcJewelryInfoVO pcJewelryInfoVO = pcCommodityMapper.selectJewelry(jewelryUuid);
        return ResponseEntitySupport.success(pcJewelryInfoVO);
    }

    @Override
    @Transactional
    public ResponseEntity<Object> commodityJewelry(PcCommodityJewelryBO body) {
        String userUuid = JWTokenUtil.getJWTokenUuid();
        CartJewelryPO cartJewelryPO = new CartJewelryPO();
        CartCommodityPO cartCommodityPO = new CartCommodityPO();

        PcJewelryInfoVO pcJewelryInfoVO = pcCommodityMapper.selectJewelry(body.getJewelryUuid());
        PcCommodityInfoVO pcCommodityInfoVO = pcCommodityMapper.selectCommodity(body.getCommodityUuid());

        cartJewelryPO.setJewelryUuid(body.getJewelryUuid());
        cartJewelryPO.setJewelryNo(pcJewelryInfoVO.getJewelryNo());
        cartJewelryPO.setClarity(pcJewelryInfoVO.getClarity());
        cartJewelryPO.setColor(pcJewelryInfoVO.getColor());
        cartJewelryPO.setCut(pcJewelryInfoVO.getCut());
        cartJewelryPO.setLight(pcJewelryInfoVO.getLight());
        cartJewelryPO.setPolishing(pcJewelryInfoVO.getPolishing());
        cartJewelryPO.setShape(pcJewelryInfoVO.getShape());
        cartJewelryPO.setUserUuid(userUuid);


        Integer insertJewelryFlag = pcCommodityMapper.insertJewelry(cartJewelryPO);
        cartCommodityPO.setCommodityNo(pcCommodityInfoVO.getCommodityNo());
        cartCommodityPO.setDetail(pcCommodityInfoVO.getDetail());
        cartCommodityPO.setTitle(pcCommodityInfoVO.getTitle());
        cartCommodityPO.setSubhead(pcCommodityInfoVO.getSubhead());
        cartCommodityPO.setTextureName(pcCommodityInfoVO.getTextureName());
        cartCommodityPO.setSize(body.getSize());
        cartCommodityPO.setCommodityUuid(body.getCommodityUuid());
        cartCommodityPO.setUserUuid(userUuid);
        cartCommodityPO.setCartJewelryUuid(cartJewelryPO.getUuid());

        Integer insertCommodityFlag = pcCommodityMapper.insertCommodity(cartCommodityPO);

        if (insertCommodityFlag > 0 && insertJewelryFlag > 0){
            return  ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "数据异常", "Abnormal data");
        }

    }


}
