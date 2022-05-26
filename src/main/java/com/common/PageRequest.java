package com.common;

/**
 * page request
 * @Author: PengMvc
 * @Date: 2022/05/26/16:04
 */
public class PageRequest {

    private Integer pageNo ;

    private Integer pageSize;

    private Integer skip;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }
}
