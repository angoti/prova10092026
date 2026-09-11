package br.edu.iftm.petvida.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.iftm.petvida.model.Animal;
import br.edu.iftm.petvida.model.Tutor;
import br.edu.iftm.petvida.repository.AnimalRepository;
import br.edu.iftm.petvida.repository.TutorRepository;

@Controller
public class ProvaController {

  @Autowired
  AnimalRepository animalRepository;

  @Autowired
  TutorRepository tutorRepository;

  @GetMapping("/ficha_53")
  public String getFicha(Model model) {
    Animal animal = animalRepository.buscarPorId(153);
    model.addAttribute("animal", animal);
    return "ficha";
  }

  @GetMapping("/tutor_53")
  public String getTutor(Model model) {
    Tutor tutor = tutorRepository.buscarPorId(153);
    model.addAttribute("tutor", tutor);
    return "tutor";
  }

  @GetMapping("/resumo_53")
  public String getResumo(Model model) {
    Integer animais = animalRepository.contarAnimais();
    BigDecimal mediaIdade = animalRepository.mediaIdade();
    String animalMaisVelho = animalRepository.animalMaisVelho();
    // data/hora em que a página foi gerada, no formato dd/MM/aaaa HH:mm:ss
    String dataHoraGeracao = java.time.LocalDateTime.now()
        .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    model.addAttribute("animais", animais);
    model.addAttribute("mediaIdade", mediaIdade);
    model.addAttribute("animalMaisVelho", animalMaisVelho);
    model.addAttribute("dataHoraGeracao", dataHoraGeracao);
    return "resumo";
  }

}
