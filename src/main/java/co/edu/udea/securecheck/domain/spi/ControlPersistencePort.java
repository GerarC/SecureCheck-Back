package co.edu.udea.securecheck.domain.spi;

import co.edu.udea.securecheck.domain.model.Control;
import co.edu.udea.securecheck.domain.utils.pagination.PageQuery;
import co.edu.udea.securecheck.domain.utils.pagination.Pagination;

public interface ControlPersistencePort {
    Pagination<Control> getControls(PageQuery pageQuery);
    boolean existsById(Long id);
}
