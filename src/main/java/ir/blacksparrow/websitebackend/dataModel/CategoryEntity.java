package ir.blacksparrow.websitebackend.dataModel;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "BS_CATEGORY",uniqueConstraints={
        @UniqueConstraint(columnNames={"CODE", "TITLE"})
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

    @NotNull
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ELEMENT_ID", referencedColumnName = "ID")
    private Set<CategoryElementEntity> categoryElementEntity;
}
