package br.com.jandernery.transaction_caju.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    public Long id;
    public String name;
    public String userName;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

}
