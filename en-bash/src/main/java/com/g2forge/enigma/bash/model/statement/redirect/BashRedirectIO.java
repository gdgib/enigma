package com.g2forge.enigma.bash.model.statement.redirect;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class BashRedirectIO implements IBashRedirect {
	protected final int handle;

	protected final Object target;

	public BashRedirectIO(Object target) {
		this(HBashHandle.UNSPECIFIED, target);
	}
}
