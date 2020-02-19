package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.jena;

import java.io.InputStream;
import java.util.ArrayList;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.shared.JenaException;
import com.hp.hpl.jena.util.FileManager;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.dto.FindAnswerDTO;
import com.pravnainformatikasemantickiweb.questionanswerlegaldoc.sparqlQuestion.dto.FindAnswerQuestionParameterDTO;

public class ExecuteQuery {
	
	final static String inputFileName = "src/main/resources/ontology/test.rdf";

	//final String BASE = "PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/SerbianLaw.owl#>";
	//final String LKIF = "PREFIX lkif: <http://www.estrellaproject.org/lkif-core/expression.owl#>";

    static final Model model = getOntologyModel(inputFileName);
    
    public ExecuteQuery() {
    	
    }

    public String execute(FindAnswerDTO findAnswerDTO){
    	
    	String sparqlQuestion = findAnswerDTO.getQuestion().getSparqlQueryText();
    	for (FindAnswerQuestionParameterDTO faqpDTO : findAnswerDTO.getParameters()) {
			String param = getParamValue(faqpDTO);
			sparqlQuestion = sparqlQuestion.replaceFirst("\\?\\?\\?", param);
		}
    	
    	
    	if (!sparqlQuestion.toLowerCase().contains("select")) {
    		return Boolean.toString(queryAsk(model, sparqlQuestion));
    	}
    	
    	ArrayList<String> resultSet;
		try {
			resultSet = querySelect(model, sparqlQuestion);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "";
		}    	
    	
    	return resultSet.toString();
    }
    
    private String getParamValue(FindAnswerQuestionParameterDTO faqpDTO) {
		switch (faqpDTO.getQuestionProperty().getQuestionPropertyType()) {
		case "Number":
			return Integer.toString(faqpDTO.getNumberInput());
		case "Text":
			return faqpDTO.getTextInput();
		case "Boolean":
			return Boolean.toString(faqpDTO.isBooleanInput());

		default:
			return "";
		}
	}


	private ArrayList<String> querySelect(Model model, String query) throws Exception {
	    QueryExecution qexec = QueryExecutionFactory.create(query, model);
	    ResultSet results = qexec.execSelect();
	    ArrayList<String> returnParams = getReturnParams(query);
	    
	    ArrayList<String> answer = new ArrayList<String>();
	    while(results.hasNext()){
	    	QuerySolution t = results.nextSolution();
	    	String s;
	    	
	    	for (String retParam : returnParams) {
	    		RDFNode x  = t.get(retParam);
		    	if (x!=null) {
		    		s = x.toString();
			    	if (s.contains("^^http")) {
			    		answer.add(s.substring(0, s.indexOf("^^http")));
			    	} else if (s.startsWith("https://github.com")){
			    		answer.add(s.substring(s.indexOf("#")+1));
			    	} else {
			    		answer.add(s);
			    	}
		    	}
			}
	    }
	    qexec.close();
	    
	    return answer;
	}
	
	
	private ArrayList<String> getReturnParams(String query) {
		String s = query.substring(query.toLowerCase().indexOf("select") + 7, query.toLowerCase().indexOf("where")-1);
		ArrayList<String> paramNames = new ArrayList<>();
		
		for (String substrings : s.split(" ")) {
			paramNames.add(substrings.trim().replace("?", ""));
		}
		
		return paramNames;
	}

	private boolean queryAsk(Model model, String query) {
		QueryExecution qexec = QueryExecutionFactory.create(query, model) ;
		boolean b = qexec.execAsk();
		return b;
	}
	
	private static OntModel getOntologyModel(String ontoFile)
	{   
	    OntModel ontoModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
	    try 
	    {
	        InputStream in = FileManager.get().open(ontoFile);
	        try 
	        {
	            ontoModel.read(in, null);
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	    } 
	    catch (JenaException je) 
	    {
	        System.err.println("ERROR" + je.getMessage());
	        je.printStackTrace();
	    }
	    return ontoModel;
	}
}
