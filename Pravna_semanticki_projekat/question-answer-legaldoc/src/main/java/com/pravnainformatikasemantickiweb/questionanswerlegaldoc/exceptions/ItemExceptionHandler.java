package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.exceptions;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyEntity.exceptions.OntologyEntityNotFoundException;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.ontologyParameter.exceptions.OntologyParameterNotFoundException;

@ControllerAdvice
public class ItemExceptionHandler {

    
    @ExceptionHandler(OntologyEntityNotFoundException.class)
    public ResponseEntity<String> handleException(OntologyEntityNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    
    @ExceptionHandler(OntologyParameterNotFoundException.class)
    public ResponseEntity<String> handleException(OntologyParameterNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
