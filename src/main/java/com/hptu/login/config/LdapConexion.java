package com.hptu.login.config;

import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.stereotype.Service;

import com.hptu.login.dto.LdapResponseDto;
import com.hptu.login.services.LdapService;
import com.hptu.login.utils.ConstantesGenerales;

@Service
public class LdapConexion implements LdapService {

    private DirContext autenticacionLDAP;

    @Override
    public LdapResponseDto buscarUsuario(String usuario, String password) {
     

        LdapResponseDto response = new LdapResponseDto();


        String usuarioConexion = usuario + ConstantesGenerales.BASE_DN;
		Hashtable<String, String> cadenaConexion = new Hashtable<String, String>();
		cadenaConexion.put(Context.INITIAL_CONTEXT_FACTORY,
				ConstantesGenerales.CONTEXTO);
		cadenaConexion.put(Context.PROVIDER_URL, ConstantesGenerales.LDAP_URL);
		cadenaConexion.put(Context.SECURITY_AUTHENTICATION,
				ConstantesGenerales.TIPO_AUTENTICACION);
		cadenaConexion.put(Context.SECURITY_PRINCIPAL, usuarioConexion);
		cadenaConexion.put(Context.SECURITY_CREDENTIALS, password);
		System.err.println(cadenaConexion);
		try {
			autenticacionLDAP = new InitialDirContext(cadenaConexion);
          //  cargarAtributosUsuario(usuario);
           

            Attributes atributos = null;
		String usuarioBusqueda = usuario.trim();

		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		NamingEnumeration UsuarioLDAP = autenticacionLDAP.search(
				"DC=hptu,DC=org,DC=co", "(& (samaccountname=" + usuarioBusqueda+ ")(objectClass=organizationalPerson))", controls);

		while (UsuarioLDAP.hasMoreElements()) {

			SearchResult ResultadoConsulta = (SearchResult) UsuarioLDAP.next();

			atributos = ResultadoConsulta.getAttributes();

            

        }
        
            response.setCode("200");
            response.setDescription("Exitoso");
            


			System.out.println("Autenticado correctamente");
			
		} catch (AuthenticationException authEx) {
            response.setCode("404");
            response.setDescription("No se encontraron datos!");
			System.out.println("No se encontraron datos!");
			
		} catch (NamingException ex) {

            response.setCode("500");
            response.setDescription("Error Autenticando mediante LDAP, Error causado por : "+ ex.toString());
			System.out.println("Error Autenticando mediante LDAP, Error causado por : "+ ex.toString());
			
		}

        return response;
    }

    

    
}
