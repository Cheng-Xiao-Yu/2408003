package cn.tedu.ivos.user.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserSaveParam {
    //此处的id值会在更新用户时用到
    @ApiModelProperty(value = "用户id")
    private Long id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "性别")
    private String gender;
    @ApiModelProperty(value = "状态")
    private String status;
    @ApiModelProperty(value = "职级")
    private String level;//"10"员工 “20”经理 “30”总监 “40”总裁
    @ApiModelProperty(value = "直属领导id")
    private Long parentId;
}
