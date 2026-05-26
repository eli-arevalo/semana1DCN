package com.duoc.LearningPlatformValidation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.duoc.LearningPlatformValidation.model.Usuario;
import com.duoc.LearningPlatformValidation.repository.UsuarioRepository;



@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> actualizarUsuario(Long id, Usuario usuarioActualizado){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
         if(usuario.isPresent()){

            Usuario usuarioExistente = usuario.get();
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
            usuarioExistente.setPassword(usuarioActualizado.getPassword());
            usuarioExistente.setRol(usuarioActualizado.getRol());
            return Optional.of(usuarioRepository.save(usuarioExistente));

         }else{ 
            return Optional.empty(); 
        } 
    }


}
