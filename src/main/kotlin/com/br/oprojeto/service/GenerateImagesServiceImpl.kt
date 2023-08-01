package com.br.oprojeto.service

import com.br.oprojeto.controller.data.GenerateImageResponse
import com.br.oprojeto.controller.data.GenerateImagesRequest
import com.br.oprojeto.controller.data.ListTemplateResponse
import com.br.oprojeto.controller.data.TemplatesImage
import com.br.oprojeto.utils.templateAcai
import com.br.oprojeto.utils.templateDentista
import com.br.oprojeto.utils.templateHamburger
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@Service
class GenerateImagesServiceImpl: GenerateImagesService {
    @OptIn(ExperimentalEncodingApi::class)
    override fun generate(request: GenerateImagesRequest, logo: MultipartFile): GenerateImageResponse {
        val fileEncode64 = Base64.encode(logo.bytes)
        return GenerateImageResponse(
                idTemplate = "123",
                images = listOf(
                        fileEncode64
                )
        )
    }

    override fun listTemplate(): ListTemplateResponse {
        return ListTemplateResponse(listOf(
                TemplatesImage(idTemplate = "1", templateAcai()),
                TemplatesImage(idTemplate = "2", templateHamburger()),
                TemplatesImage(idTemplate = "3", templateDentista())
        ))
    }
}