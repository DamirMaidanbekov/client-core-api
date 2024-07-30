package kz.dar.university.service.deprecated;

import kz.dar.university.model.ClientModel;

import java.util.List;

public interface ClientServiceOld {
    void createClient(ClientModel clientModel);
    List<ClientModel> getAllClients();
    ClientModel getClientById(String clientId);
    void updateClientById(String clientId, ClientModel clientModel);
    void deleteClientById(String clientId);
}
