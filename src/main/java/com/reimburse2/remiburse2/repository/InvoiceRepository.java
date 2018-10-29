package com.reimburse2.remiburse2.repository;

import com.reimburse2.remiburse2.domain.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
