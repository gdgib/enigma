package com.g2forge.enigma.backend.text.model.expression;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class TextRepeat implements ITextExpression {
	protected final Object expression;
	
	protected final int repeat;
}
