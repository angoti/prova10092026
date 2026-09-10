package br.edu.iftm.petvida.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tutor {
  private Long id_tutor;
  private String nome;
  private String telefone;

}
