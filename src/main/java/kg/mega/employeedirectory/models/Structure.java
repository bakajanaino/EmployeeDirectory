package kg.mega.employeedirectory.models;
import javax.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Structure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    boolean isActive;
    @ManyToOne
    StructureType structureType;
    @OneToOne
    @JoinColumn(name = "parent_structure_id")
    Structure parentStructure;
}
