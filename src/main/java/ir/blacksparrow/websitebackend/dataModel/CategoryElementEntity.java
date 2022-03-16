package ir.blacksparrow.websitebackend.dataModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "BS_CATEGORY_ELEMENT", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CODE", "TITLE", "CATEGORY_ID"})
})
public class CategoryElementEntity {
    @SequenceGenerator(
            name = "category_element_sequence",
            sequenceName = "category_element_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_element_sequence"
    )
    @Column(name = "ID")
    private long id;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID", nullable = false)
    private CategoryEntity categoryEntity;
}
