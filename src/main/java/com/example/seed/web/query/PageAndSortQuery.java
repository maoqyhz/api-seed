package com.example.seed.web.query;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author mqy6289
 * @date 2021/5/14-14:21
 */
@Data
public class PageAndSortQuery {
    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码最小值为 1")
    protected Integer pageIndex;
    @NotNull(message = "分页大小不能为空")
    @Range(min = 1, max = 200, message = "条数范围为 [1, 200]")
    protected Integer pageSize;

    protected String sortField;
    protected String order = ORDER_DESC;

    public static final String ORDER_ASC = "asc";
    public static final String ORDER_DESC = "desc";
}
