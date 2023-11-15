package ifsuldeminas.telefonia.model.entity.pessoal;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "class")
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String endereco;
}
