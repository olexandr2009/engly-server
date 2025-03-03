package com.engly.engly_server.utils.mapper;

import com.engly.engly_server.models.dto.UserSettingsDto;
import com.engly.engly_server.models.entity.UserSettings;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserSettingsMapper {
    UserSettingsMapper INSTANCE = Mappers.getMapper(UserSettingsMapper.class);

    UserSettingsDto toUserSettingsDto(UserSettings userSettings);
}
