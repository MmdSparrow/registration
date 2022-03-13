package ir.blacksparrow.websitebackend.dataModel;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "BS_CATEGORY_ELEMENT", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CODE", "TITLE", "CATEGORY_ID"})
})
public class CategoryElementEntity {
    @Id
    @Column(name = "ID")
    private long id;

    @NotNull
    @Column(name = "CODE")
    private String code;

    @NotNull
    @Column(name = "TITLE")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    private CategoryEntity categoryEntity;
}
