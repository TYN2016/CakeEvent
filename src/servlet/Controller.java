package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import bean.EDbean;
import data.Model;


/**
 * Das Controller Servlet nimmt die Nutzer Eingaben entgegen 
 * und gibt die Eingaben an die Bean zur Bearbeitung der 
 * Sachlogik weiter. Für die Ausgabe wird der Request an
 * eine geeignete jsp weitergereicht. 
 *
 */
@WebServlet("/Controller")
public class Controller extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	 static final long serialVersionUID = 42L;
	 static Logger logger = Logger.getLogger(Controller.class);
	 static private boolean error = false;
	 
	public Controller() {
		super();
	}   	
	
	public void init(ServletConfig conf) throws ServletException{
		super.init(conf);
		String path = conf.getServletContext().getRealPath("/");
		PropertyConfigurator.configure(path+"log4j.properties");
		Controller.error	= false;
		try {
			EDbean.init(path);
		} catch (Exception e) {
			System.out.println("Controller.init  Einlesefehler oder Webservice nicht erreichbar");
			Controller.error = true;
		}
	}
    /**
	 * ruft doAction auf
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.doAction(request, response);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  	
	
	/**
	 * ruft doAction auf
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.doAction(request, response);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}   	  	    
	
	/**
	 * nimmt die Eingaben entgegen, reicht sie an die Bean
	 * zur Verarbeitung weiter. Zur Erzeugung einer Ausgabe
	 * werden Request und Response an eine jsp weitergeleitet.
	 * Jeder Request enthält einen Parameter action, der den 
	 * Bearbeitungs-Zustand angibt. Die aktuellen Zustände werden
	 * in einer Session gespeichert.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws CloneNotSupportedException 
	 */
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/plain");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();
		
		//Session besorgen
		EDbean model = null;
		model = (EDbean) session.getAttribute("ed");
		if(model == null){
			model = new EDbean();
			session.setAttribute("ed",model);
		}

		// Bestimmung des aktuellen Nutzers
		String nutzer = null;
		if(EDbean.ProduktionSyst) nutzer = request.getRemoteUser();
		else nutzer = request.getParameter("nutzer");
		
		//Verteiler
		String action = request.getParameter("action");
		String target = null;
		RequestDispatcher dispacher = null;

		if(Controller.error){
			writer.println("Einlesefehler oder Webservice nicht erreichbar");
			writer.println("Webservice:\t"+	EDbean.WebService);
			writer.println("CmplModel:\t"+	EDbean.CmplModel);
			writer.println("ModelDir:\t"+	EDbean.ModelDir);
			writer.println("ProdSyst:\t"+	EDbean.ProduktionSyst);
		
			
		/*
		 * login.jsp
		 * nutzer
		 * Gast
		 */
			
		}else if(action == null){
			//Einstiegspunkt	
			if(nutzer != null){
			    model.setNutzer(nutzer);
			    target = "welcome.jsp";
			    //target = "02_selectModel.jsp";
			    dispacher = request.getRequestDispatcher(target);
			    dispacher.forward(request, response);
			}else{
				model.setNutzer("Gast");
				target = "02_selectModel.jsp";
				dispacher = request.getRequestDispatcher(target);
				dispacher.forward(request, response);
		   }
			
			
			
	    }else if(action.equals("00_Abmelden")){
			//Session ungültig setzen
			session.invalidate();
			target = "login.jsp";
			dispacher = request.getRequestDispatcher(target);
			dispacher.forward(request, response);
		}
		
		else if(action.equals("02_selectModel")){
			target = "02_selectModel.jsp";
			dispacher = request.getRequestDispatcher(target);
			dispacher.forward(request, response);
		}
		
		
		/*
		 * else if(action.equals("03_showModel")){
		    String modelId = request.getParameter("modelId");
			model.setModel(modelId);
			target = "03_showModel.jsp";
			dispacher = request.getRequestDispatcher(target);
			dispacher.forward(request, response);
		}
		 */
		else if(action.equals("03_showModel")){
			String modelId = request.getParameter("modelId");
			model.setModel(modelId);
			target = "03_showModel.jsp";
			dispacher = request.getRequestDispatcher(target);
			dispacher.forward(request, response);
		}
		
		
		
		else if(action.equals("10_solveModel")){
			String modelId = request.getParameter("modelId");
			model.setModel(modelId);
			model.resetSolution();
			model.save();
			model.solve();
			model.save();
			target = "03_showModel.jsp";
			dispacher = request.getRequestDispatcher(target);
			dispacher.forward(request, response);
		}
		
		
		
		else if(action.equals("11_saveModel")){
			String modelId = request.getParameter("modelId");
			model.setModel(modelId);
			model.save();
			target = "02_selectModel.jsp";
			dispacher = request.getRequestDispatcher(target);
			dispacher.forward(request, response);
		}
		else if(action.equals("14_addModel")){
			String modelId 			= request.getParameter("modelId");
			String modelName 		= request.getParameter("modelName");
			model.addModel(modelId, modelName);
			target = "02_selectModel.jsp";
			dispacher = request.getRequestDispatcher(target);
			dispacher.forward(request, response);
		}
		
		else if(action.equals("15_removeModel")){
			String modelId 			= request.getParameter("modelId");
			model.removeModel(modelId);
			target = "02_selectModel.jsp";
			dispacher = request.getRequestDispatcher(target);
			dispacher.forward(request, response);
		}
		
		/*
		else if(action.equals("kopyModel")){
			String modelId 			= request.getParameter("modelId");
			String modelName 		= request.getParameter("modelName");
			
			model.addModel(modelId, modelName);
			model.copyModel(modelId, modelName);
			target = "02_selectModel.jsp";
			dispacher = request.getRequestDispatcher(target);
			dispacher.forward(request, response);
		}
		*/
		else if(action.equals("kopyModel")){
			String modelId = request.getParameter("modelId");
			model.setModel(modelId);
			//new Model(modelId).clone();
			target = "02_selectModel.jsp";
			dispacher = request.getRequestDispatcher(target);
			dispacher.forward(request, response);
			System.out.println(new Model(modelId).clone());
		}
		
		
		  
		    else if(action.equals("kopyModel2")){
		   
		
			String modelId = request.getParameter("modelId");
			model.setModel(modelId);
			model.copyModel2();
			target = "02_selectModel.jsp";
			dispacher = request.getRequestDispatcher(target);
			dispacher.forward(request, response);
			System.out.println(model.copyModel2());
		}
	   
		   
		
		
		else{
			writer.println("Error: action= "+action);
		}
		writer.println("Hier ist Controller");
		writer.close();
	}
	
	/**
	 * Die Werte der Parameter name_0 ... name_length werden zu einem Array
	 * zusammengefasst.
	 * @param req
	 * @param name
	 * @param length
	 * @return
	 */
	private String[] getArray(HttpServletRequest req, String name, int length){
		String[] out = new String[length];
		for(int i=0; i<length; i++){
			out[i] = req.getParameter(name+"_"+i);
		}
		return out;
	}
	
	/**
	 * Die Werte der Parameter name_0_0 ... name_lengthRow_lengthCol werden zu einer Matrix
	 * zusammengefasst.
	 * @param req
	 * @param name
	 * @param lengthRow
	 * @param lengthCol
	 * @return
	 */
	private String[][] getMatrix(HttpServletRequest req, String name, int lengthRow, int lengthCol){
		String[][] out = new String[lengthRow][lengthCol];
		for(int i=0; i<lengthRow; i++){
			for(int j=0; j<lengthCol; j++){
				out[i][j] = req.getParameter(name+"_"+i+"_"+j);
				//System.out.println("i: "+i+"  j: "+j+" value: "+out[i][j]);
			}
		}
		return out;
	}
	
}





 
	
	