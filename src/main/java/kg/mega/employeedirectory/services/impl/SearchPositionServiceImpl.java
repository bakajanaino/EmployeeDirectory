package kg.mega.employeedirectory.services.impl;

import kg.mega.employeedirectory.models.Position;
import kg.mega.employeedirectory.repos.PositionRepo;
import kg.mega.employeedirectory.services.SearchPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchPositionServiceImpl implements SearchPositionService {
    private final PositionRepo positionRepo;
    @Override
    public List<Position> findAllPositions() {
        return positionRepo.findAll();
    }
}
