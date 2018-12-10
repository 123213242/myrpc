package com.frameworkrpc.registry;

import com.frameworkrpc.model.URL;

import java.util.List;
import java.util.Set;

public interface Registry {

	void register(URL url);

	void unregister(URL url);

	void subscribe(URL url, NotifyListener listener);

	void unsubscribe(URL url, NotifyListener listener);

	List<URL> discover(URL url);

	Set<URL> getRegisteredUrls();

}