package com.hrtek.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyNote {

	@Id
	private Long id;
	@Lob
	private String text;
	
	public MyNote(Long id) {
		this.id = id;
	}
	
	
}
