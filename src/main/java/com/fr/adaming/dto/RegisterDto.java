package com.fr.adaming.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
	@NotNull
	private String nom;
	@NotNull
	private String prenom;
	@Email
	@NotNull
	private String email;
	@NotNull
	@Size(min = 6, max = 30)
	private String pwd;
}
