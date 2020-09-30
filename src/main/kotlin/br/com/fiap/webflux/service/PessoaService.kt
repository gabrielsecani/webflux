package br.com.fiap.webflux.service

import br.com.fiap.webflux.dto.CreatePessoaDTO
import br.com.fiap.webflux.dto.PessoaDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PessoaService {

    fun create (createPessoaDTO: CreatePessoaDTO): Mono<PessoaDTO>

    fun getAll(): Flux<PessoaDTO>

}