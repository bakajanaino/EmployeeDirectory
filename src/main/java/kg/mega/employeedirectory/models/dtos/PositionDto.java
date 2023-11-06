package kg.mega.employeedirectory.models.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PositionDto {
    Long id;
    String name;
    Long structureId;
    Long parentPosition;
    boolean isActive;

}
