package com.bettercloud.scim2.common.types;

import com.bettercloud.scim2.common.annotations.Attribute;

import java.io.Serializable;
import java.util.Objects;

/**
 * Multi-factor authentication method for the user.
 */
public class MultiFactorAuthentication implements Serializable
{

  private static final long serialVersionUID = 6812345678901234567L;

  /**
   * The type of supported multi-factor authentications.
   */
  public enum MultiFactorAuthenticationType
  {
    SMS
  }

  @Attribute(description = "The multi-factor authentication type(MFA) for the User; e.g., 'SMS'",
      canonicalValues = { "SMS" },
      mutability = AttributeDefinition.Mutability.READ_WRITE,
      returned = AttributeDefinition.Returned.DEFAULT,
      uniqueness = AttributeDefinition.Uniqueness.NONE)
  private MultiFactorAuthenticationType multiFactorAuthenticationType;

  @Attribute(description = "The value associated with the multi-factor authentication type(MFA);"
      + " for example, a phone number in E.164 format (e.g., +11234567890) for SMS type MFA.",
      isRequired = true,
      isCaseExact = false,
      mutability = AttributeDefinition.Mutability.READ_WRITE,
      returned = AttributeDefinition.Returned.DEFAULT,
      uniqueness = AttributeDefinition.Uniqueness.NONE)
  private String multiFactorAuthenticationValue;

  /**
   * Retrieves the multi-factor authentication channel type.
   *
   * @return The multi-factor authentication channel type.
   */
  public MultiFactorAuthenticationType getMultiFactorAuthenticationType()
  {
    return multiFactorAuthenticationType;
  }

  /**
   * Specifies the multi-factor authentication channel type.
   *
   * @param multiFactorAuthenticationType The multi-factor authentication
   *                                      channel type.
   * @return This object.
   */
  public MultiFactorAuthentication setMultiFactorAuthenticationType(
      final MultiFactorAuthenticationType multiFactorAuthenticationType)
  {
    this.multiFactorAuthenticationType = multiFactorAuthenticationType;
    return this;
  }

  /**
   * Retrieves the value associated with the multi-factor authentication type.
   *
   * @return The multi-factor authentication value.
   */
  public String getMultiFactorAuthenticationValue()
  {
    return multiFactorAuthenticationValue;
  }

  /**
   * Specifies the value associated with the multi-factor authentication type.
   *
   * @param multiFactorAuthenticationValue The multi-factor authentication
   *                                       value.
   * @return This object.
   */
  public MultiFactorAuthentication setMultiFactorAuthenticationValue(
      final String multiFactorAuthenticationValue)
  {
    this.multiFactorAuthenticationValue = multiFactorAuthenticationValue;
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    final MultiFactorAuthentication that = (MultiFactorAuthentication) o;
    return multiFactorAuthenticationType == that.multiFactorAuthenticationType && Objects.equals(multiFactorAuthenticationValue, that.multiFactorAuthenticationValue);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode()
  {
    int result = multiFactorAuthenticationType != null ?
        multiFactorAuthenticationType.hashCode() : 0;
    result = 31 * result + (multiFactorAuthenticationValue != null ?
        multiFactorAuthenticationValue.hashCode() : 0);
    return result;
  }
}
