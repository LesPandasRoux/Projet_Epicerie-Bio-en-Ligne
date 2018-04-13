package com.fr.adaming.managed.bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ValidatorBean implements Validator {
    //validation de l'email
	private String email;

    private static final String EMAIL_REGEXP = "^[_A-Za-z0-9-]*@[A-Za-z0-9]*";

    @Override
    public void validate(FacesContext context, UIComponent c, Object val) throws ValidatorException {
        String email = (String) val;
        Pattern mask = null;
        mask = Pattern.compile(EMAIL_REGEXP);
        Matcher matcher = mask.matcher(email);
        if (!matcher.matches()) {
            FacesMessage message = new FacesMessage();
            message.setDetail("Please enter a valid email");
            message.setSummary("Email not valid");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
