package com.turong.training.webflux.convert;

import com.turong.training.webflux.controller.UserResponse;
import com.turong.training.webflux.controller.UserSaveRequest;
import com.turong.training.webflux.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConvert {

    User toUser(final UserSaveRequest userSaveRequest);

    UserResponse toResponse(final User user);

}
