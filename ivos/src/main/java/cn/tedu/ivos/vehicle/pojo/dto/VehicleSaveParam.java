package cn.tedu.ivos.vehicle.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class VehicleSaveParam {
    @ApiModelProperty(value = "车辆id")
    private Long id;
    @ApiModelProperty(value = "车辆品牌")
    private String brand;
    @ApiModelProperty(value = "车牌号")
    private String license;
    @ApiModelProperty(value = "车辆型号")
    private String model;
    @ApiModelProperty(value = "车辆识别码")
    private String code;
    @ApiModelProperty(value = "车辆排量")
    private String displacement;
    @ApiModelProperty(value = "车辆状态")
    private String status;
    @ApiModelProperty(value = "车辆类型")
    private String type;
    @ApiModelProperty(value = "车辆颜色")
    private String color;
    @ApiModelProperty(value = "车辆里程数")
    private String kilometers;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "车辆上牌时间")
    private Date regTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "车辆购买时间")
    private Date buyTime;
    @ApiModelProperty(value = "车辆购买价格")
    private String price;
    @ApiModelProperty(value = "车辆电池类型")
    private String batteryType;
    @ApiModelProperty(value = "电子围栏绑定状态")
    private String geofenceBindStatus;
    @ApiModelProperty(value = "电子围栏id")
    private Long geofenceId;
}
