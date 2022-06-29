package com.example.todoapplication.notification;

import com.example.todoapplication.util.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper extends GenericMapper<NotificationDto, Notification> {
}
