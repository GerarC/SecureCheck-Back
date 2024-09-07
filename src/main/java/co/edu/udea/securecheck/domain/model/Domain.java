package co.edu.udea.securecheck.domain.model;

public class Domain {
    private Long id;
    private String name;
    private String description;

    public Domain(Long id, String name, String description) {
        this.id = id;
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