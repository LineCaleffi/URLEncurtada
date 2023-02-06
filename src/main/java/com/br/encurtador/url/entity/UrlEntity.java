package com.br.encurtador.url.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "url")
public class UrlEntity {
	
	//é importante usar DTO

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "URL")
	private String url;
	@Column(name = "Date")
	private String date;
	@Column(name = "newUrl")
	private String newUrl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String createdAt) {
		this.date = createdAt;
	}

	public String getNewUrl() {
		return newUrl;
	}

	public void setNewUrl(String newUrl) {
		this.newUrl = newUrl;
	}

	@Override
	public String toString() {
		return "UrlEntity [id=" + id + ", url=" + url + ", date=" + date + ", newUrl=" + newUrl + "]";
	}
}
