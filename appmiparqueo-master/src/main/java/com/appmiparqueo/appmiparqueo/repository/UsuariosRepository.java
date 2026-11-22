package com.appmiparqueo.appmiparqueo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appmiparqueo.appmiparqueo.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    // Métodos personalizados (si los necesitas) pueden añadirse aquí
}