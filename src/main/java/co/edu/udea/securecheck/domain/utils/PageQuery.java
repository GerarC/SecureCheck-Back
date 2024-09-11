package co.edu.udea.securecheck.domain.utils;

import java.util.Map;

public class PageQuery {
    Integer page;
    Integer size;
    String sortBy;
    boolean ascending;

    public PageQuery(Map<String, String> query) {
        page = 0;
        size = 10;
        sortBy = null;
        ascending = false;
        if(query == null) return;

        if(query.containsKey("page")) page = Integer.parseInt(query.get("page"));
        if(query.containsKey("size")) size = Integer.parseInt(query.get("size"));
        if(query.containsKey("sortBy")) sortBy = query.get("sortBy");
        if(query.containsKey("ascending")) ascending = Boolean.parseBoolean(query.get("ascending"));
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }
}
