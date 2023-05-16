/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.backend.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.yoprogramo.backend.service.ModelService;
import com.yoprogramo.backend.model.Model;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;

//header('Access-Control-Allow-Origin: *');
//header("Access-Control-Allow-Headers: X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method, Authorization");
//header("Access-Control-Allow-Methods: GET, POST, OPTIONS, PUT, DELETE, PATCH");
/*@CrossOrigin(origins={"http://localhost:4200", "https://spring-boot-81cbc.web.app", "**"},
        allowedHeaders= {"Origin", "Authorization",""},
        exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials", ""})*/
//@CrossOrigin(allowCredentials="false")/
@CrossOrigin(origins={"http://localhost:4200", "https://spring-boot-81cbc.web.app"})
@RestController
public class Controller {
    
   @Autowired
   private ModelService interModel;
    
    @GetMapping("/")
    public String manzanas() {
        return "Holas";
    }
    
    @GetMapping("/hola")
    public String manzana() {
        return "Hola";
    }
    
    /*@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<Employee> deleteEmployee(@PathVariable Long id) {
        for(Iterator<Employee> itr=this.employees.iterator();itr.hasNext();)
        {
            Employee emp = itr.next();
            Long inId = emp.getId();
            if(inId == (id)){
                itr.remove();
            }
        }
        return this.employees;
    }*/
    
    @GetMapping("/datos/traer")
    public List<Model> getDatos() {
        return interModel.getDatos();
    }
    
    @GetMapping("/datos/traer/ultimo")
    public Model getUltimoDato() {
       List<Model> datos = interModel.getDatos();
        return datos.get(datos.size() -1);
    }
    
    @PostMapping ("/datos/crear")
    public Long createPost(@RequestBody Model model) {
        interModel.savePost(model);
        //System.out.print((getDatos().get(getDatos().size() - 1)).getId());
        return getUltimoDato().getId();
    }
    
    @DeleteMapping ("/datos/borrar/{id}")
    public String detelePost (@PathVariable Long id) {
        interModel.deletePost(id);
        return "El post fue eliminado con éxito";
    }
    
    @ResponseBody
    @PutMapping ("/datos/editar/{id}")
    public Model editPost (@PathVariable Long id, @RequestBody Model datos) {
        Model editPost = interModel.findPost(id);
        
        editPost.setCategoria(datos.getCategoria());
        editPost.setTitulo(datos.getTitulo());
        editPost.setFechaFin(datos.getFechaFin());
        editPost.setFechaInicio(datos.getFechaInicio());
        editPost.setInfo(datos.getInfo());
        
        interModel.savePost(editPost);
        
        return editPost;
    }
    
    @GetMapping ("/datos/buscar/{id}")
    public Model buscarPost (@PathVariable Long id) {
        return interModel.findPost(id);
    }
    /*@ResponseBody
    @PutMapping ("/personas/editar/{id}")
    public Model editPersona (@PathVariable Long id, 
                                @RequestParam("categoria") String nuevoCategoria,
                                @RequestParam("titulo") String nuevoTitulo,
                                @RequestParam("fechaFin") String nuevoFechaFin,
                                @RequestParam("fechaInicio") String nuevoFechaInicio,
                                @RequestParam("info") String nuevoInfo) {
        Model model = interModel.findPersona(id);
        
        model.setCategoria(nuevoCategoria);
        model.setTitulo(nuevoTitulo);
        model.setFechaFin(nuevoFechaFin);
        model.setFechaInicio(nuevoFechaInicio);
        model.setInfo(nuevoInfo);
        
        interModel.savePersona(model);
        
        return model;
    }*/
    
    /*@PostMapping ("api/authenticate")
    public Login Logearse (@RequestParam("user") String username, @RequestParam("password") String pass ) {
        String token = getJWTToken(username);
        
    }*/
    
    /*@PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);

        return ResponseEntity.ok(token);
    }
    
    @PostMapping("user")
	public Login login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(username);
		Login user = new Login();
		user.setUsername(username);
		user.setToken(token);		
		return user;
		
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}*/

            
}
