package ir.blacksparrow.websitebackend.business.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TokenConfirmationDto {
    private Long id;
    private String token;
    private LocalDateTime createTime;
    private LocalDateTime expireTime;
    private LocalDateTime confirmTime;
    private String username;
}
