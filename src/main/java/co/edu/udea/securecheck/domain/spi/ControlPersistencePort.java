package co.edu.udea.securecheck.domain.spi;

import co.edu.udea.securecheck.domain.model.Control;
import co.edu.udea.securecheck.domain.model.Domain;
import co.edu.udea.securecheck.domain.utils.PageQuery;
import co.edu.udea.securecheck.domain.utils.Pagination;

import java.util.List;

public interface ControlPersistencePort {
    Pagination<Control> getControls(PageQuery pageQuery);
}
