package com.example.Construccion.Auditoria.Repositorio;

import com.example.Construccion.Auditoria.Modelo.AuditoriaLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriaLogRepository extends JpaRepository<AuditoriaLog, Long> {
}
