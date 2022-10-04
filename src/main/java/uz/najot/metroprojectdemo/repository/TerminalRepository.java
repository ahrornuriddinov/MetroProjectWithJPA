package uz.najot.metroprojectdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najot.metroprojectdemo.entity.Terminal;

import javax.persistence.criteria.CriteriaBuilder;
@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Integer> {
}
