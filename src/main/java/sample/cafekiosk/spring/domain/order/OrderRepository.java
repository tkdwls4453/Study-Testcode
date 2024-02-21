package sample.cafekiosk.spring.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.registeredDateTime >= :startDateTime and o.registeredDateTime < :endDateTime and o.orderStatus = :orderStatus")
    List<Order> findOrderBy(@Param(value = "startDateTime")LocalDateTime startDateTime, @Param(value = "endDateTime") LocalDateTime endDateTime, @Param(value = "orderStatus") OrderStatus orderStatus);

}
