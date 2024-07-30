package kz.dar.university.controller;

import kz.dar.university.model.ClientModel;
import kz.dar.university.service.deprecated.ClientServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientServiceOld clientServiceOld;

    @PostMapping("/create")
    public void createClient(@RequestBody ClientModel clientModel) {
        clientServiceOld.createClient(clientModel);
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClients() {
        return clientServiceOld.getAllClients();
    }

    @GetMapping("/{clientId}")
    public ClientModel getClientById(@PathVariable String clientId) {
        return clientServiceOld.getClientById(clientId);
    }

    @PutMapping("/{clientId}")
    public void updateClientById(@PathVariable String clientId, @RequestBody ClientModel clientModel) {
        clientServiceOld.updateClientById(clientId, clientModel);
    }

    @DeleteMapping("/{clientId}")
    public void deleteClientById(@PathVariable String clientId) {
        clientServiceOld.deleteClientById(clientId);
    }
}
