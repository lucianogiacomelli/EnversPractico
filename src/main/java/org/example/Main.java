package org.example;

import org.example.entidades.*;

//importo la librería JPA (Java Persistence API)
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        // Crear el EntityManagerFactory y el EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            em.getTransaction().begin(); //Se inicia una transacción


            Factura factura1 = Factura.builder()
                    .numero(11)
                    .fecha("2024/02/02")
                    .build();

            Domicilio dom1 = Domicilio.builder()
                    .nombreCalle("Alberdi")
                    .numero(3333)
                    .build();

            Cliente cliente = Cliente.builder()
                    .dni(45257283)
                    .nombre("Luciano")
                    .apellido("Giacomelli")
                    .build();

            cliente.setDomicilio(dom1);
            dom1.setCliente(cliente);
            factura1.setCliente(cliente);

            Categoria perecederos = Categoria.builder()
                    .denominacion("Perecedero")
                    .build();

            Categoria lacteos = Categoria.builder()
                    .denominacion("Lacteos")
                    .build();

            Categoria limpieza = Categoria.builder()
                    .denominacion("Limpieza")
                    .build();

            Articulo art1 = Articulo.builder()
                    .cantidad(200)
                    .denominacion("Yogurt")
                    .precio(20)
                    .build();

            Articulo art2 = Articulo.builder()
                    .cantidad(300)
                    .denominacion("Detergente")
                    .precio(80)
                    .build();

            art1.getCategorias().add(perecederos);
            art1.getCategorias().add(lacteos);
            art2.getCategorias().add(limpieza);

            perecederos.getArticulos().add(art1);
            lacteos.getArticulos().add(art1);
            limpieza.getArticulos().add(art2);

            DetalleFactura det1 = DetalleFactura.builder().build();

            det1.setArticulo(art1);
            det1.setCantidad(2);
            det1.setSubtotal(40);

            art1.getDetalleFacturas().add(det1);
            factura1.getFacturas().add(det1);
            det1.setFactura(factura1);

            DetalleFactura det2 = DetalleFactura.builder().build();

            det2.setArticulo(art2);
            det2.setCantidad(1);
            det2.setSubtotal(80);
            art2.getDetalleFacturas().add(det2);
            factura1.getFacturas().add(det2);
            det2.setFactura(factura1);

            factura1.setTotal(120);


       //  Factura factura1 = em.find(Factura.class, 1L);
         //    factura1.setNumero(200);

            em.persist(factura1);

            //em.merge(factura1);

            em.flush();
            em.getTransaction().commit();
            System.out.println("Se realizó la persistencia de los datos en la base de datos.");
        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
            em.getTransaction().rollback();
        }

        // Cerrar el EntityManager y el EntityManagerFactory
        em.close();
        entityManagerFactory.close();
    }
}