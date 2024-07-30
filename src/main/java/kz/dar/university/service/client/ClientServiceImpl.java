package kz.dar.university.service;

import kz.dar.university.entity.ClientEntity;
import kz.dar.university.repository.ClientRepository;
import kz.dar.university.model.ClientModel;
import kz.dar.university.service.deprecated.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void createClient(ClientModel clientModel) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientId(UUID.randomUUID().toString());
        clientEntity.setName(clientModel.getName());
        clientEntity.setSurname(clientModel.getSurname());
        clientEntity.setEmail(clientModel.getEmail());
        clientRepository.save(clientEntity);
    }

    @Override
    public List<ClientModel> getAllClients() {
        return clientRepository.findAll().stream().map(clientEntity -> new ClientModel(
                clientEntity.getClientId(),
                clientEntity.getName(),
                clientEntity.getSurname(),
                clientEntity.getEmail()
        )).collect(Collectors.toList());
    }

    @Override
    public ClientModel getClientById(String clientId) {
        ClientEntity clientEntity = clientRepository.findByClientId(clientId);
        return new ClientModel(
                clientEntity.getClientId(),
                clientEntity.getName(),
                clientEntity.getSurname(),
                clientEntity.getEmail()
        );
    }

    @Override
    public void updateClientById(String clientId, ClientModel clientModel) {
        ClientEntity clientEntity = clientRepository.findByClientId(clientId);
        if (clientEntity != null) {
            clientEntity.setName(clientModel.getName());
            clientEntity.setSurname(clientModel.getSurname());
            clientEntity.setEmail(clientModel.getEmail());
            clientRepository.save(clientEntity);
        }
    }

    @Override
    public void deleteClientById(String clientId) {
        ClientEntity clientEntity = clientRepository.findByClientId(clientId);
        if (clientEntity != null) {
            clientRepository.delete(clientEntity);
        }
    }
}
