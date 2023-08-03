package com.br.oprojeto.service.data

data class RequestTemplateImage(
    val logoBase64: String,
    val whatsApp: String,
    val address: String,
    val templateId: Int
)
