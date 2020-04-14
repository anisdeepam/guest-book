package com.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guestbook.entity.GuestEntry;
/**
 * GuestBook Repository Interface
 * @author Anis Deepa
 *
 */
@Repository
public interface GuestBookRepository extends JpaRepository<GuestEntry, Integer>{

}
