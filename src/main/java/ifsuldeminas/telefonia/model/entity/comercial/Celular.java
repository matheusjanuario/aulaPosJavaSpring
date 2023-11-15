package ifsuldeminas.telefonia.model.entity.comercial;

import ifsuldeminas.telefonia.model.entity.pessoal.Cliente;
import jakarta.persistence.*;

import java.util.Set;
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Sinaliza que será criado uma unica tabela para o conjunto de classes relacionadas
@DiscriminatorColumn(name = "class")
@Entity
public class Celular {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Long numero;

    //Ligação entre Celular e Ligações
    @OneToMany
    @JoinColumn(name = "celular_id")
    private Set<Ligacao> ligacoes;

    //Ligação Agregação onde a pessoa não conhece o seu celular.
    @ManyToOne
    private Cliente cliente;
   @ManyToOne
    private Plano plano;
}
