package cn.ykthink.jewelry.model.common.vo;

import cn.ykthink.jewelry.model.common.vo.CommonCommodityImageVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Author: YK
 * Title: PcCommodityJewelryIntroductionVO
 * Description: 钻石列表
 * Date: 2019/5/17
 * Time: 8:34
 */
@Data
public class CommonJewelryListVO {
    @ApiModelProperty(value = "钻石uuid", name = "jewelryUuid", example = "a123", dataType = "String", required = true)
    private String jewelryUuid;

    @ApiModelProperty(value = "钻石编号", name = "jewelryNo", example = "a123", dataType = "String", required = true)
    private String jewelryNo;

    @ApiModelProperty(value = "价格", name = "jewelryPrice", example = "a123", dataType = "String", required = true)
    private BigDecimal jewelryPrice;

    @ApiModelProperty(value = "切工", name = "cut", example = "a123", dataType = "String", required = true)
    private String cut;

    @ApiModelProperty(value = "荧光", name = "light", example = "a123", dataType = "String", required = true)
    private String light;

    @ApiModelProperty(value = "抛光", name = "polishing", example = "a123", dataType = "String", required = true)
    private String polishing;

    @ApiModelProperty(value = "图片list", name = "imageUuidList", example = "", dataType = "List", required = true)
    private List<CommonCommodityImageVO> imageList;
}
