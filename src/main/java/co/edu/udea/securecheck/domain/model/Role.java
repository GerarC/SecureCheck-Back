package co.edu.udea.securecheck.domain.model;

import co.edu.udea.securecheck.domain.utils.Generated;
import co.edu.udea.securecheck.domain.utils.RoleName;

@Generated
public class Role {
    private Long id;
    private RoleName name;

    public Role(Long id, RoleName name) {
        this.id = id;
        this.name = name;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
