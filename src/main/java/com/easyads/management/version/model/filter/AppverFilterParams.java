package com.easyads.management.version.model.filter;


import java.util.Map;

public class AppverFilterParams {
    private Map<String, Object> queryParams;

    // 筛选参数及翻页参数
    public Integer mediaId;
    public String searchText;
    public Integer status;
    public Integer offset, limit, page;

    public AppverFilterParams(Map<String, Object> queryParams) {
        this.queryParams = queryParams;
        this.mediaId = queryParams.containsKey("mediaId") ? Integer.valueOf((String) queryParams.get("mediaId")) : null;
        this.searchText = (String) queryParams.getOrDefault("searchText", null);
        this.status = queryParams.containsKey("status") ? Integer.valueOf((String) queryParams.get("status")) : null;
        setLimit();
    }

    private void setLimit() {
        limit = queryParams.containsKey("limit") ? Integer.parseInt((String) queryParams.get("limit")) : null;
        page = queryParams.containsKey("page") ? Integer.parseInt((String) queryParams.get("page")) : null;
        if (limit != null && this.page != null) {
            offset = (page - 1) * limit;
        }
    }
}
