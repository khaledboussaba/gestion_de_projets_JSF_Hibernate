package fr.gestionprojets.presentation;

import java.util.ArrayList;
import java.util.List;

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
import fr.gestionprojets.service.ProjectService;
import fr.gestionprojets.service.ProjectServiceImpl;

@ManagedBean(name = "mbProject")
@RequestScoped
public class ProjectManagedBean {
	
	
	private ProjectService projectService = new ProjectServiceImpl();

	public Logger logger = Logger.getLogger(ProjectManagedBean.class);
	private String title;
	@Size(min = 2, max = 10, message = "Le nombre de caractère doit être compris entre 2 et 10 caractères")
	private String description;
	private String budget;
	private String type;
	@NotNull(message = "Projet actif ? (Oui / Non)") //autre façon de gérer les validations
	private String active;

	private List<SelectItem> typeList;

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
		typeList = new ArrayList<SelectItem>();
		typeList.add(new SelectItem("", ""));
		typeList.add(new SelectItem(1, "Informatique"));
		typeList.add(new SelectItem(2, "Commerce"));
		typeList.add(new SelectItem(3, "Autre"));
	}

	public void addProject(ActionEvent event) {

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
			p.setType(Long.valueOf(type));
			p.setActive(active);
			
			projectService.add(p);
		}

	}

	public void generateDesription(ActionEvent event) {
		String desc = "";
		desc += "Le titre est : " + title + "\n";
		desc += "Le montant : " + budget + "\n";
		desc += "Active : " + ("Y".equals(active) ? "Oui": "Non");
		description = desc;
		title = "";
		budget = "";
		active = "";

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

}
