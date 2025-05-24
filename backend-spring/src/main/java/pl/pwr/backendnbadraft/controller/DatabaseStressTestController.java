package pl.pwr.backendnbadraft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.backendnbadraft.service.DatabaseStressTestService;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stress-test")
public class DatabaseStressTestController {
    private final DatabaseStressTestService stressTestService;

    @Autowired
    public DatabaseStressTestController(DatabaseStressTestService stressTestService) {
        this.stressTestService = stressTestService;
    }

    @GetMapping("/stats")
    public Map<String, Integer> getStats() {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("successfulTransactions", stressTestService.getSuccessfulTransactions());
        stats.put("failedTransactions", stressTestService.getFailedTransactions());
        return stats;
    }

    @GetMapping("/start")
    public Map<String, Object> startStressTest() {
        stressTestService.startStressTest();
        Map<String, Object> response = new HashMap<>();
        response.put("running", stressTestService.isRunning());
        return response;
    }

    @GetMapping("/stop")
    public Map<String, Object> stopStressTest() {
        stressTestService.stopStressTest();
        Map<String, Object> response = new HashMap<>();
        response.put("running", stressTestService.isRunning());
        return response;
    }

    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("running", stressTestService.isRunning());
        return status;
    }
}
