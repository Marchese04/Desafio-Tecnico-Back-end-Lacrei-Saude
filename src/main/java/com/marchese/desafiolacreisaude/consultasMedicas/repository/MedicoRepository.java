package com.marchese.desafiolacreisaude.consultasMedicas.repository;

import com.marchese.desafiolacreisaude.consultasMedicas.classe.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
