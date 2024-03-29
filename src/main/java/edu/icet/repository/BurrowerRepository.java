package edu.icet.repository;

import edu.icet.entity.Burrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurrowerRepository extends JpaRepository<Burrower,Long> {
    public Burrower findByUserName(String userName);

    Boolean existsByUserName(String userName);
}
