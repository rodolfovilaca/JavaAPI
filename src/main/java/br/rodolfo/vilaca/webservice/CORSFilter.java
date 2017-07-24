package br.rodolfo.vilaca.webservice;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext containerRequest,
			ContainerResponseContext containerResponse) {
		containerResponse.getHeaders().add("Access-Control-Allow-Origin", "*");
		containerResponse.getHeaders().add("Access-Control-Allow-Headers", "origin, Content-type, accept, authorization");
		containerResponse.getHeaders().add("Access-Control-Allow-Credentials", "true");
		containerResponse.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		containerResponse.getHeaders().add("Access-Control-Max-Age", "1209600");
	}
}
