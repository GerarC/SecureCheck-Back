package co.edu.udea.securecheck.adapter.driving.rest.service.impl;

import co.edu.udea.securecheck.adapter.driving.rest.dto.request.QuestionRequest;
import co.edu.udea.securecheck.adapter.driving.rest.dto.response.QuestionResponse;
import co.edu.udea.securecheck.adapter.driving.rest.mapper.request.QuestionRequestMapper;
import co.edu.udea.securecheck.adapter.driving.rest.mapper.response.QuestionResponseMapper;
import co.edu.udea.securecheck.adapter.driving.rest.service.QuestionService;
import co.edu.udea.securecheck.domain.api.QuestionServicePort;
import co.edu.udea.securecheck.domain.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionServicePort questionServicePort;
    private final QuestionResponseMapper questionResponseMapper;
    private final QuestionRequestMapper questionRequestMapper;

    @Override
    public QuestionResponse createQuestion(QuestionRequest questionRequest) {
        Question question = questionRequestMapper.toDomain(questionRequest);
        return questionResponseMapper.toResponse(
                questionServicePort.save(question)
        );
    }
}
