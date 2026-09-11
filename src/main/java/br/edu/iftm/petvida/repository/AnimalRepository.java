package br.edu.iftm.petvida.repository;

import java.math.BigDecimal;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.iftm.petvida.model.Animal;
import br.edu.iftm.petvida.model.Tutor;

@Repository
public class AnimalRepository {

  private final JdbcTemplate jdbc;

  public AnimalRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public Animal buscarPorId(int id) {
    // UMA única consulta SQL com JOIN entre animal e tutor
    String sql = "SELECT a.id_animal, a.nome, a.especie, a.idade, a.tutor_id_tutor, " +
        "t.id_tutor, t.nome AS tutor_nome, t.telefone " +
        "FROM animal a " +
        "JOIN tutor t ON t.id_tutor = a.tutor_id_tutor " +
        "WHERE a.id_animal = ?";
    return jdbc.queryForObject(sql, (rs, rowNum) -> new Animal(
        rs.getLong("id_animal"),
        rs.getString("nome"),
        rs.getString("especie"),
        rs.getInt("idade"),
        new Tutor(
            rs.getLong("id_tutor"),
            rs.getString("tutor_nome"),
            rs.getString("telefone"))), id);
  }

  public Integer contarAnimais() {
    String sql = "SELECT COUNT(*) FROM animal";
    return jdbc.queryForObject(sql, Integer.class);
  }

  public BigDecimal mediaIdade() {
    // média com duas casas decimais feita diretamente no SQL
    String sql = "SELECT CAST(ROUND(AVG(idade), 2) AS DECIMAL(10, 2)) FROM animal";
    return jdbc.queryForObject(sql, BigDecimal.class);
  }

  public String animalMaisVelho() {
    String sql = "SELECT nome FROM animal ORDER BY idade DESC LIMIT 1";
    return jdbc.queryForObject(sql, (rs, rowNum) -> rs.getString("nome"));
  }

  public void salvar(Animal animal) {
    String sql = "INSERT INTO animal (id_animal, nome, especie, idade, tutor_id_tutor) VALUES (?, ?, ?, ?, ?)";
    jdbc.update(sql, animal.getId_animal(), animal.getNome(), animal.getEspecie(), animal.getIdade(),
        animal.getTutor().getId_tutor());
  }

}
