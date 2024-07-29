package br.com.jandernery.transaction_caju.domain.mappers;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserMapper {
    public Long id;
    public String name;
    public String userName;
    public UserAccountMapper account;
}



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class UserAccountMapper{
    public Long id;
    public double amount;
}
