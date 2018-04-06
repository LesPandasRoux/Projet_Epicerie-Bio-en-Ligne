package com.fr.adaming.managed.bean;


	import java.util.ArrayList;
	import java.util.List;
	import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
	 
	@Controller
	public class ImagesView {
	     
	    private List<String> images;
	     
	    @PostConstruct
	    public void init() {
	        images = new ArrayList<String>();
	        for (int i = 1; i < 6; i++) {
	            images.add("promo" + i + ".jpg");
	        }
	    }
	 
	    public List<String> getImages() {
	        return images;
	    }

		public void setImages(List<String> images) {
			this.images = images;
		}
	    
	}

