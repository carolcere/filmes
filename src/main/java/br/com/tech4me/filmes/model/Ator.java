package br.com.tech4me.filmes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class Ator {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "act_id")
   private Integer id;
   @Column(name = "act_fname")
   private String nome;
   @Column(name = "act_lname")
   private String sobrenome;
   @Column(name = "act_gender")
   private Character sexo;

   public String getNomeCompleto() {
       return String.format("%s %s", nome.trim(), sobrenome.trim());

   }

   @Override 
   public String toString() {
   return getNomeCompleto();
   }
}
