package com.turong.training.rest.convert;

import com.turong.training.rest.controller.UserResponse;
import com.turong.training.rest.controller.UserSaveRequest;
import com.turong.training.rest.controller.UserSearchRequest;
import com.turong.training.rest.entity.User;
import com.turong.training.rest.service.UserSearchCriteria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserConvert {

    @Mapping(source = "tenant", target = "tenantId")
    User toUser(final UserSaveRequest userSaveRequest);

    @Mapping(source = "tenantId", target = "tenant")
    UserResponse toResponse(final User user);

    UserSearchCriteria toSearchCriteria(UserSearchRequest searchRequest);
}
