package GUICAM.tech.ms_soins_sante.devops.metrics;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Duration;

@Component
@Getter
public class ApiMetrics extends OncePerRequestFilter {

    private final Counter http4xxErrors;
    private final Counter http5xxErrors;
    private final Counter totalRequests;

    private final DistributionSummary requestSize;
    private final DistributionSummary responseSize;

    private final Timer apiLatency;

    public ApiMetrics(MeterRegistry registry) {

        this.totalRequests = Counter.builder("api_requests_total")
                .description("Nombre total de requêtes API")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.http4xxErrors = Counter.builder("api_errors_4xx_total")
                .description("Erreurs côté client")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.http5xxErrors = Counter.builder("api_errors_5xx_total")
                .description("Erreurs côté serveur")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.requestSize = DistributionSummary.builder("api_request_size_bytes")
                .description("Taille des requêtes entrantes")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.responseSize = DistributionSummary.builder("api_response_size_bytes")
                .description("Taille des réponses")
                .tag("application", "ms-soins-sante")
                .register(registry);

        this.apiLatency = Timer.builder("api_latency_seconds")
                .description("Temps de réponse API")
                .publishPercentileHistogram(true) // histogramme → obligatoire pour percentiles
                .publishPercentiles(0.50, 0.95, 0.99)
                .minimumExpectedValue(Duration.ofMillis(1))
                .maximumExpectedValue(Duration.ofSeconds(10))
                .tag("application", "ms-soins-sante")
                .register(registry);
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        long start = System.nanoTime();
        totalRequests.increment();

        filterChain.doFilter(request, response);

        long duration = System.nanoTime() - start;
        apiLatency.record(Duration.ofNanos(duration));

        int status = response.getStatus();

        if (status >= 400 && status < 500) http4xxErrors.increment();
        if (status >= 500) http5xxErrors.increment();
    }
<<<<<<< HEAD
=======
public class ApiMetrics {
>>>>>>> b85821c (Ajout du fichier readme.md)
=======
>>>>>>> a19c632 (Ajout du fichier readme.md)
}
