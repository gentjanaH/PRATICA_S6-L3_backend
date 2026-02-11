package gentjanahani.u2w6d3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "blogs")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Blogs {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID idBlog;

    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

    //relazione ManyToOne
    @ManyToOne
    private Authors authors;

    public Blogs(String categoria, String titolo, String contenuto, int tempoDiLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = "https://picsum.photos/200/300";
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
    }
}
