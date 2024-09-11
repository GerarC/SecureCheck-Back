package co.edu.udea.securecheck.domain.api.usecase;

import co.edu.udea.securecheck.domain.api.ControlServicePort;
import co.edu.udea.securecheck.domain.model.Control;
import co.edu.udea.securecheck.domain.spi.ControlPersistencePort;
import co.edu.udea.securecheck.domain.utils.PageQuery;
import co.edu.udea.securecheck.domain.utils.Pagination;

public class ControlUseCase implements ControlServicePort {
    private final ControlPersistencePort controlPersistencePort;

    public ControlUseCase(ControlPersistencePort controlPersistencePort) {
        this.controlPersistencePort = controlPersistencePort;
    }

    @Override
    public Pagination<Control> getControls(PageQuery pageQuery) {
        return controlPersistencePort.getControls(pageQuery);
    }
}
