package com.example.CRUDsb.repository;

import com.example.CRUDsb.entity.Comentario;
import com.example.CRUDsb.entity.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
