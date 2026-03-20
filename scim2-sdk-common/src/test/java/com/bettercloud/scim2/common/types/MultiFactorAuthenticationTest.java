package com.bettercloud.scim2.common.types;

import com.bettercloud.scim2.common.utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests for the MultiFactorAuthentication type: fluent API, serialization
 * round-trip, and equals/hashCode contract.
 */
public class MultiFactorAuthenticationTest
{
  /**
   * Tests that the fluent setters and getters work correctly.
   */
  @Test
  public void testFluentSettersAndGetters()
  {
    MultiFactorAuthentication mfa = new MultiFactorAuthentication()
        .setMultiFactorAuthenticationType(
            MultiFactorAuthentication.MultiFactorAuthenticationType.SMS)
        .setMultiFactorAuthenticationValue("+1-555-555-0123");

    Assert.assertEquals(mfa.getMultiFactorAuthenticationType(),
        MultiFactorAuthentication.MultiFactorAuthenticationType.SMS);
    Assert.assertEquals(mfa.getMultiFactorAuthenticationValue(),
        "+1-555-555-0123");
  }

  /**
   * Tests JSON serialization and deserialization round-trip.
   *
   * @throws Exception if an error occurs.
   */
  @Test
  public void testSerializationRoundTrip() throws Exception
  {
    MultiFactorAuthentication mfa = new MultiFactorAuthentication()
        .setMultiFactorAuthenticationType(
            MultiFactorAuthentication.MultiFactorAuthenticationType.SMS)
        .setMultiFactorAuthenticationValue("+1-555-555-0123");

    String json = JsonUtils.getObjectWriter().writeValueAsString(mfa);

    MultiFactorAuthentication deserialized = JsonUtils.getObjectReader()
        .forType(MultiFactorAuthentication.class).readValue(json);

    Assert.assertEquals(deserialized, mfa);
  }

  /**
   * Tests the equals and hashCode contract.
   */
  @Test
  public void testEqualsAndHashCode()
  {
    MultiFactorAuthentication mfa1 = new MultiFactorAuthentication()
        .setMultiFactorAuthenticationType(
            MultiFactorAuthentication.MultiFactorAuthenticationType.SMS)
        .setMultiFactorAuthenticationValue("+1-555-555-0123");

    MultiFactorAuthentication mfa2 = new MultiFactorAuthentication()
        .setMultiFactorAuthenticationType(
            MultiFactorAuthentication.MultiFactorAuthenticationType.SMS)
        .setMultiFactorAuthenticationValue("+1-555-555-0123");

    MultiFactorAuthentication mfaDifferent = new MultiFactorAuthentication()
        .setMultiFactorAuthenticationType(
            MultiFactorAuthentication.MultiFactorAuthenticationType.SMS)
        .setMultiFactorAuthenticationValue("+1-999-999-9999");

    Assert.assertEquals(mfa1, mfa2);
    Assert.assertEquals(mfa1.hashCode(), mfa2.hashCode());
    Assert.assertNotEquals(mfa1, mfaDifferent);
  }
}
