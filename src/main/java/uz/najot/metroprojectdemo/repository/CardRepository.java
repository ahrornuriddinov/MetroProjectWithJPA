package uz.najot.metroprojectdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najot.metroprojectdemo.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
