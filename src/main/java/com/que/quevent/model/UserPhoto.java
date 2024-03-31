package com.que.quevent.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="user_photos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String remoteUrl;

    private Integer changeCount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
