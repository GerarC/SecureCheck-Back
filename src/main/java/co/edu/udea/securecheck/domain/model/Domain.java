package co.edu.udea.securecheck.domain.model;

import co.edu.udea.securecheck.domain.utils.Generated;

@Generated
public class Domain {
    private Long id;
    private Integer index;
    private String name;
    private String description;

    public Domain(Long id, Integer index, String name, String description) {
        this.id = id;
        this.index = index;
        this.name = name;
        this.description = description;
    }

    public Domain() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}