package sn.groupeisi.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "commentaire_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commentaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idC;
    @Column(name = "message", length = 200)
    private String message;
    @Column(name = "dateCommentaire")
    private Date dateC;
    @ManyToOne
    @JoinColumn(name = "membre")
    private Membre membre;
}
