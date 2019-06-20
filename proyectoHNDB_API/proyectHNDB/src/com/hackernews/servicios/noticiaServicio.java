package com.hackernews.servicios;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hackernews.dao.noticiaDAO;
import com.hackernews.dao.usuarioDAO;
import com.hackernews.modelo.noticia;
import com.hackernews.modelo.usuario;

@Path("noticias")
public class noticiaServicio {
	
	//Trae todas las noticias
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerTodasLasNoticias() {
		List<noticia> lista = noticiaDAO.obtenerNoticias();
		return Response.ok(lista).build();
	}

}
