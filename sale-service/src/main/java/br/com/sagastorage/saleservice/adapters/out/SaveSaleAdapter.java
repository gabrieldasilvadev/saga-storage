package br.com.sagastorage.saleservice.adapters.out;

import br.com.sagastorage.saleservice.adapters.out.repository.SaleRepository;
import br.com.sagastorage.saleservice.adapters.out.repository.mappers.SaleEntityMapper;
import br.com.sagastorage.saleservice.application.core.domain.Sale;
import br.com.sagastorage.saleservice.application.ports.out.SaveSaleOutputPort;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveSaleAdapter implements SaveSaleOutputPort {

    private final SaleRepository saleRepository;
    private final SaleEntityMapper saleEntityMapper;

    @Override
    public Sale save(Sale sale) {
        return Try.of(() -> saleEntityMapper.toEntity(sale))
                .flatMap(saleEntity -> Try.of(() -> saleRepository.save(saleEntity)))
                .map(saleEntityMapper::toDomain)
                .getOrElseThrow(ex -> new RuntimeException("Error saving sale", ex));
    }
}