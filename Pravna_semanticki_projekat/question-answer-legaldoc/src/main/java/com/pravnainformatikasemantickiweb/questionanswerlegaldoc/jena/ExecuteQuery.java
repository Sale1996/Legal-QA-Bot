package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.jena;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
	
	final static String inputFileName = "src/main/resources/ontology/Nova_ontologija_RDF.owl";

	final static String PREFIX = "PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/Nova_ontologija.owl#> "
			+ "PREFIX expression: <http://www.estrellaproject.org/lkif-core/expression.owl#> "
			+ "PREFIX mereology: <http://www.estrellaproject.org/lkif-core/mereology.owl#> "
			+ "PREFIX process: <http://www.estrellaproject.org/lkif-core/process.owl#> "
			+ "PREFIX norm: <http://www.estrellaproject.org/lkif-core/norm.owl#> "
			+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> ";
	
    static final Model model = getOntologyModel(inputFileName);
    
    public ExecuteQuery() {
    	
    }

    public String execute(FindAnswerDTO findAnswerDTO){
    	
    	String sparqlQuestion = PREFIX + findAnswerDTO.getQuestion().getSparqlQueryText();
    	for (FindAnswerQuestionParameterDTO faqpDTO : findAnswerDTO.getParameters()) {
			String param = getParamValue(faqpDTO);
			sparqlQuestion = sparqlQuestion.replaceFirst("\\?\\?\\?", param);
		}
    	
    	
    	if (!sparqlQuestion.toLowerCase().contains("select")) {
    		return Boolean.toString(queryAsk(model, sparqlQuestion));
    	}
    	
    	String resultSet;
		try {
			resultSet = querySelect(model, sparqlQuestion);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "";
		}    	
    	
    	return resultSet;
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


	private String querySelect(Model model, String query) throws Exception {

		QueryExecution qexec = QueryExecutionFactory.create(query, model);
	    ResultSet results = qexec.execSelect();
	    ArrayList<String> returnParams = getReturnParams(query);
	    Document document = getDocument("src/main/resources/ontology/Zakon_o_elektronskoj_trgovini.xml");
	    
	    ArrayList<String> answer = new ArrayList<String>();
	    
	    if (returnParams.size()==2) {
	    	answer.add("<tr>");
	    	answer.add("<th>");
	    	answer.add("Dispozicija");
	    	answer.add("</th>");
	    	answer.add("<th>");
	    	answer.add("Sankcija");
	    	answer.add("</th>");
	    	answer.add("</tr>");
	    }
	    
	    while(results.hasNext()){
	    	QuerySolution t = results.nextSolution();
	    	answer.add("<tr>");
	    	
	    	//jedan row tabele
	    	for (String retParam : returnParams) {
	    		answer.add("<td>");
	    		
	    		String cell = getOneCell(retParam, t, document);
	    		answer.add(cell.trim());
	    		
	    		answer.add("</td>");
	    	}
	    	
	    	answer.add("</tr>");
	    }
	    qexec.close();
	    
	    String retVal = "<html><body><table>" + parseList(answer) + "</table></body></html>";
	    return retVal;
	}
	
	
	private String parseList(List<String> answer) {
		String retString = "";
		for (String part : answer) {
			retString += part;
		}
		return retString;
	}

	private String getOneCell(String retParam, QuerySolution t, Document document) {
		String s;
		RDFNode x  = t.get(retParam);
    	if (x!=null) {
    		s = x.toString();
	    	if (s.contains("^^http")) {
	    		return s.substring(0, s.indexOf("^^http"));
	    	} else if (s.startsWith("https://github.com")){
	    		if (s.contains("Zakon_o_elektronskoj_trgovini.xml")) {
	    			//sistem je vratio akoma-ntoso format
	    			try {
	    				//pronadji xml cvor sa datim eId
	    				String xpathExpression = "//*[@eId='" + s.substring(s.lastIndexOf("#")+1) + "']";
	    				
	    				return parseList(evaluateXPath(document, xpathExpression));
	    			} catch (Exception e) {
	    				e.printStackTrace();
	    			}
	    		} else {
	    			//sistem je vratio objekat
	    			return s.substring(s.indexOf("#")+1);
	    		}
	    	} else {
	    		return s;
	    	}
    	}
    	return "";
	}

	private static List<String> evaluateXPath(Document document, String xpathExpression) throws Exception {
		// Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();
         
        // Create XPath object
        XPath xpath = xpathFactory.newXPath();
 
        List<String> values = new ArrayList<>();
        try
        {
            // Create XPathExpression object
            XPathExpression expr = xpath.compile(xpathExpression);
             
            // Evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
             
            for (int i = 0; i < nodes.getLength(); i++) {
            	Node n = nodes.item(i);
            	NodeList childNodes = n.getChildNodes();
            	for (int j = 0; j < childNodes.getLength(); j++) {
					Node child = childNodes.item(j);
					values.add("<p>");
					values.add(child.getTextContent().replaceAll("\\n                        \\n", "<pre></pre>").trim());
					values.add("</p>");
				}
            }
                 
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return values;
    }

	private Document getDocument(String fileName) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fileName);
        return doc;
	}

	private ArrayList<String> getReturnParams(String query) {
		String s = query.substring(query.toLowerCase().indexOf("select") + 7, query.toLowerCase().indexOf("where")-1);
		ArrayList<String> paramNames = new ArrayList<>();
		
		for (String substrings : s.split(" ")) {
			paramNames.add(substrings.trim().replace("?", ""));
		}
		paramNames.remove("DISTINCT");
		paramNames.remove("distinct");
		
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
