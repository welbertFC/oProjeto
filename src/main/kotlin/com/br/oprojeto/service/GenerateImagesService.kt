package com.br.oprojeto.service

import com.br.oprojeto.controller.data.GenerateImageResponse
import com.br.oprojeto.controller.data.GenerateImagesRequest
import com.br.oprojeto.controller.data.ListTemplateResponse

interface GenerateImagesService {

    fun generate(request: GenerateImagesRequest): GenerateImageResponse

    fun listTemplate(): ListTemplateResponse
}