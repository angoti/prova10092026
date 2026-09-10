package br.edu.iftm.petvida.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
  private Long id_animal;
  private String nome;
  private String especie;
  private Integer idade;
  private Integer tutor_id_tutor;

}
