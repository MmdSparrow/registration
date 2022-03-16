package ir.blacksparrow.websitebackend.business.dto;

import ir.blacksparrow.websitebackend.dataModel.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class TokenConfirmationDto {
    private Long id;
    private String token;
    private LocalDateTime createTime;
    private LocalDateTime expireTime;
    private LocalDateTime confirmTime;
    private UserEntity userEntity;
}
