package com.passguard.dtos;

import java.time.LocalDate;

public record NotificationsDTO(Integer id, Integer userPasswordsId, LocalDate date) {

}
