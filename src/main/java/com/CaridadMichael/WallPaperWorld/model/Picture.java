package com.CaridadMichael.WallPaperWorld.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@CreationTimestamp
	private Date date;

	private String name;
	private String uploadedBy;

	private Integer favorites = 0;
	private Integer viewCount;
	private String pictureUrl;

	private Boolean approved = false;

	@ElementCollection(targetClass = String.class)
	private Set<String> tags;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "username", referencedColumnName = "username")
	private AppUser user;

}
