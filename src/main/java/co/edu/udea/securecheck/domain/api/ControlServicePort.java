package co.edu.udea.securecheck.domain.api;

import co.edu.udea.securecheck.domain.model.Control;
import co.edu.udea.securecheck.domain.utils.PageQuery;
import co.edu.udea.securecheck.domain.utils.Pagination;

public interface ControlServicePort {
    Pagination<Control> getControls(PageQuery pageQuery);
}
