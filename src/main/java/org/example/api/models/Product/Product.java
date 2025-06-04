package org.example.api.models.Product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("productDescription")
    private String productDescription;

    @JsonProperty("keyGenerationType")
    private String keyGenerationType;

    @JsonProperty("keyType")
    private String keyType;

    @JsonProperty("issuanceNotification")
    private boolean issuanceNotification;

    @JsonProperty("allowAdditionalIssuanceNotificationRecipients")
    private boolean allowAdditionalIssuanceNotificationRecipients;

    @JsonProperty("revocationNotification")
    private boolean revocationNotification;

    @JsonProperty("allowAdditionalRevocationNotificationRecipients")
    private boolean allowAdditionalRevocationNotificationRecipients;

    @JsonProperty("authorization")
    private boolean authorization;

    @JsonProperty("allowAdditionalAuthorizationNotificationRecipients")
    private boolean allowAdditionalAuthorizationNotificationRecipients;

    @JsonProperty("allowAdditionalAuthorizationAcceptedNotificationRecipients")
    private boolean allowAdditionalAuthorizationAcceptedNotificationRecipients;

    @JsonProperty("allowAdditionalAuthorizationRejectedNotificationRecipients")
    private boolean allowAdditionalAuthorizationRejectedNotificationRecipients;

    @JsonProperty("renewalRule")
    private boolean renewalRule;

    @JsonProperty("allowAdditionalRenewalNotificationRecipients")
    private boolean allowAdditionalRenewalNotificationRecipients;

    @JsonProperty("publishCertificate")
    private boolean publishCertificate;

    @JsonProperty("clientPublishCertificateOverride")
    private boolean clientPublishCertificateOverride;

    @JsonProperty("clientPublishCertificateOverrideDefault")
    private boolean clientPublishCertificateOverrideDefault;

    @JsonProperty("requiresRegistrationDocuments")
    private boolean requiresRegistrationDocuments;

    @JsonProperty("requiresRegistrationDocumentsOnRegister")
    private boolean requiresRegistrationDocumentsOnRegister;

    @JsonProperty("allowRegistrationDocumentsPDF")
    private boolean allowRegistrationDocumentsPDF;

    @JsonProperty("allowRegistrationDocumentsJPG")
    private boolean allowRegistrationDocumentsJPG;

    @JsonProperty("isCABDNSValidationRequired")
    private boolean cabdnsValidationRequired;

    @JsonProperty("allowAdditionalCABDNSNotificationRecipients")
    private boolean allowAdditionalCABDNSNotificationRecipients;

    @JsonProperty("isCABDNSEmailLinkValidationRequired")
    private boolean cabdnsEmailLinkValidationRequired;

    @JsonProperty("isEmailBoxValidationRequired")
    private boolean emailBoxValidationRequired;

    @JsonProperty("isGenerateRevocationCode")
    private boolean generateRevocationCode;

    @JsonProperty("expirationDate")
    private String expirationDate;

    @JsonProperty("productValidity")
    private ProductValidity productValidity;
}
