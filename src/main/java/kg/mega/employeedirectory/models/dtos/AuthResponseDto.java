package kg.mega.employeedirectory.models.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class AuthResponseDto {
    private String username;
    private  String token;
    private Date activeTill;
}
