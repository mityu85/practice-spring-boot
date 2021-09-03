package org.training360.imdb.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training360.imdb.categories.Category;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    public Movie(String title, int rate) {
        this.title = title;
        this.rate = rate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int rate;

    @ManyToOne
    private Category category;

    public boolean hasNoCategory() {
        return category == null;
    }
}
