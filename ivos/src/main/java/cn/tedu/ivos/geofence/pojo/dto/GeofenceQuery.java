package cn.tedu.ivos.geofence.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GeofenceQuery {
    @ApiModelProperty(value = "电子围栏编号")
    private Long id;
    @ApiModelProperty(value = "电子围栏名称")
    private String name;
    @ApiModelProperty(value = "电子围栏状态")
    private String status;
}
