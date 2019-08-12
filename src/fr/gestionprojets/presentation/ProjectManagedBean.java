package fr.gestionprojets.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

@ManagedBean(name = "mbProject")
@RequestScoped
public class ProjectManagedBean {
	
	public Logger logger = Logger.getLogger(ProjectManagedBean.class);
	private String title;
	private String description;
	private Double budget;
	private String type;
	private String active;
	
	private List<SelectItem> typeList;
	
	@PostConstruct
	public void init() {
		typeList = new ArrayList<SelectItem>();
		typeList.add(new SelectItem(1, "Informatique"));
		typeList.add(new SelectItem(2, "Commerce"));
		typeList.add(new SelectItem(3, "Autre"));
	}
	
	public void addProject(ActionEvent event) {
		logger.info("Les valeurs : ");
		logger.info("   titre : " + title);
		logger.info("   description : " + description);
		logger.info("   budget : " + budget);
		logger.info("   type : " + type);
		logger.info("   active : " + active);
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
	
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
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
