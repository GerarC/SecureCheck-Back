package co.edu.udea.securecheck.adapter.driven.jpa.adapters;

import co.edu.udea.securecheck.adapter.driven.jpa.mapper.ControlEntityMapper;
import co.edu.udea.securecheck.adapter.driven.jpa.mapper.PaginationJPAMapper;
import co.edu.udea.securecheck.adapter.driven.jpa.repository.ControlRepository;
import co.edu.udea.securecheck.domain.model.Control;
import co.edu.udea.securecheck.domain.spi.ControlPersistencePort;
import co.edu.udea.securecheck.domain.utils.PageQuery;
import co.edu.udea.securecheck.domain.utils.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ControlJpaAdapter implements ControlPersistencePort {
    private final ControlRepository controlRepository;
    private final ControlEntityMapper controlEntityMapper;
    private final PaginationJPAMapper paginationJPAMapper;

    @Override
    public Pagination<Control> getControls(PageQuery pageQuery) {
        Pageable pageable = paginationJPAMapper
                .toJPA(pageQuery)
                .createPageable();
        return controlEntityMapper.toPagination(controlRepository.findAll(pageable));
    }
}
