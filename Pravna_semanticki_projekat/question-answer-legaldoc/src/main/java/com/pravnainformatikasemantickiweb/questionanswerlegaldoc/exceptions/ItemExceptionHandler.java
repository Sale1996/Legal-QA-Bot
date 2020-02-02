package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.exceptions;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.legalEntity.exceptions.LegalEntityNotFoundException;

import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.questionProperty.exceptions.QuestionPropertyNotFoundException;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.exceptions.SparqlQuestionNotFoundException;

@ControllerAdvice
public class ItemExceptionHandler {

    
    @ExceptionHandler(LegalEntityNotFoundException.class)
    public ResponseEntity<String> handleException(LegalEntityNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    
    @ExceptionHandler(QuestionPropertyNotFoundException.class)
    public ResponseEntity<String> handleException(QuestionPropertyNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    
    @ExceptionHandler(SparqlQuestionNotFoundException.class)
    public ResponseEntity<String> handleException(SparqlQuestionNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
