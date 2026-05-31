package com.jcaa.usersmanagement.application;

import java.util.List;
import java.util.Optional;

public class SurveyService {
    private final SurveyRepository surveyRepository;

    public <SurveyRepository> SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    // Create
    public Survey createSurvey(Survey survey) {
        if(survey.getTitle() == null || survey.getTitle().isEmpty()) {
            throw new IllegalArgumentException("El título es obligatorio");
        }
        return surveyRepository.save(survey);
    }

    // Read
    public Optional<Survey> findSurveyById(Long id) {
        return surveyRepository.findById(id);
    }

    // Update
    public Survey updateSurvey(Long id, Survey updatedSurvey) {
        Survey existing = surveyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Encuesta no encontrada"));
        existing.setTitle(updatedSurvey.getTitle());
        existing.setDescription(updatedSurvey.getDescription());
        return surveyRepository.save(existing);
    }

    // Delete
    public void deleteSurvey(Long id) {
        surveyRepository.deleteById(id);
    }

    // List
    public List<Survey> listAllSurveys() {
        return surveyRepository.findAll();
    }
}
