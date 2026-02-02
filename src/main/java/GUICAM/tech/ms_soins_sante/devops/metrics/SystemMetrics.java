<<<<<<< HEAD
<<<<<<< HEAD
package GUICAM.tech.ms_soins_sante.devops.metrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class SystemMetrics {

    private final File rootDisk = new File(".");

    public SystemMetrics(MeterRegistry registry) {

        // CPU Usage (JVM)
        Gauge.builder("system_cpu_load_percent", this::getCpuLoad)
                .description("Charge CPU du système (%)")
                .tag("application", "ms-soins-sante")
                .register(registry);

        // Memory usage
        Gauge.builder("system_memory_used_bytes", this::getUsedMemory)
                .description("Mémoire utilisée (bytes)")
                .tag("application", "ms-soins-sante")
                .register(registry);

        Gauge.builder("system_memory_free_bytes", this::getFreeMemory)
                .description("Mémoire libre (bytes)")
                .tag("application", "ms-soins-sante")
                .register(registry);

        // Disk usage
        Gauge.builder("system_disk_free_bytes", rootDisk::getFreeSpace)
                .description("Espace disque libre")
                .tag("application", "ms-soins-sante")
                .register(registry);

        Gauge.builder("system_disk_total_bytes", rootDisk::getTotalSpace)
                .description("Espace disque total")
                .tag("application", "ms-soins-sante")
                .register(registry);

        // Threads
        Gauge.builder("system_threads_active_total", () -> Thread.activeCount())
                .description("Nombre total de threads actifs")
                .tag("application", "ms-soins-sante")
                .register(registry);
    }

    private double getCpuLoad() {
        return java.lang.management.ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
    }

    private long getUsedMemory() {
        Runtime r = Runtime.getRuntime();
        return r.totalMemory() - r.freeMemory();
    }

    private long getFreeMemory() {
        Runtime r = Runtime.getRuntime();
        return r.freeMemory();
    }
=======
package GUICAM.tech.ms_soins_sante.metrics;
=======
package GUICAM.tech.ms_soins_sante.devops.metrics;
>>>>>>> a19c632 (Ajout du fichier readme.md)

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class SystemMetrics {
<<<<<<< HEAD
>>>>>>> b85821c (Ajout du fichier readme.md)
=======

    private final File rootDisk = new File(".");

    public SystemMetrics(MeterRegistry registry) {

        // CPU Usage (JVM)
        Gauge.builder("system_cpu_load_percent", this::getCpuLoad)
                .description("Charge CPU du système (%)")
                .tag("application", "ms-soins-sante")
                .register(registry);

        // Memory usage
        Gauge.builder("system_memory_used_bytes", this::getUsedMemory)
                .description("Mémoire utilisée (bytes)")
                .tag("application", "ms-soins-sante")
                .register(registry);

        Gauge.builder("system_memory_free_bytes", this::getFreeMemory)
                .description("Mémoire libre (bytes)")
                .tag("application", "ms-soins-sante")
                .register(registry);

        // Disk usage
        Gauge.builder("system_disk_free_bytes", rootDisk::getFreeSpace)
                .description("Espace disque libre")
                .tag("application", "ms-soins-sante")
                .register(registry);

        Gauge.builder("system_disk_total_bytes", rootDisk::getTotalSpace)
                .description("Espace disque total")
                .tag("application", "ms-soins-sante")
                .register(registry);

        // Threads
        Gauge.builder("system_threads_active_total", () -> Thread.activeCount())
                .description("Nombre total de threads actifs")
                .tag("application", "ms-soins-sante")
                .register(registry);
    }

    private double getCpuLoad() {
        return java.lang.management.ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
    }

    private long getUsedMemory() {
        Runtime r = Runtime.getRuntime();
        return r.totalMemory() - r.freeMemory();
    }

    private long getFreeMemory() {
        Runtime r = Runtime.getRuntime();
        return r.freeMemory();
    }
>>>>>>> a19c632 (Ajout du fichier readme.md)
}
