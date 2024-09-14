package co.edu.udea.securecheck.domain.utils;

@Generated
public class SortQuery {
    private String sortBy;
    private boolean ascending;

    public SortQuery(String sortBy, boolean ascending) {
        this.sortBy = Constants.DEFAULT_SORT_COLUMN;
        this.ascending = Constants.DEFAULT_ASCENDING;
        if(sortBy != null) this.sortBy = sortBy;
        if(ascending) this.ascending = true;
    }

    public String getSortBy() {
        return sortBy;
    }

    public boolean isAscending() {
        return ascending;
    }
}
