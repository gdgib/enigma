package com.g2forge.enigma.backend.text.model.modifier;

import com.g2forge.enigma.backend.text.model.expression.ITextExpression;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class TextModified implements ITextExpression {
	protected final Object expression;

	protected final ITextModifier modifier;
}
