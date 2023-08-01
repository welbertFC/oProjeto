package com.br.oprojeto.controller.data

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank

@Schema(description = "informações para gerar imagens")
data class GenerateImagesRequest(
        @field:NotBlank(message = "esta informação não pode ser nula ou vazia")
        @field:Schema(description = "numero do whatsapp", example = "03799999999")
        val whatsApp: String,

        @field:NotBlank(message = "esta informação não pode ser nula ou vazia")
        @field:Schema(description = "Endereço", example = "rua tal numero 32, bairro tal")
        val address: String,

        @field:NotBlank(message = "esta informação não pode ser nula ou vazia")
        @field:Schema(description = "id do tempalte", example = "23")
        val idTemplate: String

)
