package com.br.oprojeto.controller

import com.br.oprojeto.controller.data.GenerateImageResponse
import com.br.oprojeto.controller.data.GenerateImagesRequest
import com.br.oprojeto.controller.data.ListTemplateResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

@RequestMapping("/generate")
@Tag(name = "Generate", description = "gera imagens")
interface GenerateController {

    @PostMapping("/insert", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    @Operation(summary = "gera imagens a partir de uma logo")
    fun generateImages(@RequestPart("info") @Valid request: GenerateImagesRequest,
                       @RequestPart("logo") logo: MultipartFile): GenerateImageResponse

    @GetMapping("/listTemplates")
    fun listTemplate(): ListTemplateResponse
}