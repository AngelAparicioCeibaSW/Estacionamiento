package com.ceiba.adn.estacionamiento.application.common.commandhandleresponse;

import org.springframework.transaction.annotation.Transactional;

public interface CommandHandleResponse<C, R> {

	@Transactional
	R exec(C command);
}
