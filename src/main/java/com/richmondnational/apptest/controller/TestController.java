package com.richmondnational.apptest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Tag(name = "Claims", description = "Claims endpoints require authorization. Use /swagger/authorize")
@Slf4j
@CrossOrigin
@RestController
@RequestMapping
public class TestController {

    @Operation(
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not Found",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content
                    )
            },
            parameters = {
                    @Parameter(
                            in = ParameterIn.PATH,
                            name = "numClaim",
                            description = "Claim Number",
                            schema = @Schema( type = "string" )
                    )
            },
            description = "Get Test Resource"
    )
    @GetMapping(value = "/api/v1/test/resource", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTestResource() {
        log.info("Fetching Test Resource");

        return ResponseEntity.status(HttpStatus.OK)
                .body("Hello");
    }

}
