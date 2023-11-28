//Dev. Matheus Januario 28/11/2023
package ifsuldeminas.telefonia.model.repository;

import ifsuldeminas.telefonia.model.entity.comercial.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

/* Referenciando que o repositório é uma extenção da Casse de Planos*/
public interface PlanoRepository extends JpaRepository<Plano, Long> {

}
