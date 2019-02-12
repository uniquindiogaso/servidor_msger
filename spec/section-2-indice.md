# INTRODUCCIÓN

Este protocolo se define con la intención de hacer un datagrama que permita establecer la comunicación por intercambio de paquetes entre ordenadores interconectados mediante la aplicación MSGR UQ.

Este protocolo aporta un procedimiento para que un usuario pueda enviar mensajes a otros a otros usuarios mediante la aplicación MSGR UQ, con un mínimo de mecanismo de protocolo.

Este protocolo utiliza a su vez protocolos de redes locales, para llevar el datagrama a un próximo escenario en internet \(“Gateway”\) o host destino, por ejemplo, hará uso del protocolo TCP para la trasmisión de los datos en la capa de transporte, así como también manejará el protocolo HTTP para establecer la conexión con el servidor al momento de iniciar sesión.

La aplicación contara con códigos de error por defecto, como son los códigos de error del protocolo http, a la hora de conectarse al servidor, es decir:

* 1xx: Informativas 
* 2xx: Peticiones 
* 3xx: Redirecciones 
* 4xx: Errores del cliente 
* 5xx: Errores del servidor.

Adicional a esto, se manejará una serie de código propios para el manejo de los estados del funcionamiento de la aplicación en cuanto al envio de mensajes y administración de usuarios, estos son:

* 6xx: Información 
* 7xx: Éxito 
* 8xx: Advertencias 
* 9xx: Errores del Servidor

{% tabs %}
{% tab title="Códigos Respuesta Generales" %}
* 602: Solicitud de Amistad Aceptada. 
* 603: Solicitud de Amistad Rechazada. 
* 704: Solicitud de Información enviada correctamente. 
* 804: No se encuentra usuario, no se enviara solicitud. 
* 903: Error General, la información suministrada no fue suficiente para enviar solicitud.
{% endtab %}

{% tab title="Códigos Respuesta Login Usuario" %}
* 601 : Se han enviando campos vacíos. 
* 701 : Autenticación Exitosa. 
* 801 : No existe el usuario con los datos proporcionados de autenticacion 
* 802 : Usuario se encuentra bloqueado, no puede iniciar sesión 
* 901 : Error General, usuario y clave no fueron enviados. No se puede comprobar identidad.
{% endtab %}

{% tab title="Códigos Respuesta Actualización Usuarios" %}
* 702: Actualización de Información Correcta. 
* 803: No se logro actualizar la información del usuario. 
* 902: Error General, la información enviada no fue suficiente para actualizar usuario.
{% endtab %}
{% endtabs %}

## Flujo de comunicación

 El flujo de comunicación inicia con una autenticación de usuario empleando una aplicación cliente. En ella, el cliente hace una petición HTTP al servidor y este responde la solicitud indicando si es posible el acceso a la aplicación. una vez autenticado se habilita un Socket para comunicarse con los  clientes que están conectado al servidor, quienes tiene la posibilidad de compartir mensajes, memes, archivos e imágenes.

