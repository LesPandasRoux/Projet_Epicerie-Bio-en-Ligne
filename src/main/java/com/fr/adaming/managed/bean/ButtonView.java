package com.fr.adaming.managed.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

@Controller(value = "buttonView")
@ManagedBean
public class ButtonView {
    
   public void panSave(ActionEvent actionEvent) {
       addMessage("Panier sauvegardé");
   }
   
   public void proSave(ActionEvent actionEvent) {
       addMessage("Produit ajouté");
   }
    
   public void update(ActionEvent actionEvent) {
       addMessage("Data updated");
   }
    
   public void delete(ActionEvent actionEvent) {
       addMessage("Data deleted");
   }
    
   public void addMessage(String summary) {
       FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
       FacesContext.getCurrentInstance().addMessage(null, message);
   }
}