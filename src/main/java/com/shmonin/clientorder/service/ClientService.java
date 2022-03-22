package com.shmonin.clientorder.service;

import com.shmonin.clientorder.dto.ClientDto;
import com.shmonin.clientorder.exception.EntityNotFoundException;
import com.shmonin.clientorder.model.Client;
import com.shmonin.clientorder.repository.ClientRepository;
import com.shmonin.clientorder.repository.OrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.shmonin.clientorder.exception.ExceptionMessage.CLIENT;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final OrderRepository orderRepository;

    public List<ClientDto> findAll() {
        return toDto(clientRepository.findAll());
    }

    public ClientDto findById(Long id) {
        return toDto(clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(CLIENT.getMessage(id))));
    }

    public ClientDto save(Client client) {
        return toDto(clientRepository.save(client));
    }

    public void deleteById(Long id) {
        findById(id);
        orderRepository.deleteAllByClientId(id);
        clientRepository.deleteById(id);
    }

    public ClientDto toDto(Client client) {
        var clientDto = new ClientDto();
        clientDto.setName(client.getName());
        clientDto.setPhoneNumber(client.getPhoneNumber());
        clientDto.setTaxpayerIdentificationNumber(client.getTaxpayerIdentificationNumber());
        clientDto.setRegionCode(client.getRegionCode());
        clientDto.setSettlement(client.getSettlement());
        clientDto.setStreet(client.getStreet());
        clientDto.setHouseNumber(client.getHouseNumber());
        clientDto.setBuildingNumber(client.getBuildingNumber());
        clientDto.setRoomNumber(client.getRoomNumber());
        return clientDto;
    }

    public List<ClientDto> toDto(List<Client> clients) {
        return clients.stream().map(this::toDto).collect(toList());
    }
}
