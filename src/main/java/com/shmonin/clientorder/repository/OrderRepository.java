package com.shmonin.clientorder.repository;

import com.shmonin.clientorder.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> getAllByClientId(Long id);

    @Transactional
    @Modifying
    @Query("delete from Order o where o.client.id = :clientId")
    void deleteAllByClientId(@Param("clientId") Long clientId);
}