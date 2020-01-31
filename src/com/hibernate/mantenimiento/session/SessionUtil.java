package com.hibernate.mantenimiento.session;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionUtil {

	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory; // La funci�n principal es la creaci�n de instancias de sesi�n.

	static { // La SessionFactory solo se configura una vez por app
		try {
			// Creamos StandardServiceRegistry
			standardServiceRegistry = new StandardServiceRegistryBuilder() // Crea una implementaci�n sin cambiar el c�digo fuente
					.configure() // Lee la configuraci�n de ajustes del hibernate.cfg.xml
					.build();
			// Create MetadataSources // Punto de entrada para trabajar con fuentes de informaci�n de metadatos (mapeo XML, anotaciones). Le dice a Hibernate a hibernate de donde y qu� cargar.
			MetadataSources metadataSources = new MetadataSources(standardServiceRegistry); 
			// Creamos Metadata // Representa el modelo ORM determinado a partir de todas las fuentes de mapeo proporcionadas.
			Metadata metadata = metadataSources.getMetadataBuilder().build(); // Obtiene un generador de metadatos donde se puedan especificar opciones no predeterminadas.
			// Creamos SessionFactory
			sessionFactory = metadata.getSessionFactoryBuilder().build(); // Obtiene el generador de instancias de SessionFactory basado en este metamodelo,
		} catch (Exception e) {
			e.printStackTrace();
			if (standardServiceRegistry != null) {
				// El Objeto standardServiceRegistry deber�a haber sido destruido por SessionFactory,
				// pero si ha hab�do un problema construyendo el SessionFactory debemos destruirlo manualmente.
				StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
			}
		}
	}

	// M�todo utilidad que devuleve el objeto SessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

// Por lo general, una aplicaci�n tiene una �nica instancia de SessionFactory y los subprocesos que atienden las solicitudes del cliente obtienen instancias de sesi�n de esta factory.
// El estado interno de una SessionFactory es inmutable. Una vez creado, se establece este estado interno. Este estado interno incluye todos los metadatos sobre el mapeo objeto / relacional.
// Los implementadores deben ser ThreatSafe.

