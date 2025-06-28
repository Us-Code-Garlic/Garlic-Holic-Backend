package com.garlicholic.backend.storage;

import jakarta.persistence.*;

@Entity
@Table(name = "chat_history_tb")
public class ChatHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String chats;
    private String role;

}