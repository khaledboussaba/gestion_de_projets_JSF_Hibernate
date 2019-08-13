package fr.gestionprojets.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;

import fr.gestionprojets.dao.entity.Project;
import fr.gestionprojets.dao.entity.Type;
import fr.gestionprojets.service.ProjectService;
import fr.gestionprojets.service.ProjectServiceImpl;
import fr.gestionprojets.service.TypeService;
import fr.gestionprojets.service.TypeServiceImpl;

@ManagedBean(name = "mbProject")
@RequestScoped
public class ProjectManagedBean {
	
	
	private ProjectService projectService = new ProjectServiceImpl();
	private TypeService typeService = new TypeServiceImpl();
	
	

	public Logger logger = Logger.getLogger(ProjectManagedBean.class);
	private String title;
	@Size(min = 2, max = 10, message = "Le nombre de caractère doit être compris entre 2 et 10 caractères")
	private String description;
	private String budget;
	private String type;
	@NotNull(message = "Projet actif ? (Oui / Non)") //autre façon de gérer les validations
	private String active;
	
	private String success = "";
	private boolean showForm;

	private List<SelectItem> typeList;
	
	private List<Project> projectList;

	static {
		System.out.println("block static !");
	}

	{
		System.out.println("block !");
	}

	public ProjectManagedBean() {
		System.out.println("Constructeur !");
	}

	@PostConstruct
	public void init() {
		System.out.println("Post Construct !");
		showForm = false;
		
		// ##########  Préparer typeList  ########## 
		typeList = new ArrayList<SelectItem>();
		typeList.add(new SelectItem("", ""));
//		typeList.add(new SelectItem(1, "Informatique"));
//		typeList.add(new SelectItem(2, "Commerce"));
//		typeList.add(new SelectItem(3, "Autre"));
		
		List<Type> listeService = typeService.finAll();
		for (Type t : listeService) {
			typeList.add(new SelectItem(t.getId(), t.getName()));
		}
		
		// ##########  Préparer projectList  ##########
		projectList = projectService.finAll();
		
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
						
			Project p = new Project();
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
	

	public void generateDesription(ActionEvent event) {
		String desc = "";
		desc += "Le titre est : " + title + "\n";
		desc += "Le montant : " + budget + "\n";
		desc += "Active : " + ("Y".equals(active) ? "Oui": "Non");
		description = desc;
	}
	
	public void showFormAction(ActionEvent event) {
		logger.info("true");
		showForm = true;
	}
	
	public void cancelFormAction(ActionEvent event) {
		logger.info("false");
		showForm = false;
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

}
