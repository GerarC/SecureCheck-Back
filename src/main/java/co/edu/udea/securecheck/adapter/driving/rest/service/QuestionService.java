package co.edu.udea.securecheck.adapter.driving.rest.service;

import co.edu.udea.securecheck.adapter.driving.rest.dto.request.QuestionRequest;
import co.edu.udea.securecheck.adapter.driving.rest.dto.response.QuestionResponse;

public interface QuestionService {
    QuestionResponse createQuestion(QuestionRequest questionRequest);
}
