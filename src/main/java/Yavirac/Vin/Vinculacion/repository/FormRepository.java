package Yavirac.Vin.Vinculacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Yavirac.Vin.Vinculacion.entity.FormEntity;

@Repository
public interface FormRepository extends JpaRepository<FormEntity, Long> {
    void deleteById(Long id);
}
