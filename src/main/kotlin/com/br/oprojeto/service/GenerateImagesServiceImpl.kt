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
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class GenerateImagesServiceImpl(
    private val restTemplate: RestTemplate,

    @Value("\${uri.node}")
    private val uriNode: String

) : GenerateImagesService {

    override fun generate(request: GenerateImagesRequest): GenerateImageResponse {
        val requestImage = RequestTemplateImage(
            logoBase64 = request.logo,
            whatsApp = request.whatsApp,
            address = request.address,
            price = request.price,
            templateId = request.idTemplate.toInt()
        )

        val response = restTemplate.postForObject(
            uriNode,
            requestImage,
            ResponseTemplate::class.java
        )

        return GenerateImageResponse(

            idTemplate = request.idTemplate,
            images = response?.result ?: listOf("Erro")
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