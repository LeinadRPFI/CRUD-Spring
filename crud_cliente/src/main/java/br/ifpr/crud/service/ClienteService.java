package br.ifpr.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.ifpr.crud.exception.ApiException;
import br.ifpr.crud.exception.NegocioException;

import br.ifpr.crud.model.Cliente;
import br.ifpr.crud.repository.ClienteRepository;

@Component
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public ResponseEntity<Cliente> inserir(Cliente cliente)
	{
		try {
			cliente = clienteRepository.save(cliente);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);

		} catch (Exception e) {
			throw new ApiException("Erro ao inserir o cliente.");
		}
	}
}
