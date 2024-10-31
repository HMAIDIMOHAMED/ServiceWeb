package hmaidi.webservice.Entities;

import hmaidi.webservice.Enum.TypeCompte;
import jakarta.persistence.*;
import lombok.*;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.ORDINAL)
    private TypeCompte typeCompte;

    @XmlElement
    public Long getId() {
        return id;
    }

    @XmlElement
    public double getSolde() {
        return solde;
    }

    @XmlElement
    public Date getDateCreation() {
        return dateCreation;
    }

    @XmlElement
    public TypeCompte getTypeCompte() {
        return typeCompte;
    }
}