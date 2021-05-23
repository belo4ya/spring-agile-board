package com.example.agileboard.dto.user;

import com.example.agileboard.dto.BaseDto;
import com.example.agileboard.models.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UserDto extends BaseDto {
    private String name;
    private String avatar;

    public UserDto(User user) {
        super(user);
        this.name = user.getName();
        this.avatar = user.getAvatar();
    }
}
