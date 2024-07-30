package kz.dar.university.service.deprecated;

import kz.dar.university.model.ClientModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceOldImpl implements ClientServiceOld {
    private static final HashMap<String, ClientModel> clientMap = new HashMap<>();

    static {
        ClientModel client1 = new ClientModel(UUID.randomUUID().toString(), "John", "Doe", "john.doe@example.com");
        ClientModel client2 = new ClientModel(UUID.randomUUID().toString(), "Jane", "Doe", "jane.doe@example.com");
        clientMap.put(client1.getClientId(), client1);
        clientMap.put(client2.getClientId(), client2);
    }

    @Override
    public void createClient(ClientModel clientModel) {
        clientModel.setClientId(UUID.randomUUID().toString());
        clientMap.put(clientModel.getClientId(), clientModel);
    }

    @Override
    public List<ClientModel> getAllClients() {
        return new ArrayList<>(clientMap.values());
    }

    @Override
    public ClientModel getClientById(String clientId) {
        return clientMap.get(clientId);
    }

    @Override
    public void updateClientById(String clientId, ClientModel clientModel) {
        clientModel.setClientId(clientId);
        clientMap.put(clientModel.getClientId(), clientModel);
    }

    @Override
    public void deleteClientById(String clientId) {
        clientMap.remove(clientId);
    }
}
