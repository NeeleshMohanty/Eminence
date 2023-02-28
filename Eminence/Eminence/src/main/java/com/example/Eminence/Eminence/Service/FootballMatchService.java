package com.example.Eminence.Eminence.Service;

import com.example.Eminence.Eminence.Config.JwtTokenProvider;
import com.example.Eminence.Eminence.DTO.FootballMatchApiResponse;
import com.example.Eminence.Eminence.Entity.FootballMatch;
import com.example.Eminence.Eminence.Repository.FootballMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Service
public class FootballMatchService {

    @Autowired
    private FootballMatchRepository footballMatchRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Async
    public CompletableFuture<List<FootballMatch>> getDrawnMatchesForYear(String token, int year) throws InterruptedException, UnauthorizedException {
        Thread.sleep(getRandomDelay());
        if (JwtTokenProvider.isValidToken(token)) {
            String url = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&page=1";
            FootballMatchApiResponse response = restTemplate.getForObject(url, FootballMatchApiResponse.class);
            List<FootballMatch> matches = response.getMatches();
            matches.removeIf(match -> !match.isDraw());
            footballMatchRepository.saveAll(matches);
            return CompletableFuture.completedFuture(matches);
        } else {
            throw new UnauthorizedException("Invalid token");
        }
    }

    private int getRandomDelay() {
        Random random = new Random();
        return random.nextInt(3000) + 3000;
    }

    public int getDrawCountForYear(int year) {
        return 0;
    }
}
