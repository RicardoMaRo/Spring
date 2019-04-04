package org.plexus.hibernate.spring;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/create")
	@ResponseBody // Lo que devuleva el metodo se dará como respuesta y se visualizará
	public String create(String name, String message) {
		try {
			User user = new User();
			Random r = new Random();
			int randomId = r.nextInt(Integer.MAX_VALUE);
			
			user.setId(randomId);
			user.setUserName(name);
			user.setUserMessage(message);
			
			userDao.create(user);
			return "usuario creado correctamente";
		} catch (Exception ex) {
			return "Error en la creación del usuario";
		}
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(int id) {
		try {
			User user = new User();
			user.setId(id);
			userDao.delete(user);
		} catch (Exception ex) {
			return "Error en la eliminación del usuario" + ex.toString();
		}
		return "usuario eliminado correctamente";
	}

	@RequestMapping(value = "/update")
	public String updateName(int id, String name, String message) {
		try {
			User user = userDao.getById(id);
			user.setUserName(name);
			user.setUserMessage(message);
			userDao.update(user);
		} catch (Exception ex) {
			return "Error actualizando el usuario: " + ex.toString();
		}
		return "Usuario actualizado correctamente";

	}

}
