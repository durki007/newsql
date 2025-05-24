package pl.pwr.backendnbadraft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pwr.backendnbadraft.model.Player;
import pl.pwr.backendnbadraft.model.Club;
import pl.pwr.backendnbadraft.repository.PlayerRepository;
import pl.pwr.backendnbadraft.repository.ClubRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DatabaseStressTestService {
    private final PlayerRepository playerRepository;
    private final ClubRepository clubRepository;
    private final AtomicInteger successfulTransactions = new AtomicInteger(0);
    private final AtomicInteger failedTransactions = new AtomicInteger(0);
    private final Random random = new Random();
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private Future<?> stressTestFuture;
    private volatile boolean running = false;

    @Autowired
    public DatabaseStressTestService(PlayerRepository playerRepository, ClubRepository clubRepository) {
        this.playerRepository = playerRepository;
        this.clubRepository = clubRepository;
    }

    public synchronized void startStressTest() {
        if (running) return;
        running = true;
        stressTestFuture = executor.submit(() -> {
            while (running) {
                try {
                    if (random.nextBoolean()) {
                        Player player = createMockPlayer();
                        playerRepository.save(player);
                    } else {
                        playerRepository.findAll();
                    }
                    successfulTransactions.incrementAndGet();
                } catch (Exception e) {
                    failedTransactions.incrementAndGet();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    public synchronized void stopStressTest() {
        running = false;
        if (stressTestFuture != null) {
            stressTestFuture.cancel(true);
        }
    }

    public boolean isRunning() {
        return running;
    }

    public int getSuccessfulTransactions() {
        return successfulTransactions.get();
    }

    public int getFailedTransactions() {
        return failedTransactions.get();
    }

    private Player createMockPlayer() {
        return Player.builder()
                .firstName("Player" + random.nextInt(1000))
                .lastName("Test" + random.nextInt(1000))
                .jerseyNumber(random.nextInt(0, 100))
                .position("Position" + random.nextInt(1, 5))
                .heightCm(ThreadLocalRandom.current().nextInt(170, 220))
                .weightKg(ThreadLocalRandom.current().nextDouble(70.0, 120.0))
                .build();
    }
}