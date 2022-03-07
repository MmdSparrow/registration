package ir.blacksparrow.websitebackend.dataModel;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BS_USER", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"EMAIL_ADDRESS"})
})
public class UserEntity {
    @Id
    @Column(name = "USERNAME")
    private String username;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "NATIONAL_ID")
    private PersonEntity personEntity;

//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "CATEGORY_ELEMENT_ID", referencedColumnName = "ID")
//    private CategoryElementEntity categoryElementEntity;

    @Column(name = "LOCKED")
    private Boolean locked;

    @Column(name = "ENABLED")
    private Boolean enabled;

}
