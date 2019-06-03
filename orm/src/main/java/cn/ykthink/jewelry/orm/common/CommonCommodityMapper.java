package cn.ykthink.jewelry.orm.common;

import cn.ykthink.jewelry.model.common.vo.CommonCommodityListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: YK
 * Title: CommodityMapper
 * Description: 公用商品Mapper
 * Date: 2019/6/3
 * Time: 23:52
 */
@Mapper
@Repository
public interface CommonCommodityMapper {
    /**
     * 商品列表
     * @return
     */
    List<CommonCommodityListVO> selectCommodityIntroduction(@Param("categoryUuid") String categoryUuid);
}
