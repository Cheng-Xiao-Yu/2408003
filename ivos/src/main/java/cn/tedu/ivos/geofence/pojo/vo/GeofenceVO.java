package cn.tedu.ivos.geofence.pojo.vo;

import cn.tedu.ivos.vehicle.pojo.vo.VehicleVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GeofenceVO {
    @ApiModelProperty(value = "电子围栏编号")
    private Long id;
    @ApiModelProperty(value = "电子围栏名称")
    private String name;
    @ApiModelProperty(value = "电子围栏状态")
    private String status;
    @ApiModelProperty(value = "电子围栏位置数据")
    private String position;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /* 下面的这3个字段是车辆分配时需要使用的值:查看对应围栏下的车辆数据 */
    @ApiModelProperty(value = "围栏绑定车辆总数")
    private Integer totalNum;
    @ApiModelProperty(value = "围栏可用车辆数")
    private Integer availableNum;
    @ApiModelProperty(value = "围栏绑定车辆列表")
    private List<VehicleVO> vehicleList;
}
