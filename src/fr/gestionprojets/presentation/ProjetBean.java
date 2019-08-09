package fr.gestionprojets.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

@ManagedBean(name = "mbProjet")
@RequestScoped
public class ProjetBean {
	
	public Logger logger = Logger.getLogger(ProjetBean.class);
	private String title;
	
	public void saveData(ActionEvent event) {
		logger.info("Le titre est : " + title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
