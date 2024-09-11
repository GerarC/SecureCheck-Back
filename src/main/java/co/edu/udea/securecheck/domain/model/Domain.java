package co.edu.udea.securecheck.domain.model;

import co.edu.udea.securecheck.domain.utils.Generated;

import java.util.Set;

@Generated
public class Domain {
    private Long id;
    private Integer index;
    private String name;
    private String description;
    private Set<Control> controls;

    public Domain(Long id, Integer index, String name, String description, Set<Control> controls) {
        this.id = id;
        this.index = index;
        this.name = name;
        this.description = description;
        this.controls = controls;
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

    public Set<Control> getControls() {
        return controls;
    }

    public void setControls(Set<Control> controls) {
        this.controls = controls;
    }
}