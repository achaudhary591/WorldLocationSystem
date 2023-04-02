package net.codejava.world.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable {

	private String url;

	public BaseDTO(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
