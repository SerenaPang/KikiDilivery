package com.kikidilivery.api.rest;
import com.kikidilivery.api.dto.UserCreation;
import com.kikidilivery.api.dto.UserUpdate;
import com.kikidilivery.api.dto.UserView;
import com.kikidilivery.api.services.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "User management API")
public class UserController {

    public static final String EMAIL = "email";
    public static final String ROLE = "role";
    public static final String NAME = "name";

    @Autowired
    private UserService userService;

    // GET /users
    @Parameter(in = ParameterIn.QUERY, name = NAME, schema = @Schema(type = "string"), required = false)
    @Parameter(in = ParameterIn.QUERY, name = EMAIL, schema = @Schema(type = "string"), required = false)
    @Parameter(in = ParameterIn.QUERY, name = ROLE, schema = @Schema(type = "string",
            allowableValues = {"SENDER", "DRIVER", "ADMIN"}), required = false)
    @GetMapping
    public List<UserView> all(@RequestParam Map<String, String> filters) {
        return userService.findAllWithFilters(
                filters.get(NAME),
                filters.get(EMAIL),
                filters.get(ROLE)
        );
    }

    // GET /users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<UserView> getById(@PathVariable UUID id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /users
    @PostMapping
    public ResponseEntity<UserView> create(@RequestBody UserCreation dto) {
        UserView created = userService.create(dto);
        return ResponseEntity.status(201).body(created);
    }

    // PUT /users/{id}
    @PutMapping("/{id}")
    public ResponseEntity<UserView> update(@PathVariable UUID id, @RequestBody UserUpdate dto) {
        return userService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /users/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // GET /users/drivers/shipment/{shipmentId}
    @GetMapping("/drivers/shipment/{shipmentId}")
    public List<UserView> getDriversByShipment(@PathVariable UUID shipmentId) {
        return userService.findDriversByShipment(shipmentId);
    }
}