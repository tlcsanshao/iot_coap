package org.example.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * author: sanshao
 * date: 2025/3/26
 * PageResult desc:
 */

@Data
@AllArgsConstructor
public class PageResult<T> {
    private int currentPage;
    private int pageSize;
    private long totalItems;
    private int totalPages;
    private List<T> items;

    public static <T> PageResult<T> of(Page<T> page) {
        return new PageResult<>(
                (int) page.getCurrent(), // MyBatis-Plus Page 使用 getCurrent() 获取当前页
                (int) page.getSize(),    // getSize() 获取每页大小
                page.getTotal(),         // getTotal() 获取总记录数
                (int) ((page.getTotal() + page.getSize() - 1) / page.getSize()), // 计算总页数
                page.getRecords()        // getRecords() 获取当前页数据列表
        );
    }
}