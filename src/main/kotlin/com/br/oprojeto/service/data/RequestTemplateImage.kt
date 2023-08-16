package com.br.oprojeto.service.data

import java.math.BigDecimal

data class RequestTemplateImage(
    val logoBase64: String,
    val whatsApp: String,
    val address: String,
    val price: BigDecimal,
    val templateId: Int
)
