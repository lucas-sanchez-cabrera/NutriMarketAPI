package com.example.nutrimarket.service;

import com.example.nutrimarket.DTO.ClientDTO;
import com.example.nutrimarket.model.Client;
import com.example.nutrimarket.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    /**
     * Muestra todos los clientes existentes.
     *
     * @return  Lista de clientes existentes.
     */
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    /**
     * Muestra un cliente especificado por si 'id'.
     *
     * @param id    Id personal del usuario.
     * @return      Cliente con el mismo id.
     */
    public Client getClient(int id) {
        return clientRepository.findByUserId(id);
    }

    public List<Client> getClientByRol(String rol) {
        return clientRepository.findByUserRol(rol);
    }

    /**
     * Comprueba si existe un usuarui dado su 'email' y su 'password'
     *
     * @param email     Email del usuario.
     * @param password  Contraseña del usuario.
     * @return
     */
    public Client validLogIn(String email, String password) {
        Client user = clientRepository.findByUserEmailAndUserPassword(email, password);
        if (user != null) {
            return user;
        }
        return null;
    }

    /**
     * Eliminación de un cliente dado de su 'password'.
     *
     * @param password  Contraseña del usuario.
     */
    public void deleteClientByPassword(String password) {
        clientRepository.deleteByUserPassword(password);
    }

    public String deleteClientById(int id) {
        String userId = String.valueOf(clientRepository.deleteByUserId(id));
        return "Se elimino correctamente el cliente con ID: { " + userId + " }";
    }

    /**
     * Crea un nuevo cliente.
     *
     * @param clientDTO  Objeto el cuál contiene los datos del nuevo cliente.
     *
     * @return  Respuesta sobre el estado de la creación con la clase 'ResponseEntity'.
     */
    public Client createClient(ClientDTO clientDTO) {
        Client client = new Client();

        if (clientDTO != null) {
            if (!(clientDTO.getUserName().equals("") && clientDTO.getUserEmail().equals("") &&
                    clientDTO.getUserPassword().equals(""))) {
                client.setUserEmail(clientDTO.getUserEmail());
                client.setUserPassword(clientDTO.getUserPassword());
                client.setUserName(clientDTO.getUserName());
                client.setUserAddress(clientDTO.getUserAddress());

                if (clientDTO.getUserRol().equals("") || clientDTO.getUserRol().equals(null)) {
                    client.setUserRol("cliente");
                } else {
                    client.setUserRol(clientDTO.getUserRol());
                }
                return clientRepository.save(client);
            }
        }
        return client;
    }

    /**
     * Modifica los campos de un cliente dado su 'id'.
     *
     * @param id        Id del usuario que queremos modificar.
     * @param clientDTO Objeto el cuál tiene los nuevos datos para la modificación.
     *
     * @return  Cliente con los datos modificados.
     */
    public Client updateClient(int id, ClientDTO clientDTO) {
        Client client = clientRepository.findByUserId(id);

        if (clientDTO != null) {
            if (!(clientDTO.getUserEmail().equals("") && clientDTO.getUserPassword().equals(""))) {
                client.setUserName(clientDTO.getUserName());
                client.setUserPassword(clientDTO.getUserPassword());
                client.setUserEmail(clientDTO.getUserEmail());
                client.setUserAddress(clientDTO.getUserAddress());

                return clientRepository.save(client);
            }
        }
        return null;
    }
}
