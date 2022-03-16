package ir.blacksparrow.websitebackend.dataModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "BS_TOKEN_CONFIRMATION")
public class TokenConfirmationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String token;

    @Column(name = "CREATE_TIME", nullable = false)
    private LocalDateTime createTime;

    @Column(name = "EXPIRE_TIME", nullable = false)
    private LocalDateTime expireTime;

    @Column(name = "CONFIRM_TIME", nullable = false)
    private LocalDateTime confirmTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ENTITY", referencedColumnName = "USERNAME", nullable = false)
    private UserEntity userEntity;
}
