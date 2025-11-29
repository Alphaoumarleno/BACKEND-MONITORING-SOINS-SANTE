package GUICAM.tech.ms_soins_sante.dataAccess;

import GUICAM.tech.ms_soins_sante.repositories.RendezVousRepository;  // ← corrigé

public class RendezVousDataAccess {

    private final RendezVousRepository rendezVousRepository;

    public RendezVousDataAccess(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }
}
