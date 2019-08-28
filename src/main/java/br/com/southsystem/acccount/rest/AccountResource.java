package br.com.southsystem.acccount.rest;

import br.com.southsystem.acccount.entity.Account;
import br.com.southsystem.acccount.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/account")
public class AccountResource {

    private final AccountService service;

    public AccountResource(AccountService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<Account>> getAll(Pageable page) {
        return ResponseEntity.ok(service.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable("id") String id) {
        return service.find(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody Account account) throws Exception {
        return ResponseEntity.ok(service.create(account));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> update (@PathVariable("id") String id,
                                           @RequestBody Account account) throws Exception {
        return ResponseEntity.ok(service.update(id, account));
    }
}
