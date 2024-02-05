package repository;

import domain.MyBookCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookCartRepository extends JpaRepository <MyBookCart, Integer> {


}
