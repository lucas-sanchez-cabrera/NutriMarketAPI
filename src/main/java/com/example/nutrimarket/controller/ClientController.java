package com.example.nutrimarket.controller;

import com.example.nutrimarket.DTO.ClientDTO;
import com.example.nutrimarket.model.Client;
import com.example.nutrimarket.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable int id) {
        return clientService.getClient(id);
    }

    @GetMapping("/rol")
    public List<Client> getClientByRol(@RequestParam(name = "rol", defaultValue = "cliente") String rol) {
        return clientService.getClientByRol(rol);
    }

    @GetMapping("/login")
    public ResponseEntity<Client> loginUser(@RequestParam(name = "userEmail")String email,
                        @RequestParam(name = "userPassword")String password) {
        Client user = clientService.validLogIn(email, password);
        return (user != null) ?
                ResponseEntity.ok().body(user) :
                ResponseEntity.status(404).body(user);
    }

    @DeleteMapping("/delete/{password}")
    public void deleteClient(@PathVariable String password) {
        clientService.deleteClientByPassword(password);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable int id) {
        return clientService.deleteClientById(id);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.created(null).body(clientService.createClient(clientDTO));
    }

    @PutMapping("/update/{id}")
    public Client updateClient(@PathVariable int id, @RequestBody ClientDTO clientDTO) {
        return clientService.updateClient(id,clientDTO);
    }
}
