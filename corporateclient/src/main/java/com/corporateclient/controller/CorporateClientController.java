package com.corporateclient.controller;


import com.corporateclient.dto.*;
import com.corporateclient.entity.CorporateClient;
import com.corporateclient.service.CorporateClientService;
import com.corporateclient.service.client.UsermanagementFeignClient;
import com.corporateclient.utils.CCUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class CorporateClientController {
    @Autowired
    private CorporateClientService corporateClientService;

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private Environment environment;
    @Autowired
    private CorporateClientContactInfoDto corporateClientContactInfoDto;
    @Autowired
    private UsermanagementFeignClient userManagementClient;

    /*@GetMapping("/verifyCorporateClient")
    public String verifyCorporateClient(@RequestHeader("Authorization") String token) {
        System.out.println("Started execution of verifyCorporateClient");
        // Ensure the token has the "Bearer" prefix
        System.out.println("Token : "+token);
        String orignalTokenValue = token;
        String tokenWithBearer = token.startsWith("Bearer ") ? token : "Bearer " + token;
        System.out.println("tokenWithBearer : "+tokenWithBearer);
        // Call the validateTokenId method from usermanagementservice via Feign client
        //String username = CCUtils.extractSubject(token);

       String username = userManagementClient.validateTokenId(tokenWithBearer);
        System.out.println("UserName : "+username);
        if ("Invalid token".equals(username)) {
            return "Invalid token received from usermanagementservice";
        }

        // Further processing, like checking the user's role, can be done here
        System.out.println("Completed execution of verifyCorporateClient");
        return "Valid corporate client: " + username;
    }
*/
    /*@GetMapping("/getUserDetails/{id}")
    public ResponseEntity<Optional<UserCredential>> getUserDetails(@PathVariable int id) {
        // Use Feign client to call usermanagementservice's fetchAccountDetails method
        ResponseEntity<Optional<UserCredential>> response = userManagementClient.fetchAccountDetails(id);

        // Additional processing or role validation can be done here

        // Return the response received from usermanagementservice
        return response;
    }*/

  /* @Autowired
   private SecurityServiceClient securityServiceClient;

    @PostMapping("/create")
    public ResponseEntity<CreateCorporateClientResponse> createCorporateClient(
            @RequestHeader("Authorization") String token,
            @RequestBody AddCorporateClientRequest request) {

        // Extract token
        String tokenValue = securityServiceClient.extractToken(token);

        // Get username from token
        String username = securityServiceClient.getUserName(tokenValue);

        if (username == null || username.isEmpty()) {
            throw new ApiException("Invalid token or user not found");
        }

        // Get roles by username
        Set<String> userRoles = securityServiceClient.getUserRoles(username);

        // Check if the user has CORPORATE_CLIENT role
        if (userRoles.contains("CORPORATE_CLIENT")) {
            // Proceed to create the corporate client
            CorporateClient corporateClient = corporateClientService.addCorporateClient(request);
            CreateCorporateClientResponse response = new CreateCorporateClientResponse(
                    "success",
                    "Corporate client added successfully",
                    HttpStatus.CREATED.value(),
                    corporateClient
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            throw new ApiException("User does not have CORPORATE_CLIENT role");
        }
    }*/
    @PostMapping("create")
    public ResponseEntity<CreateCorporateClientResponse> createCorporateClient(@RequestBody AddCorporateClientRequest request) {
        CorporateClient corporateClient = corporateClientService.addCorporateClient(request);
        CreateCorporateClientResponse response = new CreateCorporateClientResponse(
                "success",
                "Corporate client added successfully",
                201, // HTTP Status Code for Created
                corporateClient
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CorporateClient> getClientById(@PathVariable Long id) {
        Optional<CorporateClient> client = corporateClientService.getClientById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCorporateClientResponse> updateClient(@PathVariable Long id, @RequestBody UpdateCorporateClientRequest request) {
        CorporateClient updatedClient = corporateClientService.updateClient(id, request);
        if (updatedClient != null) {
            UpdateCorporateClientResponse response = new UpdateCorporateClientResponse(
                    "success",
                    "Corporate client updated successfully",
                    200, // HTTP Status Code for OK
                    updatedClient
            );
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new UpdateCorporateClientResponse(
                            "error",
                            "Corporate client not found",
                            404, // HTTP Status Code for Not Found
                            null
                    ));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCorporateClientResponse> deleteClient(@PathVariable Long id) {
        boolean deleted = corporateClientService.deleteClient(id);
        if (deleted) {
            DeleteCorporateClientResponse response = new DeleteCorporateClientResponse(
                    "success",
                    "Corporate client deleted successfully",
                    200 // HTTP Status Code for OK
            );
            return ResponseEntity.ok(response);
        } else {
            DeleteCorporateClientResponse response = new DeleteCorporateClientResponse(
                    "error",
                    "Corporate client not found",
                    404 // HTTP Status Code for Not Found
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/build-info")
    public ResponseEntity<String> getBuildInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildVersion);
    }

    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("MAVEN_HOME"));
    }

    @GetMapping("/contact-info")
    public ResponseEntity<CorporateClientContactInfoDto> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(corporateClientContactInfoDto);
    }


}