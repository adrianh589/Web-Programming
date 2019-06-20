package com.hackernews.servicios;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hackernews.dao.usuarioDAO;
import com.hackernews.modelo.usuario;

@Path("usuarios")
public class usuarioServicio {
	
	
	
	//Obtiene un array con todos los usuarios
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerTodosLosUsuarios() {
		List<usuario> lista = usuarioDAO.traerTodosLosUsuarios();
		return Response.ok(lista).build();
	}
	
	//Busca en la bd, el usuario encontrado
	@GET
	@Path("/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerUsuario(@PathParam("nombre") String nombre) {
		usuario user = usuarioDAO.traerUsuarioPorNombre(nombre);
				if(user.getNombreUsuario().equals(nombre)) {
					return Response.ok(user).build();//Si lo encontro, devuelve ese objeto
				}
		return Response.status(Response.Status.NOT_FOUND).build();//Si no lo encontro
	}
	
	//Busca en el array, el usuario encontrado y lo elimina
	@DELETE
	@Path("/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarUsuario(@PathParam("nombre") String nombre) {
			
		int borrado = usuarioDAO.borrar(nombre);
				if(borrado > 0) {
					return Response.ok().build();//Si lo borro correctamente
				}
			
		return Response.status(Response.Status.NOT_FOUND).build();//Si no lo encontro
	}
	
	
	//Inicia sesion sobre un usuario y su contraseña
	@POST
	@Path("/{nombre}/{contra}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response iniciarSesion(@PathParam("nombre") String nombre, @PathParam("contra") String contra) {
		usuario user = usuarioDAO.traerUsuarioPorNombre(nombre);//Trae el objeto usuario
		
		if(user.getContraseña().equals(contra)){
			return Response.ok(user).build();//Si lo encontro, devuelve ese objeto
		}
		return Response.status(Response.Status.NOT_FOUND).build();//Si no lo encontro	
	}
	
	



}
