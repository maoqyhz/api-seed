package com.example.seed.common.support;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页数据包装类
 * @author Fururur
 * @create 2019-07-23-14:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Integer pageIndex;
    private Integer pageSize;
    private Long total;
    private List<T> items;

    public PageResult(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }
}
