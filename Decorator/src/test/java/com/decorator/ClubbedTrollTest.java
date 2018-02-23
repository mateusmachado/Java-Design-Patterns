package com.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import org.junit.jupiter.api.Test;

public class ClubbedTrollTest {

	@Test
	public void testClubbedTroll() throws Exception {

		final Troll simpleTroll = spy(new SimpleTroll());

		final Troll clubbed = new ClubbedTroll(simpleTroll);
		assertEquals(20, clubbed.getAttackPower());
		verify(simpleTroll, times(1)).getAttackPower();

		clubbed.attack();
		verify(simpleTroll, times(1)).attack();

		clubbed.fleeBattle();
		verify(simpleTroll, times(1)).fleeBattle();
		verifyNoMoreInteractions(simpleTroll);
	}
}