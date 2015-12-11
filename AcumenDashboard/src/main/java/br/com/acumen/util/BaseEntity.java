package br.com.acumen.util;

import java.io.Serializable;

public interface BaseEntity<PK> extends Serializable {
	public PK getId();
}
