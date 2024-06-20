package com.wipro.ekartManagemet_1.ApiResponse;

import lombok.*;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponseMessage {
    String message;

    HttpStatus status;
}
