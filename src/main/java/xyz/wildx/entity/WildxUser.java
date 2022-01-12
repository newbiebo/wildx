package xyz.wildx.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author wangbo
 * @since 2021-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "WildxUser对象", description = "")
public class WildxUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId("id")
    private Long id;

    @TableField("user_ip")
    private Long userIp;

    @TableField("user_name")
    private String userName;

    @TableField("nick")
    private String nick;

    @TableField("password")
    private String password;

    @TableField("jwt")
    private String jwt;

    @TableField("mail")
    private String mail;

    @TableField("head_portrait")
    private String headPortrait;

    @TableField("age")
    private String age;

    @TableField("birthday")
    private Date birthday;

    @TableField("mobile")
    private String mobile;

    @TableField("create_time")
    private Date createTime;

    @TableField("modify_time")
    private Date modifyTime;

    @TableField("remark")
    private String remark;

    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
