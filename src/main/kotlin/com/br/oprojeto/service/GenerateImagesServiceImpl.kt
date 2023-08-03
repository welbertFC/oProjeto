package com.br.oprojeto.service

import com.br.oprojeto.controller.data.GenerateImageResponse
import com.br.oprojeto.controller.data.GenerateImagesRequest
import com.br.oprojeto.controller.data.ListTemplateResponse
import com.br.oprojeto.controller.data.TemplatesImage
import com.br.oprojeto.service.data.RequestTemplateImage
import com.br.oprojeto.service.data.ResponseTemplate
import com.br.oprojeto.utils.templateAcai
import com.br.oprojeto.utils.templateDentista
import com.br.oprojeto.utils.templateHamburger
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class GenerateImagesServiceImpl(
    private val restTemplate: RestTemplate

) : GenerateImagesService {

    override fun generate(request: GenerateImagesRequest): GenerateImageResponse {
        val requestImage = RequestTemplateImage(
            logoBase64 = request.logo,
            whatsApp = request.whatsApp,
            address = request.address,
            templateId = request.idTemplate.toInt()
        )

        val response = restTemplate.postForObject(
            "https://2f01-2804-1e68-c401-8202-f9d4-2cf3-911c-c0a7.ngrok-free.app/render",
            requestImage,
            ResponseTemplate::class.java
        )

        return GenerateImageResponse(
            idTemplate = request.idTemplate,
            images = listOf(
                response?.result ?: "ERRO"
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