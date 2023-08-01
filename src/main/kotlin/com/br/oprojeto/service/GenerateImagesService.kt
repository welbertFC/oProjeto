package com.br.oprojeto.service

import com.br.oprojeto.controller.data.GenerateImageResponse
import com.br.oprojeto.controller.data.GenerateImagesRequest
import com.br.oprojeto.controller.data.ListTemplateResponse
import org.springframework.web.multipart.MultipartFile

interface GenerateImagesService {

    fun generate(request: GenerateImagesRequest, logo: MultipartFile): GenerateImageResponse

    fun listTemplate(): ListTemplateResponse
}