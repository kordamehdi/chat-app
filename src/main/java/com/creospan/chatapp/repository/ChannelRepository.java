package com.creospan.chatapp.repository;

import com.creospan.chatapp.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel,Long> {
}
