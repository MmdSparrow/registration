package ir.blacksparrow.websitebackend.dataModel;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "BS_CATEGORY_ELEMENT", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CODE"})
})
public class CategoryElementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;

    @NotNull
    @Column(name = "CODE")
    private String code;

    @NotNull
    @Column(name = "TITLE")
    private String title;
}
