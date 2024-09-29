package co.edu.udea.securecheck.domain.api;

import co.edu.udea.securecheck.domain.model.Question;

public interface QuestionServicePort {
    Question save(Question question);
}
