package fr.gestionprojets.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import fr.gestionprojets.entity.Project;
import fr.gestionprojets.entity.Type;
import fr.gestionprojets.service.ProjectService;
import fr.gestionprojets.service.ProjectServiceImpl;
import fr.gestionprojets.service.TypeService;
import fr.gestionprojets.service.TypeServiceImpl;

@ManagedBean(name = "mbProject")
@ViewScoped
public class ProjectManagedBean {
	
	public Logger logger = Logger.getLogger(ProjectManagedBean.class);
	
	private ProjectService projectService = new ProjectServiceImpl();
	private TypeService typeService = new TypeServiceImpl();	

	private String title;
	private String description;
	private String budget;
	private String type;
	private String active;
	
	private boolean showForm;
	private String success;

	private List<SelectItem> typeList;
	
	private List<Project> projectList;

	private String id;
	private String operation;

	public ProjectManagedBean() {
	}

	@PostConstruct
	public void init() {
		System.out.println("Post Construct !");
		//showForm = false;
		
		// ##########  Préparer typeList  ########## 
		typeList = new ArrayList<SelectItem>();
		typeList.add(new SelectItem("", ""));
		
		List<Type> listeService = typeService.finAll();
		for (Type t : listeService) {
			typeList.add(new SelectItem(t.getId(), t.getName()));
		}
		
		// ##########  Préparer projectList  ##########
		projectList = projectService.finAll();
		
		System.out.println("id :" + getParam("id"));
		System.out.println("operation :" + getParam("operation"));
		
		if ("edit".equalsIgnoreCase(getParam("operation"))) {
			setOperation(getParam("operation"));
			Long id = null;
			Project project = null;
			try {
				id = Long.valueOf(getParam("id"));
				setId(getParam("id"));
			} catch (Exception e) {
				
			}
			if (id != null) {
				project = projectService.findById(id);
				if (project != null) {
					title = project.getTitle();
					description = project.getDescription();
					if (project.getBudget() != null) {
						budget = project.getBudget().toString();						
					}
					type = project.getTypeId() + "";
					active = project.getActive();
				}
			}
			
			showForm = true;
		}
	}
	
	public String getParam(String name) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get(name);
	}

	public void addProject(ActionEvent event) {

		success = "";
		if ("".equalsIgnoreCase(title)) {
			FacesContext.getCurrentInstance().addMessage("title", new FacesMessage("Titre est obligatoire !"));//autre façàn de gérer les validation
		}else {
			// add to database
			
			logger.info("Les valeurs : ");
			logger.info("   titre : " + title);
			logger.info("   description : " + description);
			logger.info("   budget : " + budget);
			logger.info("   type : " + type);
			logger.info("   active : " + active);

			Project p = null;

			System.out.println("Add project : " + operation + " - " + id);
			
			if ("edit".equalsIgnoreCase(operation)) {
				p = projectService.findById(new Long(id));
				System.out.println("edit");
			} else {
				p = new Project();		
				System.out.println("new");
			}
			p.setTitle(title);
			p.setDescription(description);
			p.setBudget(Double.valueOf(budget));
			p.setTypeId(Long.valueOf(type));
			p.setActive(active);
			
			projectService.add(p);
			
			success = "Les informations saisies ont été bien ajouter !";
			
			title = "";
			description = "";
			budget = "";
			type = "";
			active = "";
			id = "";
			operation = "";
			
			projectList = projectService.finAll();
		}

	}
	
	public void deleteProject(ActionEvent event) {
		logger.info("delete project");
		
		//####  passage de parametres dans la requete  ###
		FacesContext fc = FacesContext.getCurrentInstance();
		
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		logger.info("id : " + param.get("id"));
		//####    ###
		
		projectService.delete(new Long(param.get("id")));
		
		projectList = projectService.finAll();
		
	}
	
	public void showFormAction(ActionEvent event) {
		logger.info("true");
		showForm = true;
	}
	
	public void cancelFormAction(ActionEvent event) {
		logger.info("false");
		showForm = false;
	}
	
	public void generateDesription(ActionEvent event) {
		String desc = "";
		desc += "Le titre est : " + title + "\n";
		desc += "Le montant : " + budget + "\n";
		desc += "Active : " + ("Y".equals(active) ? "Oui": "Non");
		description = desc;
	}

	public void saveData(ActionEvent event) {
		logger.info("Le titre est : " + title);
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public List<SelectItem> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<SelectItem> typeList) {
		this.typeList = typeList;
	}

	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
