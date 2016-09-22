package example.ui.cli;

import example.common.entity.Drama;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DramaServiceCircuitBreaker implements DramaService {

    @Override
    public List<Drama> findAllDramas() {
        return new ArrayList<>(0);
    }

}
