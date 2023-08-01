package com.br.oprojeto.controller.impl

import com.br.oprojeto.controller.GenerateController
import com.br.oprojeto.controller.data.GenerateImageResponse
import com.br.oprojeto.controller.data.GenerateImagesRequest
import com.br.oprojeto.controller.data.ListTemplateResponse
import com.br.oprojeto.service.GenerateImagesService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile


@RestController
class GenerateControllerImpl(
        private val generateImagesService: GenerateImagesService
) : GenerateController{


    override fun generateImages(request: GenerateImagesRequest, logo: MultipartFile): GenerateImageResponse {
        return generateImagesService.generate(request, logo)
    }

    override fun listTemplate(): ListTemplateResponse {
        return generateImagesService.listTemplate()
    }


}