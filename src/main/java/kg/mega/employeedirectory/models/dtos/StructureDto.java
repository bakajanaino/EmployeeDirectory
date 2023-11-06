package kg.mega.employeedirectory.models.dtos;

import kg.mega.employeedirectory.models.Structure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class StructureDto {
    Long id;
    String structureName;
    boolean isActive;
    Long parentStructure;
    Long structureTypeId;


    public StructureDto(Structure structure){
        this.id=structure.getId();
        this.structureName=structure.getName();
        this.isActive=structure.isActive();
        this.parentStructure=structure.getParentStructure().getId();
        this.structureTypeId=structure.getStructureType().getId();
    }
}
