package cn.tedu.ivos.geofence.pojo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Geofence {
    @ApiModelProperty(value = "电子围栏编号")
    private Long id;
    @ApiModelProperty(value = "电子围栏名称")
    private String name;
    @ApiModelProperty(value = "电子围栏状态")
    private String status;
    @ApiModelProperty(value = "电子围栏位置数据")
    private String position;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}