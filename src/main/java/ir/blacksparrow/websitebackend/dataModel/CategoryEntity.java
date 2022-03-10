package ir.blacksparrow.websitebackend.dataModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

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
}
