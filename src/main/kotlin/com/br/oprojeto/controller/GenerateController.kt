package com.br.oprojeto.controller

import com.br.oprojeto.controller.data.GenerateImageResponse
import com.br.oprojeto.controller.data.GenerateImagesRequest
import com.br.oprojeto.controller.data.ListTemplateResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/generate")
@Tag(name = "Generate", description = "gera imagens")
interface GenerateController {

    @PostMapping("/insert")
    @Operation(summary = "gera imagens a partir de uma logo")
    fun generateImages(@RequestBody @Valid request: GenerateImagesRequest): GenerateImageResponse

    @GetMapping("/listTemplates")
    @Operation(summary = "Lista os templates em base64")
    fun listTemplate(): ListTemplateResponse
}