package kg.mega.employeedirectory.services;

import kg.mega.employeedirectory.models.Position;

import java.util.List;

public interface SearchPositionService {
    List<Position> findAllPositions();
}
