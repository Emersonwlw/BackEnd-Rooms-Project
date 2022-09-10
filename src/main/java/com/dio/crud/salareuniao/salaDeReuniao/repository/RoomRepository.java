package com.dio.crud.salareuniao.salaDeReuniao.repository;

import com.dio.crud.salareuniao.salaDeReuniao.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{


}
