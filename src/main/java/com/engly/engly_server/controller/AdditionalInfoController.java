package com.engly.engly_server.controller;

import com.engly.engly_server.models.dto.AuthResponseDto;
import com.engly.engly_server.models.request.AdditionalRequestForGoogleUser;
import com.engly.engly_server.service.AdditionalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addition_info")
public class AdditionalInfoController {
    private final AdditionalService additionalService;

    public AdditionalInfoController(AdditionalService additionalService) {
        this.additionalService = additionalService;
    }

    @Operation(
            summary = "Додавання додаткової інформації для Google користувача",
            description = """
        Ендпоінт доступний тільки для користувачів, що автентифіковані через Google.
        Потрібна роль ROL_GOOGLE та scope ADDITIONAL_INFO.
    """,
            responses = {
                    @ApiResponse(responseCode = "201", description = "Інформацію успішно додано"),
                    @ApiResponse(responseCode = "403", description = "Доступ заборонено - відсутні необхідні права"),
                    @ApiResponse(responseCode = "400", description = "Помилка валідації даних")
            }
    )
    @PreAuthorize("hasAuthority('SCOPE_ADDITIONAL_INFO')")
    @PostMapping("/additional-info")
    public ResponseEntity<AuthResponseDto> addInfo(@RequestBody AdditionalRequestForGoogleUser additionalRequestForGoogleUser) {
        return new ResponseEntity<>(additionalService.additionalRegistration(additionalRequestForGoogleUser), HttpStatus.CREATED);
    }
}
