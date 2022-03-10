package ir.blacksparrow.websitebackend.dataModel;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "BS_USER")
public class UserEntity {
    @Id
    @Column(name = "USERNAME")
    private String username;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @Column(name = "EMAIL_ADDRESS", unique = true)
    private String emailAddress;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "NATIONAL_ID")
    private PersonEntity personEntity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ELEMENT_ID", referencedColumnName = "ID")
    private CategoryElementEntity categoryElementEntity;

    @Column(name = "LOCKED")
    private boolean locked;

    @Column(name = "ENABLED")
    private boolean enabled;

}
