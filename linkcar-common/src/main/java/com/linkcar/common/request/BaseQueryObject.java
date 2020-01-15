package com.linkcar.common.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panzheng
 * @description 分页基类
 * @date 2019/8/20 11:29
 */
@Getter
@Setter
public class BaseQueryObject extends BaseRequestVO {
    private static final long serialVersionUID = 8282471939948981137L;

    /**
     * 查询的结果
     */
    private List<?> list = new ArrayList();

    /**
     * 当前页面
     */
    private Integer pageNo = 1;

    /**
     * 页面容量
     */
    private Integer pageSize = 10;

    /**
     * 第一页
     */
    private Integer firstPage = 1;

    /**
     * 总页数
     */
    private Integer pageCount;

    /**
     * 上一页
     */
    private Integer prePage;

    /**
     * 下一页
     */
    private Integer nextPage;

    /**
     * 总条数
     */
    private Integer total;

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 计算页面信息
     */
    public void calcPageInfo(Integer recordCount) {
        // 计算末页: 必须知道数据库的总记录数
        pageCount = (recordCount + pageSize - 1) / pageSize;

        if (pageCount < 1) {
            pageCount = 1;
        }

        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > pageCount) {
            pageNo = pageCount;
        }

        // 计算上一页
        prePage = pageNo - 1 <= 0 ? 1 : pageNo - 1;
        // 计算下一页
        nextPage = pageNo + 1 > pageCount ? pageCount : pageNo + 1;
    }

    /**
     * 开始查询的下标
     */
    public Integer getBegin() {
        return (pageNo - 1) * pageSize;
    }

    @Override
    public String toString() {
        return "QueryObject [pageNo=" + pageNo + ", pageSize=" + pageSize + ", firstPage=" + firstPage + ", pageCount=" + pageCount + ", prePage="
                + prePage + ", nextPage=" + nextPage + "]";
    }
}
