package com.shmonin.clientorder.repository;

import com.shmonin.clientorder.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}