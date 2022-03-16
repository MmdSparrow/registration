package ir.blacksparrow.websitebackend.dataModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "TITLE", nullable = false)
    private String title;
}
