# ESPECIFICACIÓN DEL PROTOCOLO

Este es un protocolo define la estrucutura de los mensajes que seran enviando por medio de la aplicacion, este protocolo gestionara el tipo de mensajes intercambiados, la sintaxis con la cual seran contruidos cada uno de los mensajes que seran enviados, asi como tambien semantica para su correcto procesamiento y definira las reglas para el proceso de envio y recepcion de los mensajes.

El protocolo usa diversos tipos de peticiones las cuales son enviadas o recibidas segun como sean solicitadas, el servidor siempre esta atento a cualquier peticion del cliente y este responde en funcion de la peticion solicitada con su respectivo mensaje y codigo de respuesta.

El mensaje de solicitud de autenticacion se presenta cuando un cliente necesita aquirir los servicios del servidor, el cliente debera presentar credenciales de autenticacion y demostrar que esta registrado en la base de datos del servidor, todo esto sera manejado mediante el protocolo HTTP, por lo que seran implementados todas las caracteristicas y estructuras para el uso de este protocolo en la aplicacion.

Los mensajes que se intercambian mendiante el protocolo diseñado para la apliacion tienen un codigo que los identifican, este codigo empieza a ser un consecutico dentro de la transaccion, esto para poder retomarlos a la hora de generar una respuesta del estado de la transaccion realizada con el mensaje enviado.

## Definicion del formato del protocolo

La informacion se envia en una cadena separada por doble barra vertical \|\|. Cuando es necesario enviar un listado de usuarios conectados se usa como separador  
doble ampersand \(&&\)

### Lista de usuarios conectados

```text
Separador componentes: ||    
Comando: #lista_usuarios
token: Cadena de Caracteres que contiene codigo de seguridad generado    
destino: Cadena de Caracteres que contiene el nombre del usuario
objeto: Cadena de Caracteres seperada con doble ampersand que contiene los nombres
de los usuarios conectados

    ejemplo: #LISTA_USUARIOS||FQLSHP||GASO||JUAN&&GERMAN"
```

### Obtener lista solicitudes de usuario

```text
Separador componentes: ||    
Comando: #lista_solicitudes
token: Cadena de Caracteres que contiene codigo de seguridad generado    
destino: Cadena de Caracteres que contiene el nombre del usuario
objeto: Cadena de Caracteres seperada con doble ampersand que contiene los nombres
de los usuarios que han realizado solicitud de amistad    

    ejemplo: "#SOLICITUDES||FQLSHP||GASO||MARIA&&KIRA"
```

### Enviar mensaje

```text
Separador componentes: ||
Comando: #msj    
token: Cadena de Caracteres que contiene codigo de seguridad generado
origen: Cadena de Caracteres que contiene el nombre del usuario
destino: Cadena de Caracteres que contiene el nombre del usuario    
mensaje: string    

    ejemplo: "#MSJ||FQLSHP||GASO||GERMAN||Hola :)"
```

### Enviar archivo

```text
Separador componentes: ||
Comando: #archivo
token: Cadena de Caracteres que contiene codigo de seguridad generado    
origen: Cadena de Caracteres que contiene el nombre del usuario
destino: Cadena de Caracteres que contiene el nombre del usuario
nombre_archivo: Nombre del Archivo que se va a enviar
contenido_archivo: Archivo representando en base64 encode

    ejemplo: "#ARCHIVO||FQLSHP||GASO||JUAN||redes.zip||xptx==..."
```

### Enviar meme

```text
Separador componentes: ||
Comando: #meme
token: Cadena de Caracteres que contiene codigo de seguridad generado    
origen: Cadena de Caracteres que contiene el nombre del usuario
destino: Cadena de Caracteres que contiene el nombre del usuario
nombre_meme: Cadena de Caracteres que tiene el nombre del meme que se va a enviar.

    ejemplo: "#MEME||FQLSHP||GASO||JUAN||meme02.png"
```

### Enviar imagen

```text
Separador componentes: ||
Comando: #img
token: Cadena de Caracteres que contiene codigo de seguridad generado    
origen: Cadena de Caracteres que contiene el nombre del usuario
destino: Cadena de Caracteres que contiene el nombre del usuario    
nombre_archivo: Nombre de imagen que se va a enviar
Contenido_archivo: Archivo representando en base64 encode

    ejemplo: "#IMG||FQLSHP||GASO||JUAN||ARIK.jpeg||xptx==..."    
```

### Enviar solicitud

```text
Separador componentes: ||
Comando: #solicitud
token: Cadena de Caracteres que contiene codigo de seguridad generado    
origen: Cadena de Caracteres que contiene el nombre del usuario
destino: Cadena de Caracteres que contiene el nombre del usuario

    ejemplo: "#SOLICITUD||FQLSHP||GASO||JUAN"    
```

### Respuesta

```text
Comando:#respuesta
Comando a responder:#comando
Separador componentes: ||
destino: Cadena de Caracteres que contiene el nombre del usuario
id: 969999
Estado: Codigo respuesta
token: Cadena de Caracteres que contiene codigo de seguridad generado
```

### Desconectar

```text
Separador componentes: ||
Comando: #desconectar    
token: Cadena de Caracteres que contiene codigo de seguridad generado
origen: Cadena de Caracteres que contiene el nombre del usuario    

    ejemplo: "#DESCONECTAR||FQLSHP||GASO"
```

## Estructura de los mensajes

### Lista de usuarios conectados

```text
   | Comando|| token|| destino de la peticion ||objeto |
    ---------------------------------------------------
```

### Obtener lista solicitudes de usuario

```text
   | Comando|| token|| destino de la peticion ||objeto |
    ---------------------------------------------------
```

### Enviar mensaje

```text
   | Comando|| token||id mensaje||destino del mensaje||Origen del mensaje||mensaje|
    -------------------------------------------------------------------------------
```

### Enviar archivo

```text
   | Comando|| token||id mensaje||destino del mensaje||Origen del mensaje||Nombre archivo||Contenido archivo|
    --------------------------------------------------------------------------------------------------------
```

### Enviar meme

```text
   | Comando|| token||id mensaje||destino del mensaje||Origen del mensaje||Nombre meme|
    ----------------------------------------------------------------------------------
```

### Enviar imagen

```text
   | Comando|| token||id mensaje||destino del mensaje||Origen del mensaje||Nombre imagen||Contenido archivo|
    --------------------------------------------------------------------------------------------------------
```

### Enviar Solicitud

```text
   | Comando|| token||destino de la solicitud||Origen Solicitud||Mensaje|
    --------------------------------------------------------------------
```

### Respuesta

```text
   | Comando|| token||Id respuesta||Comando a responder||destino de respuesta||Estado|
    ---------------------------------------------------------------------------------
```

### Desconectarse

```text
   | Comando|| token||origen||Estado|
    --------------------------------
```

