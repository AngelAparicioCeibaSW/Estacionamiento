package com.ceiba.adn.estacionamiento.application.common.commandhandleresponse;

import org.springframework.transaction.annotation.Transactional;

public interface CommandHandle<C> {

	@Transactional
	void exec(C command);
}
