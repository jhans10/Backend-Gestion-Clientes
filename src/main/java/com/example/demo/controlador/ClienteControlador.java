package com.example.demo.controlador;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.excepciones.ResourceNotFoundException;
import com.example.demo.modelo.Cliente;
import com.example.demo.repositorio.ClienteRepositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin (origins="http://localhost:4200/")
public class ClienteControlador {
     
	@Autowired
	private ClienteRepositorio repositorio;
	
	//este metodo sirve para listar todos los empleados
	//@CrossOrigin(origins="http://localhost:4200/")
	@GetMapping("/clientes")
	public List<Cliente> listarTodosClientes(){
		
		return repositorio.findAll();
	}
	
	
	//este metodo sirve para guardar el empleado
	//@CrossOrigin(origins="http://localhost:4200/")
	@PostMapping("/clientes")
	public Cliente guargarCliente(@RequestBody Cliente cliente) {
		
		return repositorio.save(cliente);
	}
	
	//este metodo sirve parea buscar un empleado por id
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> obtenerEmpleadoPorId(@PathVariable Long id){
		Cliente cliente = repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("no existe el cliente con dicho id"));
		return ResponseEntity.ok(cliente);
		
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> actualizarEmpleadoPorId(@PathVariable Long id,@RequestBody Cliente detallesCliente ){
		
		Cliente cliente = repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("no existe el cliente con dicho id"));
		cliente.setNombres(detallesCliente.getNombres());
		cliente.setaPaterno(detallesCliente.getaPaterno());
		cliente.setFechaNacimiento(detallesCliente.getFechaNacimiento());
		cliente.setDireccion(detallesCliente.getDireccion());
		cliente.setEmal(detallesCliente.getEmal());
		cliente.setSexo(detallesCliente.getSexo());
		
		Cliente clienteActualizado = repositorio.save(cliente);
		
		return ResponseEntity.ok(clienteActualizado);
		
		
	}
	
	//este metodo sirve para eliminar un empleado
		@DeleteMapping("/clientes/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
			Cliente cliente = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));

			repositorio.delete(cliente);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }
	
	
	
	
}
