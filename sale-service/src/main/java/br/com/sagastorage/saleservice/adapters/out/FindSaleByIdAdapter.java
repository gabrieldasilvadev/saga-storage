package br.com.sagastorage.saleservice.adapters.out;

import br.com.sagastorage.saleservice.adapters.out.repository.SaleRepository;
import br.com.sagastorage.saleservice.adapters.out.repository.mappers.SaleEntityMapper;
import br.com.sagastorage.saleservice.application.core.domain.Sale;
import br.com.sagastorage.saleservice.application.ports.out.FindSaleByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindSaleByIdAdapter implements FindSaleByIdOutputPort {

    private final SaleRepository saleRepository;
    private final SaleEntityMapper saleEntityMapper;

    @Override
    public Optional<Sale> find(Long id) {
        var saleEntity = saleRepository.findById(id);

        return saleEntity.map(saleEntityMapper::toDomain);
    }
}
