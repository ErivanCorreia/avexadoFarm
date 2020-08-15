package br.com.avexadoFarm.application.controller;

import br.com.avexadoFarm.application.service.UsuarioServiceImpl;
import br.com.avexadoFarm.domain.model.usuario.Usuario;
import br.com.avexadoFarm.infrastructure.service.ConverterService;
import br.com.avexadoFarm.presentation.dto.usuario.UsuarioRequestDTO;
import br.com.avexadoFarm.presentation.dto.usuario.UsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private ConverterService converterService;

    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> findAll(Pageable pePageable) {
        Page<Usuario> usuarios = usuarioService.findAll(pePageable);
        Page<UsuarioResponseDTO> usuarioResponseDTOS = converterService.converter(usuarios, UsuarioResponseDTO.class);

        return ResponseEntity.ok(usuarioResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        UsuarioResponseDTO usuarioResponseDTO = converterService.converter(usuario, UsuarioResponseDTO.class);
        return ResponseEntity.ok(usuarioResponseDTO);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> save(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = converterService.converter(usuarioRequestDTO, Usuario.class);
        Usuario usuarioSalvo = usuarioService.save(usuario);
        UsuarioResponseDTO usuarioResponseDTO = converterService.converter(usuarioSalvo, UsuarioResponseDTO.class);

        return ResponseEntity.ok(usuarioResponseDTO);
    }
}
