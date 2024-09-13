# Proyecto de JPA con Envers

## Introducción
Este proyecto es un ejemplo de cómo se puede implementar auditoría y control de versiones en una aplicación basada en bases de datos. El propósito es llevar un registro detallado de todos los cambios realizados en la base de datos, asegurando tanto la integridad como la transparencia en la gestión de los datos.

## Características
Auditoría: Cada modificación en la base de datos se registra, incluyendo la fecha, la hora, el usuario responsable del cambio y los detalles específicos de la operación.
Versionado: Se mantiene un historial de versiones para cada registro, lo que permite revisar cómo ha cambiado la información a lo largo del tiempo.
## Tecnologías utilizadas
Java: El lenguaje de programación principal para desarrollar la aplicación.
Hibernate: Un framework de persistencia para gestionar la interacción con la base de datos.
Envers: Una biblioteca de Java que facilita la auditoría y el versionado automático de las entidades.
## Funcionamiento
Registro de modificaciones: Cada vez que se produce una modificación en la base de datos, se guarda un registro en una tabla de auditoría.
Creación de versiones: Cada cambio en un registro genera una nueva versión que se almacena, permitiendo tener un seguimiento histórico.
Consulta de versiones: Es posible consultar las versiones anteriores de un registro para verificar cómo ha evolucionado la información.
## Ventajas
Integridad de datos: Se garantiza un control adecuado sobre los datos, al llevar un registro de todas las modificaciones.
Transparencia: Los cambios en los datos son rastreables, mostrando quién hizo la modificación y cuándo.
Seguridad: Permite revertir cambios no deseados mediante el acceso al historial de versiones de cada registro.
### Autor
#### Luciano Giacomelli - Desarrollo de Software - Legajo 50692 - Comisión 3K10