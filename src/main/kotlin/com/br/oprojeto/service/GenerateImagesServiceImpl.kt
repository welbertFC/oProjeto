package com.br.oprojeto.service

import com.br.oprojeto.controller.data.GenerateImageResponse
import com.br.oprojeto.controller.data.GenerateImagesRequest
import com.br.oprojeto.controller.data.ListTemplateResponse
import com.br.oprojeto.controller.data.TemplatesImage
import com.br.oprojeto.utils.templateAcai
import com.br.oprojeto.utils.templateDentista
import com.br.oprojeto.utils.templateHamburger
import org.springframework.stereotype.Service

@Service
class GenerateImagesServiceImpl : GenerateImagesService {

    override fun generate(request: GenerateImagesRequest): GenerateImageResponse {

        return GenerateImageResponse(
            idTemplate = "123",
            images = listOf(
                request.logo
            )
        )
    }

    override fun listTemplate(): ListTemplateResponse {
        return ListTemplateResponse(
            listOf(
                TemplatesImage(idTemplate = "1", templateAcai()),
                TemplatesImage(idTemplate = "2", templateHamburger()),
                TemplatesImage(idTemplate = "3", templateDentista())
            )
        )
    }
}