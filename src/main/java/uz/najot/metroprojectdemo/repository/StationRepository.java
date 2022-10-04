package uz.najot.metroprojectdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najot.metroprojectdemo.entity.Station;

@Repository
public interface StationRepository extends JpaRepository<Station,Integer> {
}
