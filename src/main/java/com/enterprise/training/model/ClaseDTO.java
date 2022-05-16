package com.enterprise.training.model;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ClaseDTO {

		private String nombre;
		private int code;
		private List <Job> jobPerson;
	
	
		
}
