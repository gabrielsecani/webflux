package br.com.fiap.webflux.repository

import br.com.fiap.webflux.models.PessoaDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface PessoaRepository: ReactiveMongoRepository<PessoaDocument, String>