package ifsuldeminas.telefonia.model.entity.comercial;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CelularposPago")
public class CelularposPago extends Celular{
    private int diaDeVencimento;
}
