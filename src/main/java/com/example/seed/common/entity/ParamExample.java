package com.example.seed.common.entity;

import com.example.seed.common.entity.validate.NewEntity;
import com.example.seed.common.entity.validate.UpdateEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

/**
 * @author Fururur
 * @date 2020-03-16-10:05
 */
@Data
public class ParamExample {
    @NotNull(message = "项目ID不能为空", groups = {UpdateEntity.class})
    private Integer id;
    @Pattern(regexp = "^\\d{5}-*\\d*$", message = "已立项项目请输入合法的5位数字项目号")
    private String num;
    @NotBlank(message = "项目名称不能为空")
    private String name;
    @NotNull(message = "项目创建位置不能为空", groups = {NewEntity.class})
    private String savedLocation;
    @Pattern(regexp = "[a-zA-z]+://[^\\s]*", message = "项目地址格式不正确,请输入合法的doc-server项目URL")
    private String url;
    @NotNull(message = "项目类型不能为空", groups = {NewEntity.class})
    private Integer type;
    @NotNull(message = "项目成员不能为null")
    private Set<Integer> members;
    private Set<Integer> qaMembers;
    private String introduction;
    private Integer qaDirWrite;
    @NotNull(message = "项目所有者不能为空", groups = {NewEntity.class})
    private Integer owner;
}