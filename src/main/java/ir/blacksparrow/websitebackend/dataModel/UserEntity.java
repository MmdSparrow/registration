package ir.blacksparrow.websitebackend.dataModel;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"EMAIL_ADDRESS"})
})
public class UserEntity implements UserDetails {
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
    private PersonEntity personEntity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryElementEntity categoryElementEntity;

    @Column(name = "LOCKED")
    private Boolean locked;

    @Column(name = "ENABLED")
    private Boolean enabled;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(categoryElementEntity.getTitle());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
