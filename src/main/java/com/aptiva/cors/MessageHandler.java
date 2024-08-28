package com.aptiva.cors;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public abstract class MessageHandler {
	protected MessageHandler next;
	protected String status;
	public abstract void handleNextProcess(String processname,Object message);

	public void setNext(MessageHandler next) {
		this.next = next;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
