package br.com.zuporange05.orangetalents05projetoproposta.bloqueio;

import java.net.URI;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zuporange05.orangetalents05projetoproposta.cartoes.Cartao;
import br.com.zuporange05.orangetalents05projetoproposta.cartoes.CartaoFeign;
import br.com.zuporange05.orangetalents05projetoproposta.cartoes.CartaoRepository;
import br.com.zuporange05.orangetalents05projetoproposta.cartoes.StatusCartao;
import feign.FeignException;

@RestController
@RequestMapping("/bloqueio")
public class BloqueioController {

	private CartaoRepository cartaoRepository;

	private CartaoFeign cartaoFeign;

	private BloqueioCartaoRepository bloqueioCartaoRepository;

	public BloqueioController(CartaoRepository cartaoRepository, CartaoFeign cartaoFeign,
			BloqueioCartaoRepository bloqueioCartaoRepository) {

		this.cartaoRepository = cartaoRepository;
		this.cartaoFeign = cartaoFeign;
		this.bloqueioCartaoRepository = bloqueioCartaoRepository;

	}

	@PostMapping("/{id}")
	public ResponseEntity<?> bloquearCartao(@RequestParam("id") Long id, HttpServletRequest request,
			@RequestBody @Valid BloqueioDto bloqueioDto, UriComponentsBuilder uriComponentsBuilder) {

		Optional<Cartao> checaCartao = cartaoRepository.findById(id);

		if (checaCartao.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		if (checaCartao.get().getStatusCartao() == StatusCartao.BLOQUEADO) {

			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Cartao ja bloqueado");

		}

		return bloquearCartao(checaCartao.get(), bloqueioDto, request, uriComponentsBuilder);

	}

	private ResponseEntity<?> bloquearCartao(Cartao cartao, @RequestBody @Valid BloqueioDto bloqueioDto,
			HttpServletRequest request, UriComponentsBuilder uriComponentsBuilder) {

		try {

			BloqueioCartao bloqueioCartao = new BloqueioCartao(request.getLocalAddr(), request.getHeader("user-agent"),
					cartao);
			bloqueioCartao.bloquearCartao(cartao);

			bloqueioCartao = bloqueioCartaoRepository.save(bloqueioCartao);

			cartaoFeign.bloqueioCartao(cartao.getNumeroCartao(), new BloqueioDto(bloqueioDto));

			URI uri = uriComponentsBuilder.path("/bloqueio/{id}").build(bloqueioCartao.getId());
			return ResponseEntity.created(uri).build();

		} catch (FeignException.UnprocessableEntity e) {

			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Falha ao bloquear o cartão.");

		}

	}
}
