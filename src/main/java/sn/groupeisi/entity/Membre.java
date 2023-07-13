package sn.groupeisi.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "membre_tb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Membre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idM;
    @Column(name = "nomMembre", length = 100, unique = true, nullable = false)
    private String membre;
    @OneToMany(mappedBy = "membre")
    private List<Commentaire> commentaires;
}
