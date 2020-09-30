package br.com.fiap.webflux.controller

import br.com.fiap.webflux.dto.CreatePessoaDTO
import br.com.fiap.webflux.service.PessoaService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("pessoas")
class PessoaController (
        private val pessoaService: PessoaService
){

    @GetMapping(produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun getAll() = pessoaService.getAll()

    @PostMapping
    fun create(@RequestBody createPessoaDTO: CreatePessoaDTO) = pessoaService.create(createPessoaDTO)

}