package br.rodolfo.vilaca.webservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import br.rodolfo.vilaca.dto.Product;

public class ProductWSImpl implements ProductWS {
	Map<Integer ,Product> productMap = new HashMap<Integer ,Product>();
	@Override
	public Response add(Product product) {
//		Product productModel = new Product(product.getId(),product.getName(),
//				product.getPrice(),product.getDescription(),product.getQuantity());
		System.out.println("add() called");
		productMap.put(product.getId(), product);
		return Response.ok().build();
	}

	@Override
	public Response update(Product product) {
		productMap.put(product.getId(), product);
		return Response.ok().build();
	}

	@Override
	public Response delete(int id) {
		productMap.remove(id);
		return Response.ok().build();
	}

	@Override
	public Response find(int id) {
		Product product = productMap.get(id);
		return Response.ok(product)
//				.header("Access-Control-Allow-Origin", "*")
//	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//	            .header("Access-Control-Allow-Credentials", "true")
//	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//	            .header("Access-Control-Max-Age", "1209600")
	            .build();
	}

	@Override
	public Response findAll() {
		List<Product> productList = new ArrayList<>();
		for (Entry<Integer, Product> entry : productMap.entrySet()){
			productList.add(entry.getValue());
		}
		GenericEntity<List<Product>> list = new GenericEntity<List<Product>>(productList) {};
		return Response.ok(list)
//				.header("Access-Control-Allow-Origin", "*")
//	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//	            .header("Access-Control-Allow-Credentials", "true")
//	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//	            .header("Access-Control-Max-Age", "1209600")
	            .build();
	}

}
