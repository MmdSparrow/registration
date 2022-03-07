package ir.blacksparrow.websitebackend.dataModel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "BS_CATEGORY", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CODE", "TITLE"})
})
public class CategoryEntity {
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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ELEMENT_ID", referencedColumnName = "ID")
    private Set<CategoryElementEntity> categoryElementEntity;
}
