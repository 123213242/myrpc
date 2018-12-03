package com.frameworkrpc.config;

import com.frameworkrpc.registry.RegistryFactory;
import com.frameworkrpc.registry.RegistryService;
import com.frameworkrpc.server.Server;
import com.frameworkrpc.server.ServerFactory;

public class ServiceConfig<T> extends SerRefConfig {
	private static final long serialVersionUID = 4186914879813709242L;
	private T ref;

	public T getRef() {
		return ref;
	}

	public void setRef(T ref) {
		this.ref = ref;
	}

	public void export() {
		checkRef();

		Server server = ServerFactory.createServer(getProtocolURL());
		if (!server.isOpen()) {
			server.doOpen();
		}

		RegistryService registryService = RegistryFactory.createRegistry(getRegistryURL());
		registryService.registerService(getURL());
	}

	private void checkRef() {
		// reference should not be null, and is the implementation of the given interface
		if (ref == null) {
			throw new IllegalStateException("ref not allow null!");
		}
		if (!getInterfaceClass().isInstance(ref)) {
			throw new IllegalStateException("The class "
					+ ref.getClass().getName() + " unimplemented interface "
					+ getInterfaceClass() + "!");
		}
	}

}
