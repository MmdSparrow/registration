package ir.blacksparrow.websitebackend.dataModel;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "BS_PERSON")
public class PersonEntity {

    @Id
    @Column(name = "NATIONAL_ID")
    private String nationalId;

    @NotNull
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

//    @NotNull
//    @Column(name = "BIRTH_DATE")
//    private Date birthday;

//    @NotNull
//    @Column(name = "BALACNE", columnDefinition = "REAL DEFAULT 0")
//    private double balance;
}
