package kz.dar.university.controller;

import kz.dar.university.model.ClientModel;
import kz.dar.university.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public void createClient(@RequestBody ClientModel clientModel) {
        clientService.createClient(clientModel);
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public ClientModel getClientById(@PathVariable String clientId) {
        return clientService.getClientById(clientId);
    }

    @PutMapping("/{clientId}")
    public void updateClientById(@PathVariable String clientId, @RequestBody ClientModel clientModel) {
        clientService.updateClientById(clientId, clientModel);
    }

    @DeleteMapping("/{clientId}")
    public void deleteClientById(@PathVariable String clientId) {
        clientService.deleteClientById(clientId);
    }
}
